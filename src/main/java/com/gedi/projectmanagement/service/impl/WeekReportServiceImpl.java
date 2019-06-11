package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.RecordTimeMapper;
import com.gedi.projectmanagement.dao.WeekreportMapper;
import com.gedi.projectmanagement.model.RecordTime;
import com.gedi.projectmanagement.model.Weekreport;

import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/4 9:10
 * @Description:
 */

@Service
@Transactional
public class WeekReportServiceImpl implements WeekReportService {

    @Autowired
    private WeekreportMapper weekreportMapper;

    @Autowired
    private RecordTimeMapper recordTimeMapper;

    @Override
    public CodeAndMsg selectWeekReportDetial() {

        CodeAndMsg codeAndMsg=new CodeAndMsg();

        if(weekreportMapper.selectWeekReportDetial().size()!=0&&weekreportMapper.selectWeekReportDetial()!=null){
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("查询成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setData(weekreportMapper.selectWeekReportDetial());
            return codeAndMsg;
        }else{
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("查询失败");
            codeAndMsg.setResult(false);
            return codeAndMsg;
        }
    }


    @Override
    public String addWeekReport(List<Weekreport> weekreports, List<RecordTime> times) {

        for (Weekreport weekreport : weekreports) {
            weekreport.setwId(UUIDUtil.getUUID2());

            for (RecordTime recordTime : times) {
                recordTime.setTimeId(UUIDUtil.getUUID2());
                recordTime.setwId(weekreport.getwId());
            }
            recordTimeMapper.saveMoreDetialDayDate(times);
        }
            weekreportMapper.addWeekReport(weekreports);
            return "success";

    }

    @Override
    public CodeAndMsg updateWeekReportStop(String wId) {

        CodeAndMsg codeAndMsg=new CodeAndMsg();
        if(weekreportMapper.selectByWeekReportId(wId)!=null){
            weekreportMapper.updateWeekReportStop(wId);
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("修改成功");
            codeAndMsg.setResult(true);
            return codeAndMsg;
        }else {
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("参数为空");
            codeAndMsg.setResult(false);
            return codeAndMsg;
        }

    }

    @Override
    public CodeAndMsg updateWeekReportAction(String wId) {

        CodeAndMsg codeAndMsg=new CodeAndMsg();

        if(weekreportMapper.selectByWeekReportId(wId)!=null){
            weekreportMapper.updateWeekReportAction(wId);
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("修改成功");
            codeAndMsg.setResult(true);
            return codeAndMsg;
        }else{
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("参数为空");
            codeAndMsg.setResult(false);
           return codeAndMsg;
        }

    }


    @Override
    public CodeAndMsg selectProjectById(String wId) {

        CodeAndMsg codeAndMsg=new CodeAndMsg();

        if(weekreportMapper.selectByWeekReportId(wId)!=null){
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("查询成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setData(weekreportMapper.selectProjectById(wId));
            return codeAndMsg;
        }else{
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("参数为空");
            codeAndMsg.setResult(false);
            return codeAndMsg;
        }


    }

    @Override
    public CodeAndMsg updateActual(String wId, int valueZ) {

            CodeAndMsg codeAndMsg=new CodeAndMsg();

            int amount=0;

        if(weekreportMapper.selectByWeekReportId(wId)!=null&&valueZ!=0){
            Weekreport weekreport = weekreportMapper.selectProjectById(wId);
            Integer planproportion = weekreport.getwPlanProportion();
            Double actual = Double.valueOf(planproportion) / new Double(100);

            //通过日报员工的完成进度占比，计算出实际占总工作的占比
            amount= (int) (actual * valueZ);

            weekreportMapper.updateActual(wId,amount);
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("修改状态成功");
            codeAndMsg.setResult(true);
            return codeAndMsg;
        }else{
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("参数为空");
            codeAndMsg.setResult(false);
            return codeAndMsg;
        }
    }


}
