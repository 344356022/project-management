package com.gedi.projectmanagement;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentGetRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.request.OapiUserGetAdminRequest;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiUserGetAdminResponse;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.UserMapper;
import com.gedi.projectmanagement.dao.system.SysDepartmentManagerMapper;
import com.gedi.projectmanagement.dao.system.SysDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.exception.ServiceException;
import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysDepartmentManager;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.model.system.SysUserDepartment;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.taobao.api.ApiException;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.gedi.projectmanagement.util.TestTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTests {

    @Autowired
    private UserService userService;
    @Autowired
    private WeekReportService weekReportService;
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;
    @Resource
    private SysDepartmentManagerMapper sysDepartmentManagerMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserDepartmentMapper sysUserDepartmentMapper;


//    @Autowired
//    private UserMapper userMapper;

    @Test
    public void textGetSysUser() throws Exception {
        //获取accessToken
        String accessToken = AccessTokenUtil.getToken();

        List<SysUser> users = new ArrayList<>();

        List<SysDepartment> departmentList = this.sysDepartmentMapper.selectAll();
        for (SysDepartment department : departmentList) {
            DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/listbypage");
            OapiUserListRequest request1 = new OapiUserListRequest();
            request1.setDepartmentId(Long.valueOf(department.getDepartmentId()));
            request1.setOffset(0L);
            request1.setSize(100L);
            request1.setOrder("entry_desc");
            request1.setHttpMethod("GET");

            OapiUserListResponse listResponse = null;

            try {
                listResponse = client1.execute(request1,accessToken);
                List<OapiUserListResponse.Userlist> userlist = listResponse.getUserlist();
                for (OapiUserListResponse.Userlist ut : userlist) {
                    //将数据封装到自己的实体类
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
//                //调用用户相应增的方法，将数据增添到自己的数据库中；
//                userService.insertManyUserMessage(users);
//                this.userService.deleteAllUserMessage();
//                this.userService.batchInsertUser(users);
                this.detailWithUserInfos(users);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

    }


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





    @Test
    public void textGetSysDepartment() throws Exception {
        //获取accessToken
        String accessToken = AccessTokenUtil.getToken();

        List<SysDepartment> departments = new ArrayList<>();

        DingTalkClient client = new DefaultDingTalkClient(URLConstant.DEPARTMENT_LIST);
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setId("1");//默认取根目录
        request.setHttpMethod("GET");
        request.setFetchChild(true);//递归查询所有的部门
        OapiDepartmentListResponse listResponse;

        try {
            //先抓取部门信息列表
            listResponse = client.execute(request,accessToken);
            List<OapiDepartmentListResponse.Department> departmentList = listResponse.getDepartment();
            if(departmentList == null || departmentList.size() == 0){
                throw new ServiceException("抓取不到部门信息,操作停止");
            }else {
                List<Long> departmentIds = new ArrayList<>();
                for (OapiDepartmentListResponse.Department dm : departmentList) {
                    //再获取部门列表里面的部门详情
                    this.syncDepartmentDetail(dm.getId());
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 钉钉同步部门详情
     * 同时更新部门详情
     * @param departmentId
     */
    private void syncDepartmentDetail(Long departmentId){

        SysDepartment sysDepartment = new SysDepartment();

        //获取AccessToken
        String accessToken = AccessTokenUtil.getToken();

        DingTalkClient client = new DefaultDingTalkClient(URLConstant.DEPARTMENT_DETAIL);
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId(String.valueOf(departmentId));
        request.setHttpMethod("GET");
        OapiDepartmentGetResponse departmentGetResponse ;
        try {
            departmentGetResponse = client.execute(request, accessToken);

            if(departmentGetResponse != null && StringUtils.isNotEmpty(departmentGetResponse.getName())){
                sysDepartment.setDepartmentName(departmentGetResponse.getName());
                sysDepartment.setParentId(String.valueOf(departmentGetResponse.getParentid()));
                sysDepartment.setCreateDeptGroup(departmentGetResponse.getCreateDeptGroup());
                sysDepartment.setAutoAddUser(departmentGetResponse.getAutoAddUser());
                sysDepartment.setDeptHiding(departmentGetResponse.getDeptHiding());
                sysDepartment.setOuterDept(departmentGetResponse.getOuterDept());
                sysDepartment.setOrgDeptOwner(departmentGetResponse.getOrgDeptOwner());
                sysDepartment.setSourceIdentifier(departmentGetResponse.getSourceIdentifier());
                sysDepartment.setDepartmentId(String.valueOf(departmentGetResponse.getId()));

                SysDepartment department = this.sysDepartmentMapper.queryBySource(String.valueOf(departmentGetResponse.getId()));
                if(department == null){ //做插入操作
                    this.sysDepartmentMapper.insertSelective(sysDepartment);
                }else {
                    this.sysDepartmentMapper.updateByPrimaryKeySelective(sysDepartment);
                    //更新部门主管表
                    this.sysDepartmentManagerMapper.deleteByDepartmentId(department.getDepartmentId());
                }
                //插入部门主管表
                if(StringUtils.isNotEmpty(departmentGetResponse.getDeptManagerUseridList())){
                    String users = departmentGetResponse.getDeptManagerUseridList();
                    List<String> userIds = Arrays.asList(users.split("\\|"));
                    List<SysDepartmentManager> managers = new ArrayList<>();
                    for (String userId : userIds) {
                        SysDepartmentManager manager = new SysDepartmentManager();
                        manager.setDmId(UUIDUtil.getUUID2());
                        manager.setDepartmentId(String.valueOf(departmentId));
                        manager.setUserId(userId);
                        managers.add(manager);
                    }
                    this.sysDepartmentManagerMapper.batchInsert(managers);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("获取部门详情失败");
        }
    }


    @Test
    public void testString(){
        String str = "1238791271";
        List<String> userIds = Arrays.asList(str.split("\\|"));
        for (String userId : userIds) {
            System.out.println(userId);
        }
    }

    /**
     * 测试抓取管理员
     */
    @Test
    public void testGetAdmin() throws Exception{
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
                throw new ServiceException("抓取不到部门信息,操作停止");
            }else {
                for (OapiUserGetAdminResponse.AdminList dm : adminListList) {
                    System.out.println(dm.getUserid()+"======"+dm.getSysLevel());
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
