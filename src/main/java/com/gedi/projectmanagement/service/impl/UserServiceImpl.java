package com.gedi.projectmanagement.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.UserMapper;
import com.gedi.projectmanagement.dao.system.SysDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.model.system.SysUserDepartment;
import com.gedi.projectmanagement.service.UserService;
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


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;
    @Resource
    private SysUserDepartmentMapper sysUserDepartmentMapper;




    @Override
    public CodeAndMsg selectUserBySign(String department) {

        if (userMapper.selectUserBySign(department).size() != 0 && userMapper.selectUserBySign(department) != null) {
            return CodeAndMsgUtil.setOK("查询成功", userMapper.selectUserBySign(department));
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public CodeAndMsg insertManyUserMessage(List<User> list) {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        if (list.size() != 0) {
            userMapper.insertManyUserMessage(list);
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
    public List<User> selectAllUserId() {
        return userMapper.selectAllUserId();
    }

    @Override
    public void deleteAllUserMessage() {
        userMapper.deleteAllUserMessage();
    }

    @Override
    public CodeAndMsg updateUserMessage() {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        try {
            //每次批量增添的数据都需要进行对库表之前存在的数据进行清空
            userMapper.deleteAllUserMessage();

            /*116706144:财务部, 116829123:人事行政部, 116692111:实施部,117488653:大数据研发中心],[117572421:开发组, 117568461:创意组, 117443437:需求组]*/

            List<Long> departmentIdValue = new ArrayList<>();

            //开发组部门的Id值；
            departmentIdValue.add(117572421L);

            //财务部ID值
            departmentIdValue.add(116706144L);

            //人事行政部ID值
            departmentIdValue.add(116829123L);

            //实施部ID值
            departmentIdValue.add(116692111L);

            //创意组ID值
            departmentIdValue.add(117568461L);

            //需求组ID值
            departmentIdValue.add(117443437L);


            for (Long aLong : departmentIdValue) {


                String accessToken = AccessTokenUtil.getToken();

                List<User> users = new ArrayList<>();

                DingTalkClient client1 = new DefaultDingTalkClient(URLConstant.URL_USER_LISTBYPAGE);
                OapiUserListRequest request1 = new OapiUserListRequest();
                request1.setDepartmentId(aLong);
                request1.setOffset(0L);
                request1.setSize(100L);
                request1.setOrder("entry_desc");
                request1.setHttpMethod("GET");

                OapiUserListResponse listResponse = null;

                try {
                    listResponse = client1.execute(request1, accessToken);
                    List<OapiUserListResponse.Userlist> userlist = listResponse.getUserlist();
                    for (OapiUserListResponse.Userlist userlist1 : userlist) {
                        //将数据封装到自己的实体类
                        User user = new User();
                        user.setuName(userlist1.getName());
                        user.setUserId(userlist1.getUserid());
                        user.setuDepartment(userlist1.getDepartment());
                        user.setuPhone(userlist1.getMobile());
                        user.setUpStringTime(userlist1.getDepartment());
                        users.add(user);

                    }

                    //调用用户相应增的方法，将数据增添到自己的数据库中；
                    userMapper.insertManyUserMessage(users);
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }

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
        if(userMapper.selectUserById(userId)!=null){
            codeAndMsg.setMsg("查询成功");
            codeAndMsg.setCode(200);
            codeAndMsg.setData(userMapper.selectUserById(userId));
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
        if (userMapper.selectAllUser().size() != 0 && userMapper.selectAllUser()!= null) {
            return CodeAndMsgUtil.setOK("查询成功", userMapper.selectAllUser());
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public String selectNameByUserId(String userId) {
        return userMapper.selectNameByUserId(userId);
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
            this.userMapper.deleteAllUserMessage();
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
