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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

        return projectPlanService.selectById(pid);
    }

    /**
     * @param projectPlan
     * @return
     * @Description : 添加新的项目总计划
     */
    @PostMapping("/addProject")
    public void addProject(ProjectPlan projectPlan, HttpServletResponse response) throws IOException {

        boolean b = projectPlanService.addProject(projectPlan);
        response.getWriter().print(b);
    }
    /*public Map<String, Object> addProject(ProjectPlan projectPlan) {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            projectPlanService.addProject(projectPlan);
            map.put("code", 2000);
            return map;
        } catch (Exception e) {
            map.put("code", 1000);
            map.put("msg", e.getMessage());
            return map;
        }
    }*/

    /**
     * @param
     * @param
     * @return
     * @Description : 添加新的项目总计划新增项目中的任务类和任务子类
     */
    @PostMapping("/addProjectList")
    public CodeAndMsg addTaskSubclass(String items) {

        CodeAndMsg msg = new CodeAndMsg();
        if (null == items) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        } else {
            items = "[" + items + "]";
            System.out.println(items + "items");
           // String  = JSONArray.toJSONString(form.getList());
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


    /*@PostMapping("/addProjectList")
    public CodeAndMsg addTaskSubclass(String params) {
        CodeAndMsg msg = new CodeAndMsg();
        if (StringUtils.isEmpty(params)) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        } else {
            params = "[" + params + "]";
            List<ActionItem> actionItems = JSONArray.parseArray(params, ActionItem.class);
            String flag = this.taskClassService.addTaskClass(actionItems);;
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("修改成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("修改失败");
                msg.setResult(false);
            }
        }
        return msg;
    }*/
}