package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : wangyanbin
 * @Description :
 * @date :
 */
@RestController
@RequestMapping("/projectPlan")
public class ProjectPlanController {

    @Resource
    private ProjectPlanService projectPlanService;

    //列表展示所有 别改我的代码
    @RequestMapping("/listAll")
    public CodeAndMsg selectById() {
        System.out.println(projectPlanService.selectById() + "列表展示数据：");
        return projectPlanService.selectById();
    }

    /**
     * 展示所有清单列表
     *
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    @PostMapping(value = "/projectPlanList")
    public CodeAndMsg selectProjectPlanListByPidAndpProjectPhaseId(String pId, Integer pProjectPhaseId) {
        CodeAndMsg msg = new CodeAndMsg();
        List<ProjectPlanList> projectPlanLists = projectPlanService.selectProjectPlanListByPidAndpProjectPhaseId(pId, pProjectPhaseId);
        if (projectPlanLists != null) {
            msg.setCode(200);
            msg.setMsg("查询成功");
            msg.setResult(true);
            msg.setData(projectPlanLists);
        } else {
            msg.setCode(401);
            msg.setMsg("查询失败");
            msg.setResult(false);
        }
        return msg;
    }

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param pName
     * @return
     */
    @PostMapping(value = "/projectBypName")
    public CodeAndMsg selectBypName(String pName) {
        CodeAndMsg msg = new CodeAndMsg();
        List<ProjectPlan> projectPlans = projectPlanService.selectBypName(pName);
        if (projectPlans != null) {
            msg.setCode(200);
            msg.setMsg("查询成功");
            msg.setResult(true);
            msg.setData(projectPlans);
        } else {
            msg.setCode(401);
            msg.setMsg("查询失败");
            msg.setResult(false);
        }
        return msg;
    }

}
