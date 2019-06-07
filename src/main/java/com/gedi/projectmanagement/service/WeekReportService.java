package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.vo.CodeAndMsg;

import java.util.List;
import java.util.Map;

/**
 * @Author: renpu
 * @Date: 2019/6/2 15:37
 * @Description:
 */
public interface WeekReportService {

    //展示双周计划表得所有具体内容
    CodeAndMsg selectWeekReportDetial();

    //批量添加新的WeekReport对象；
    String  addWeekReport(List<Weekreport> weekreports);

    //修改WeekReport的进行状态修改为暂停状态
    CodeAndMsg updateWeekReportStop(String wId);

    //修改WeekReport的暂停状态修改为进行状态
    CodeAndMsg updateWeekReportAction(String wId);

    //根据Id值查询相对应的项目中的计划占比值
    CodeAndMsg selectProjectById(String wId);

    //修改动态修改实际占比
    CodeAndMsg updateActual(String wId, int valueZ);


}