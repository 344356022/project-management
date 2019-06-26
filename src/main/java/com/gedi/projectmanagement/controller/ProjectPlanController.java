package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelperProjectTotle;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.util.LoginUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private UserService userService;

    //列表展示所有
    @PostMapping("/listAll")
    public CodeAndMsg selectById(String authCode, HttpServletRequest request) {
        CodeAndMsg codeAndMsg = new CodeAndMsg();
        String userId = LoginUtil.login(authCode);
        CodeAndMsg codeAndMsg1 = userService.selectUserById(userId);
        User user = (User) codeAndMsg1.getData();
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("uDepartment",user.getuDepartment());
        if (user != null) {
            return projectPlanService.selectById();
        } else {
            return projectPlanService.selectById();
        }

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
        List<ProjectPlanList> projectPlanLists = projectPlanService.selectProjectPlanListByPidAndpProjectPhaseId(pId,
                pProjectPhaseId);
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
    public CodeAndMsg selectBypName(String pName, String annualTime) {
        CodeAndMsg msg = new CodeAndMsg();
        ProjectPlan projectPlan = new ProjectPlan();
        projectPlan.setAnnualTime(annualTime);
        projectPlan.setpName(pName);
        List<ProjectPlan> projectPlans = projectPlanService.selectBypName(projectPlan);
        if (null != projectPlans && projectPlans.size() > 0) {
            msg.setCode(200);
            msg.setMsg("查询成功");
            msg.setResult(true);
            msg.setData(projectPlans);
        } else {
            msg.setCode(200);
            msg.setMsg("查询成功");
            msg.setResult(true);
            msg.setData(projectPlans);
        }

        return msg;
    }

    /**
     * 根据年度时间查询项目总体计划
     *
     * @param annualTime
     * @return
     */
    @PostMapping(value = "/selectByTime")
    public CodeAndMsg selectByTime(@RequestBody String annualTime) {
        CodeAndMsg msg = new CodeAndMsg();
        JSONObject jsonObject = JSON.parseObject(annualTime);
        annualTime = jsonObject.getString("annualTime");
        if (null == annualTime || "" == annualTime) {
            msg.setCode(401);
            msg.setMsg("annualTime参数值为空,查询失败");
            msg.setResult(false);
        } else {
            List<ProjectPlan> projectPlans = projectPlanService.selectByTime(annualTime);
            if (null != projectPlans && projectPlans.size() > 0) {
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

    @PostMapping(value = "/deleteProjectBypId")
    public CodeAndMsg deleteProjectBypId(@RequestBody String pId) {
        CodeAndMsg msg = new CodeAndMsg();
        JSONObject jsonObject = JSON.parseObject(pId);
        pId = jsonObject.getString("pId");
        if (null == pId || "" == pId) {
            msg.setCode(401);
            msg.setMsg("pId参数值为空,删除失败");
            msg.setResult(false);
        } else {
            String flag = projectPlanService.deleteProjectBypId(pId);
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("删除成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("删除失败");
                msg.setResult(false);
            }
        }
        return msg;
    }

    //获取企业ID值，appkey，serectkey等所必须的参数
    @GetMapping("queryEmterpriseMesg")
    public String queryEmterpriseMesg(HttpServletRequest request) {
        CodeAndMsg codeAndMsg = new CodeAndMsg();
        String config = AuthHelperProjectTotle.getConfig(request);
        codeAndMsg.setMsg("获取成功");
        codeAndMsg.setCode(200);
        codeAndMsg.setData(config);
        codeAndMsg.setResult(true);
        return config;
    }


}
