package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.system.SysDepartmentService;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统用户
 *
 * @author zhang xingya
 * @version 1.0
 * @date 2019-06-28
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysDepartmentService sysDepartmentService;

    /**
     * 获取用户信息详情
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @GetMapping("/queryUserDetail/{userId}")
    public CodeAndMsg queryUserDetail(@PathVariable String userId) {
        CodeAndMsg model = new CodeAndMsg();
        if (StringUtils.isEmpty(userId)) {
            model.setMsg("用户ID为空");
            return model;
        }
        SysUser sysUser = sysUserService.queryUserDetail(userId);
        model.setData(sysUser);
        return model;
    }


    /**
     * 获取部门信息详情
     *
     * @param departmentId 部门ID
     * @return 部门信息
     */
    @GetMapping("/queryDepartment/{departmentId}")
    public CodeAndMsg queryDepartmentDetail(@PathVariable String departmentId) {
        CodeAndMsg model = new CodeAndMsg();
        if (StringUtils.isEmpty(departmentId)) {
            model.setMsg("部门ID为空");
            return model;
        }
        SysDepartment sysDepartment = sysDepartmentService.queryDepartmentDetail(departmentId);
        model.setData(sysDepartment);
        return model;
    }

    // 根据项目总计划维护页面的tab页面筛选出所对应的所有员工以及ID值
    @GetMapping("selectUserByTabFlag")
    public CodeAndMsg selectUserByTabFlag(Integer pProjectPhaseId) {
        String department = "";
        if (pProjectPhaseId == 1) {//需求分析
            department = "[117443437]";
        } else if (pProjectPhaseId == 2) {//数据处理
            department = "[119455108]";
        } else if (pProjectPhaseId == 3) {//系统开发
            department = "[117572421]";
        } else {
            return sysUserService.selectAllUser();
        }
        return sysUserService.selectUserBySign(department);
    }

}
