package com.gedi.projectmanagement.service.impl.system;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetAdminRequest;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiUserGetAdminResponse;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.system.SysDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.exception.ServiceException;
import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.model.system.SysUserDepartment;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import com.taobao.api.ApiException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取系统用户，以及对系统用户操作 业务逻辑层
 *
 * @Author: zhang xingya
 * @Date: 2019/6/28
 * @Version: 1.0
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    private static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;
    @Resource
    private SysUserDepartmentMapper sysUserDepartmentMapper;




    @Override
    public SysUser queryUserDetail(String userId) {
        return this.sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public CodeAndMsg selectUserBySign(String department) {
        List<SysUser> userList = this.sysUserMapper.selectUserBySign(department);
        List<SysUser> sysUsers = this.sysUserMapper.queryAllStaff();


        if (userList.size() != 0 && userList != null&&!department.equals("[116692111]")) {
            return CodeAndMsgUtil.setOK("查询成功", userList);
        } else if(userList.size() != 0 && userList != null&&department.equals("[116692111]")) {
            return CodeAndMsgUtil.setOK("查询成功", sysUsers);
        }else{
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public CodeAndMsg insertManyUserMessage(List<SysUser> list) {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        if (list.size() != 0) {
            this.sysUserMapper.batchInsert(list);
            codeAndMsg.setMsg("添加成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setCode(200);
        } else {
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);
            codeAndMsg.setMsg("添加失败");
        }
        return codeAndMsg;
    }

    @Override
    public List<SysUser> selectAllUserId() {
        return this.sysUserMapper.selectAllUserId();
    }

    @Override
    public void deleteAllUserMessage() {
        this.sysUserMapper.deleteAllUserMessage();
    }

    @Override
    public CodeAndMsg updateUserMessage() {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        try {
            //调用定时器方法
            this.doSynchUserTask();


            codeAndMsg.setMsg("更新用户信息成功");
            codeAndMsg.setCode(200);
            codeAndMsg.setResult(true);
        } catch (Exception e) {
            codeAndMsg.setMsg("更新用户信息失败");
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);
        }

        return codeAndMsg;
    }

    @Override
    public CodeAndMsg selectUserById(String userId) {
        CodeAndMsg codeAndMsg=new CodeAndMsg();
        SysUser sysUser = this.sysUserMapper.selectUserById(userId);
        if(sysUser != null){
            codeAndMsg.setMsg("查询成功");
            codeAndMsg.setCode(200);
            codeAndMsg.setData(sysUser);
            codeAndMsg.setResult(true);
        }else{
            codeAndMsg.setMsg("查失败");
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);

        }
        return codeAndMsg;
    }

    @Override
    public CodeAndMsg selectAllUser() {
        List<SysUser> userList = this.sysUserMapper.selectAllUser();
        if (userList.size() != 0 && userList != null) {
            return CodeAndMsgUtil.setOK("查询成功", userList);
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public String selectNameByUserId(String userId) {
        return this.sysUserMapper.selectNameByUserId(userId);
    }

    @Override
    public void batchInsertUser(List<SysUser> users) {
        this.sysUserMapper.batchInsert(users);
    }

    @Override
    public void doSynchUserTask() {
        //从数据库里取部门信息
        List<SysDepartment> departmentList = this.sysDepartmentMapper.selectAll();
        List<SysUser> users = new ArrayList<>();
        if(departmentList == null || departmentList.size() == 0){
            return;
        }

        for (SysDepartment department : departmentList) {
            //获取AccessToken
            String accessToken = AccessTokenUtil.getToken();

            DingTalkClient userClient = new DefaultDingTalkClient(URLConstant.URL_USER_LISTBYPAGE);
            OapiUserListRequest request = new OapiUserListRequest();
            request.setDepartmentId(Long.valueOf(department.getDepartmentId()));
            request.setOffset(0L);
            request.setSize(100L);
            request.setOrder("entry_desc");
            request.setHttpMethod("GET");

            OapiUserListResponse listResponse = null;

            try {
                listResponse = userClient.execute(request,accessToken);
                List<OapiUserListResponse.Userlist> userlist = listResponse.getUserlist();
                for (OapiUserListResponse.Userlist ut : userlist) {
                    //将数据封装到自己的实体类
                    SysUser user=new SysUser();
                    user.setUnionId(ut.getUnionid());
                    user.setName(ut.getName());
                    user.setTel(ut.getTel());
                    user.setWorkPlace(ut.getWorkPlace());
                    user.setRemark(ut.getRemark());
                    user.setMobile(ut.getMobile());
                    user.setEmail(ut.getEmail());
                    user.setOrgEmail(ut.getOrgEmail());
                    user.setActive(ut.getActive());
                    user.setIsAdmin(ut.getIsAdmin());
                    user.setIsBoss(ut.getIsBoss());
                    user.setIsHide(ut.getIsHide());
                    user.setPosition(ut.getPosition());
                    user.setAcatar(ut.getAvatar());
                    user.setHiredDate(ut.getHiredDate());
                    user.setJobNumber(ut.getJobnumber());
                    user.setIsLeader(ut.getIsLeader());
                    user.setDepartment(ut.getDepartment());
                    user.setUserId(ut.getUserid());

//                    sys_levelint(11) NULL如果是管理员。管理员角色级别，1:主管理员，2:子管理员
                    users.add(user);
                }
                //调用用户相应增的方法，将数据增添到自己的数据库中；
                this.detailWithUserInfos(users);
            } catch (ApiException e) {
                logger.info("UserServiceImpl 同步部门下面的人员出错>>"+e.getErrMsg());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doSynchAdminTask() throws Exception{
        //获取accessToken
        String accessToken = AccessTokenUtil.getToken();

        DingTalkClient client = new DefaultDingTalkClient(URLConstant.USER_ADMIN);
        OapiUserGetAdminRequest request = new OapiUserGetAdminRequest();
        request.setHttpMethod("GET");

        OapiUserGetAdminResponse adminResponse ; client.execute(request, accessToken);

        try {
            adminResponse = client.execute(request, accessToken);
            List<OapiUserGetAdminResponse.AdminList> adminListList = adminResponse.getAdminList();
            if(adminListList == null || adminListList.size() == 0){
                throw new ServiceException("抓取不到管理员列表,操作停止");
            }else {
                List<SysUser> userList = new ArrayList<>();
                for (OapiUserGetAdminResponse.AdminList dm : adminListList) {
                    SysUser sysUser = new SysUser();
                    sysUser.setUserId(dm.getUserid());
                    sysUser.setSysLevel(dm.getSysLevel());
                    userList.add(sysUser);
                }
                if(userList != null && userList.size() > 0){
                    this.sysUserMapper.batchUpdateUser(userList);
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SysUser> queryCreater() {
        List<SysUser> sysUsers = this.sysUserMapper.queryCreater();
        if(sysUsers.size() != 0 && sysUsers != null){
            return sysUsers;
        }else{
            return null;
        }

    }


    /**
     * 更新用户
     * 更新用户所属部门
     * @param users
     */
    private void detailWithUserInfos(List<SysUser> users){
        if(users == null || users.size() == 0){
            return;
        }else {
            //每次批量增添的数据都需要进行对库表之前存在的数据进行清空
            this.sysUserMapper.deleteAllUserMessage();
            //清空用户-部门关系表
            //"department": [1, 2], 参数类型不清楚，暂不处理
            List<String> userIds = new ArrayList<>();
            List<SysUserDepartment> userDepartments = new ArrayList<>();
            for (SysUser user : users) {
                userIds.add(user.getUserId());
                if(StringUtils.isNotBlank(user.getDepartment())){
                    String department = user.getDepartment();
                    String depart = department.substring(1,department.length()-1);
                    List<String> departIds = Arrays.asList(depart.split(","));
                    for (String departId : departIds) {
                        SysUserDepartment userDepartment = new SysUserDepartment();
                        userDepartment.setUserDepartmentId(UUIDUtil.getUUID2());
                        userDepartment.setDepartmentId(departId);
                        userDepartment.setUserId(user.getUserId());
                        userDepartments.add(userDepartment);
                    }
                }
            }
            this.sysUserMapper.batchInsert(users);
            if(userIds.size() > 0){
                this.sysUserDepartmentMapper.deleteAllMsg(userIds);//清除用户-部门关系
            }
            if(userDepartments != null || userDepartments.size() > 0){
                this.sysUserDepartmentMapper.batchInsert(userDepartments);//新建用户-部门关系
            }
        }
    }

}
