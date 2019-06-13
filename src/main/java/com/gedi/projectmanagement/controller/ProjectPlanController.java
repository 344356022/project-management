package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName : ProjectPlanController
 * @Package : com.gedi.projectmanagement.controller
 * @Description : 项目总计划页面
 * @Author : wangyanbin
 * @Date : 2019/5/31 0005 上午 4:47
 * @Version : 1.0
 */
@RestController
@RequestMapping("/projectPlan")
public class ProjectPlanController {

    @Resource
    private ProjectPlanService projectPlanService;

    //列表展示所有
    @RequestMapping("/listAll")
    public CodeAndMsg selectById() {

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
    public CodeAndMsg selectBypName(@RequestBody String pName) {
        CodeAndMsg msg = new CodeAndMsg();
        JSONObject jsonObject = JSON.parseObject(pName);
        pName = jsonObject.getString("pName");
        if (null == pName || "" == pName) {
            msg.setCode(401);
            msg.setMsg("pName参数值为空,查询失败");
            msg.setResult(false);
        } else {
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
        }
        return msg;
    }

}
