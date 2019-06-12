package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.model.*;

import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.TaskSubClassService;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.DetialDayDate;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.WeekRportInfo;
import com.sun.tools.javac.jvm.Code;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: renpu
 * @Date: 2019/6/4 9:13
 * @Description:
 */

@RestController
@RequestMapping("/weekReport")
public class WeekReportController {

    @Autowired
    private WeekReportService weekReportService;


    @Autowired
    private UserService userService;

    @Autowired
    private ProjectPlanService projectPlanService;

    @Autowired
    private TaskSubClassService taskSubClassService;


    //查询双周计划表展示具体的内容以及完成的占比；
    @GetMapping("selectWeekReportDetial")
    public CodeAndMsg selectWeekReportDetial() {
        return weekReportService.selectWeekReportDetial();
    }


    //将周计划设定的具体内容进行保存；
    @PostMapping(value = "createMoreWeekReport", produces = "application/json;charset=UTF-8")
    public CodeAndMsg addWeekReport(@RequestBody String weekreports) {

        System.out.println("--------------"+weekreports);

        CodeAndMsg msg = new CodeAndMsg();
        if (StringUtils.isEmpty(weekreports)) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        }else{
            JSONObject jsonObject = JSON.parseObject(weekreports);
            weekreports = jsonObject.getString("weekreports");
            List<WeekRportInfo> weekreportse = JSONArray.parseArray(weekreports, WeekRportInfo.class);
            System.out.println(weekreports);
             msg = this.addWeekReport(weekreportse);
        }

        return msg;

    }


    private CodeAndMsg addWeekReport(List<WeekRportInfo> weekreports) {
        CodeAndMsg msg = new CodeAndMsg();
        if (StringUtils.isEmpty(weekreports)) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        } else {
            String flag = weekReportService.addWeekReport(weekreports);
            if ("success".equals(flag)) {
                msg.setCode(200);
                msg.setMsg("保存成功");
                msg.setResult(true);
            } else {
                msg.setCode(401);
                msg.setMsg("保存失败");
                msg.setResult(false);
            }
        }
        return msg;
    }


    //修改WeekReport的进行状态修改为暂停状态
    @PatchMapping("updateWeekReportStop")
    public CodeAndMsg updateWeekReportStop(String wId) {
        return weekReportService.updateWeekReportStop(wId);
    }


    //修改WeekReport的暂停状态修改为进行状态
    @PatchMapping("updateWeekReportAction")
    public CodeAndMsg updateWeekReportAction(String wId) {
        return weekReportService.updateWeekReportAction(wId);
    }


    //根据日报员工手写的百分比进行与实际进行核算比例
    @PatchMapping("updateWeekReportActualProportion")
    public CodeAndMsg selectProjectById(String wId, int wActualProportion) {
        return weekReportService.updateActual(wId, wActualProportion);
    }


    //根据部门以及等级的标识进行查询，分配具体的工作；
    @GetMapping("selectDepartmentStaff")
    public CodeAndMsg selectDepartmentStaff() {
        return userService.selectUserBySign();
    }


    //查询全部任务子类
    @GetMapping("queryTaskSubIdAndName")
    public CodeAndMsg queryTaskSubIdAndName() {
        return taskSubClassService.queryTaskSubIdAndName();
    }

    //将连续十二天的具体所对应的日期进行响应给前台
    @GetMapping("getTwelveDayDate")
    public CodeAndMsg getTwelveDayDate() {
        CodeAndMsg codeAndMsg = new CodeAndMsg();
        if (DetialDayDate.getTweleveDayDate().size() != 0) {
            codeAndMsg.setCode(200);
            codeAndMsg.setResult(true);
            codeAndMsg.setData(DetialDayDate.getTweleveDayDate());
        } else {
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);
            codeAndMsg.setMsg("获取失败");

        }

        return codeAndMsg;
    }

    //获取项目的项目名称以及ID值
    @RequestMapping("selectProjectPlanIdAndName")
    public CodeAndMsg selectProjectPlanIdAndName() {
        return projectPlanService.selectAllProject();
    }

    //根据部门标记进行获取部门下所对应的所有员工以及ID值
    @GetMapping("selectUserByDepartment")
    public CodeAndMsg selectUserByDepartment() {
        return userService.selectUserBySign();
    }


}
