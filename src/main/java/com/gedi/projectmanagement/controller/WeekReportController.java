package com.gedi.projectmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gedi.projectmanagement.config.AuthHelper;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.service.TaskSubClassService;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.util.DetialDayDate;
import com.gedi.projectmanagement.util.TimeChange;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.WeekRportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    private SysUserService sysUserService;

    @Autowired
    private ProjectPlanService projectPlanService;

    @Autowired
    private TaskSubClassService taskSubClassService;



    //查询双周计划表展示具体的内容以及完成的占比；
    @PostMapping("selectWeekReportDetial")
    public CodeAndMsg selectWeekReportDetial(String wStarTime,String wEndTime,String authCode, HttpServletRequest request) {

        String timeStart = TimeChange.getTime(wStarTime);
        String timeEnd = TimeChange.getTime(wEndTime);
        System.out.println(timeStart+"-----asdfasdfasdfasdf-----"+timeEnd);
        CodeAndMsg codeAndMsg=new CodeAndMsg();
        /*String userId = LoginUtil.login(authCode);
        SysUser sysUser = sysUserService.queryUserDetail(userId);
        String department = sysUser.getDepartment();*/
        HttpSession session = request.getSession();
        session.setAttribute("department","[117572421]");
        if(weekReportService.selectWeekReportDetial("[117572421]",timeStart,timeEnd)!=null){
            return weekReportService.selectWeekReportDetial("[117572421]",timeStart,timeEnd);
        }else{
            codeAndMsg.setResult(false);
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("用户不存在");
            return codeAndMsg;
        }

    }


    //将周计划设定的具体内容进行保存；
    @PostMapping(value = "createMoreWeekReport", produces = "application/json;charset=UTF-8")
    public CodeAndMsg addWeekReport(@RequestBody String weekreports) {
        CodeAndMsg msg = new CodeAndMsg();
        if (StringUtils.isEmpty(weekreports)) {
            msg.setCode(400);
            msg.setMsg("参数为空");
            msg.setResult(false);
        }else{
            JSONObject jsonObject = JSON.parseObject(weekreports);
            weekreports = jsonObject.getString("weekreports");
            List<WeekRportInfo> weekreportse = JSONArray.parseArray(weekreports, WeekRportInfo.class);
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
    public CodeAndMsg selectDepartmentStaff(HttpSession session) {
        String department = (String)session.getAttribute("uDepartment");
        return sysUserService.selectUserBySign(department);
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




    //获取企业ID值，appkey，serectkey等所必须的参数
    @GetMapping("queryEmterpriseMesg")
    public String queryEmterpriseMesg(HttpServletRequest request){
        CodeAndMsg codeAndMsg=new CodeAndMsg();
        String config = AuthHelper.getConfig(request);
        codeAndMsg.setMsg("获取成功");
        codeAndMsg.setCode(200);
        codeAndMsg.setData(config);
        codeAndMsg.setResult(true);
        return config;
    }

    //根据WeekReport的ID值进行删除；
    @PostMapping("/deleteWeekReportById")
    public CodeAndMsg deleteWeekReportById(String wId){
        return weekReportService.deleteWeekReportById(wId);
    }


}
