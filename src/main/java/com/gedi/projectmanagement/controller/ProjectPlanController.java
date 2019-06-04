package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : wangyanbin
 * @Description :
 * @date :
 */
@RestController
public class ProjectPlanController {

    @Resource
    private ProjectPlanService projectPlanService;

    //列表展示所有 别改我的代码
    @RequestMapping("/listAll")
    public CodeAndMsg selectById() {
        System.out.println(projectPlanService.selectById() + "列表展示数据：");
        return projectPlanService.selectById();
    }

    // 展示所有清单列表
    @PostMapping(value = "/projectPlanList")
    public CodeAndMsg selectProjectPlanListByPidAndPprojectphase(String pId, Integer pProjectPhase) {
        return projectPlanService.selectProjectPlanListByPidAndPprojectphase(pId, pProjectPhase);
    }

    // 根据pName模糊查询项目总体计划列表展示
    @PostMapping(value = "/projectBypName")
    public CodeAndMsg selectBypName(String pName) {
        return projectPlanService.selectBypName(pName);
    }

}
