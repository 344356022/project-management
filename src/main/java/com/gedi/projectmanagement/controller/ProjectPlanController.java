package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelperProjectTotle;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ProjectPlanService projectPlanService;

    @Autowired
    private SysUserService sysUserService;

    //列表展示所有
    @PostMapping("/listAll")
    public Map selectById(String authCode, HttpServletRequest request) {
        Map map = new HashMap();
        //String userId = LoginUtil.login(authCode);
        SysUser sysUser = sysUserService.queryUserDetail("0208024548845822");
        List<ProjectPlan> projectPlans = projectPlanService.selectById();
        /*HttpSession session = request.getSession();
        session.setAttribute("user", sysUser);
        session.setAttribute("department", sysUser.getDepartment());*/
        if (sysUser != null) {
            map.put("sysUser", sysUser);
            map.put("projectPlans", projectPlans);
        } else {
            map.put("msg", "查询失败");
        }
        return map;
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
    public CodeAndMsg selectBypName(String pName, String annualTime, Integer pProjectPhaseId) {
        CodeAndMsg msg = new CodeAndMsg();
        ProjectPlan projectPlan = new ProjectPlan();
        projectPlan.setAnnualTime(annualTime);
        projectPlan.setpName(pName);
        projectPlan.setpProjectPhaseId(pProjectPhaseId);
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

    /**
     * 根据pId删除项目总计划
     *
     * @param pId
     * @return
     */
    @PostMapping(value = "/deleteProjectBypId")
    public CodeAndMsg deleteProjectBypId(String pId) {
        CodeAndMsg msg = new CodeAndMsg();
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

    /**
     * 根据pId修改项目总计划
     *
     * @param pName,pStartTime,pEndTime,pProgress,pId
     * @return
     */
    @PostMapping(value = "/updateProjectBypId")
    public CodeAndMsg updateProjectBypId(String pId, String pName, String pStartTime, String pEndTime,
                                         Integer pProgress) {
        CodeAndMsg msg = new CodeAndMsg();
        if (null == pId || "" == pId) {
            msg.setCode(401);
            msg.setMsg("pId参数值为空,修改失败");
            msg.setResult(false);
        } else {
            ProjectPlan projectPlan = new ProjectPlan();
            projectPlan.setpId(pId);
            projectPlan.setpName(pName);
            projectPlan.setpStartTime(pStartTime);
            projectPlan.setpEndTime(pEndTime);
            projectPlan.setpProgress(pProgress);
            Map map = projectPlanService.updateProjectBypId(projectPlan);
            if (map.get("success") == "success") {
                msg.setCode(200);
                msg.setMsg("修改成功");
                msg.setResult(true);
            } else if (map.get("error") == "error") {
                msg.setCode(401);
                msg.setMsg("修改失败");
                msg.setResult(false);
            }
        }
        return msg;
    }

    // 获取企业ID值，appkey，serectkey等所必须的参数
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
