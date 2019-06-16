package com.gedi.projectmanagement.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.TaskClass;
import com.gedi.projectmanagement.model.TaskSubclass;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.TaskClassService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //列表展示所有
    @RequestMapping("/listAll")
    public CodeAndMsg selectById(String pid) {

        return projectPlanService.selectById();
    }

    /**
     * @param projectPlan
     * @return
     * @Description : 添加新的项目总计划
     */
    @PostMapping("/addProject")
    public CodeAndMsg addProject1(@RequestBody ProjectPlan projectPlan) {
        CodeAndMsg msg = new CodeAndMsg();
        if (null == projectPlan) {
            msg.setCode(400);
            msg.setMsg("参数不能为空");
            msg.setResult(false);
        } else {
            String flag = this.projectPlanService.addProject(projectPlan);
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
    public CodeAndMsg addTaskSubclass(@RequestBody String items) {
        CodeAndMsg msg = new CodeAndMsg();
        if (null == items) {
            msg.setCode(400);
            msg.setMsg("参数不能为空");
            msg.setResult(false);
        } else {
            JSONObject jsonObject = JSON.parseObject(items);
            items = jsonObject.getString("items");
            List<ActionItem> actionItems = JSONArray.parseArray(items, ActionItem.class);
            String flag = this.taskClassService.addTaskClass(actionItems);
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
}