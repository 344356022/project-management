package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author
 * @date
 */
@Controller
public class ProjectPlanController {

    @Resource
    private ProjectPlanService projectPlanService;

    //列表展示所有
    @RequestMapping("/listAll")
    @ResponseBody
    public CodeAndMsg selectById(){
        System.out.println(projectPlanService.selectById() + "列表展示数据：");
        return projectPlanService.selectById();
    }
}
