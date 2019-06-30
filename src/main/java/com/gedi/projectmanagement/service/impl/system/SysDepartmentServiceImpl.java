package com.gedi.projectmanagement.service.impl.system;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentGetRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.system.SysDepartmentManagerMapper;
import com.gedi.projectmanagement.dao.system.SysDepartmentMapper;
import com.gedi.projectmanagement.exception.ServiceException;
import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysDepartmentManager;
import com.gedi.projectmanagement.service.system.SysDepartmentService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.taobao.api.ApiException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取系统部门，以及对系统部门操作 业务逻辑层
 * @Author: zhang xingya
 * @Date: 2019/6/29
 * @Version: 1.0
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Resource
    private SysDepartmentManagerMapper sysDepartmentManagerMapper;


    @Transactional
    @Override
    public void doSynchDepartmentTask() {

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

    @Override
    public SysDepartment queryDepartmentDetail(String departmentId) {

        return this.sysDepartmentMapper.queryBySource(departmentId);
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
            throw new ServiceException("获取部门详情失败");
        }
    }
}
