package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelperTable;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.TaskClassService;
import com.gedi.projectmanagement.util.TimeChange;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName : MaintenanceProjectController
 * @Package : com.gedi.projectmanagement.controller
 * @Description : 项目维护
 * @Author : wangyanbin
 * @Date : 2019/6/3 0005 下午 2:46
 * @Version : 1.0
 */
@RestController
@RequestMapping("/MaintenanceProject")
public class MaintenanceProjectController {

    @Resource
    private ProjectPlanService projectPlanService;

    @Resource
    private TaskClassService taskClassService;

    /**
     * @param
     * @return
     * @Description : 添加新的项目总计划
     */
    @PostMapping("/addProject")
    public CodeAndMsg addProject1(String pName,String pStartTime,String pEndTime,Integer pProjectPhaseId,Integer pProgress, HttpServletRequest request) {

       ProjectPlan projectPlan=new ProjectPlan();
       projectPlan.setpName(pName);
       String startTime = TimeChange.getTime(pStartTime);
       String endTime = TimeChange.getTime(pEndTime);
       projectPlan.setpStartTime(startTime);
       projectPlan.setpEndTime(endTime);
       projectPlan.setpProjectPhaseId(pProjectPhaseId);
       projectPlan.setpProgress(pProgress);
        CodeAndMsg msg = new CodeAndMsg();
        if (null == projectPlan) {
            msg.setCode(400);
            msg.setMsg("参数不能为空");
            msg.setResult(false);
        } else {
            String flag = this.projectPlanService.addProject(projectPlan, request);
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("新增成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("新增失败");
                msg.setResult(false);
            }
        }
        return msg;
    }

    /**
     * @param items
     * @return
     * @Description : 添加新的项目总计划新增项目中的任务类和任务子类列表
     */
    @PostMapping("/addProjectList")
    public CodeAndMsg addTaskSubclass(@RequestBody String items, HttpServletRequest request) {
        CodeAndMsg msg = new CodeAndMsg();
        if (null == items) {
            msg.setCode(400);
            msg.setMsg("参数不能为空");
            msg.setResult(false);
        } else {
            JSONObject jsonObject = JSON.parseObject(items);
            items = jsonObject.getString("items");
            List<ActionItem> actionItems = JSONArray.parseArray(items, ActionItem.class);
            String flag = this.taskClassService.addTaskClass(actionItems, request);
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("新增成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("新增失败");
                msg.setResult(false);
            }
        }
        return msg;
    }

    //获取企业ID值，appkey，serectkey等所必须的参数
    @GetMapping("/queryEmterpriseMesg")
    @ResponseBody
    public String queryEmterpriseMesg(HttpServletRequest request) {
        CodeAndMsg codeAndMsg = new CodeAndMsg();
        String config = AuthHelperTable.getConfig(request);
        codeAndMsg.setMsg("获取成功");
        codeAndMsg.setCode(200);
        codeAndMsg.setData(config);
        codeAndMsg.setResult(true);
        return config;
    }


}