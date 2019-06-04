package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyanbin
 * @description 项目维护
 * @data
 */
@Controller
@RequestMapping("/MaintenanceProject")
public class MaintenanceProjectController {

    @Resource
    private ProjectPlanService projectPlanService;

    //列表展示所有
    @RequestMapping("/listAll")
    @ResponseBody
    public CodeAndMsg selectById(){

        return projectPlanService.selectById();
    }

    //添加新的项目总计划
    @RequestMapping("/addProject")
    @ResponseBody
   /* public void addProject(ProjectPlan projectPlan, HttpServletResponse response) throws IOException {

        boolean b =projectPlanService.addProject(projectPlan);
        response.getWriter().print(b);
    }*/
    public Map<String, Object> addProject(ProjectPlan projectPlan){
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
    }


}
