package com.gedi.projectmanagement.service.system;

import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysUser;

/** 获取系统部门，以及对系统部门操作
 * @Author: zhang xingya
 * @Date: 2019/6/29
 * @Version: 1.0
 */
public interface SysDepartmentService {

    /**
     * 抓取钉钉中的部门信息，和本地数据库同步
     */
    void doSynchDepartmentTask();

    SysDepartment queryDepartmentDetail(String departmentId);

}
