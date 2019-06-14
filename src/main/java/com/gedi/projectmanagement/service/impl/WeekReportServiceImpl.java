package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.RecordTimeMapper;
import com.gedi.projectmanagement.dao.WeekreportMapper;
import com.gedi.projectmanagement.model.RecordTime;
import com.gedi.projectmanagement.model.Weekreport;

import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.WeekRportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    public String addWeekReport(List<WeekRportInfo> weekreports) {

        List<RecordTime> dataList=null;
        List<Weekreport> weekreports1=new ArrayList<>();
        for (WeekRportInfo weekreport : weekreports) {
            if(weekreport.getwId()!=null){
                Weekreport weekreport1=new Weekreport();
                String wId =weekreport.getwId();
                recordTimeMapper.deleteDayDate(wId);
                weekreportMapper.updateWeekReportMesg(wId);
                weekreport1.setwId(wId);
                weekreport1.setpId(weekreport.getpId());
                weekreport1.setUserId(weekreport.getUserId());
                weekreport1.setTsId(weekreport.getTsId());
                weekreport1.setwStatus(weekreport.getwStatus());
                weekreport1.setwActualProportion(weekreport.getwActualProportion());
                weekreport1.setwPlanProportion(weekreport.getwActualProportion());
                weekreport1.setwRemark(weekreport.getwRemark());
                weekreport1.setwType(weekreport.getwType());
                weekreport1.setwWorkReport(weekreport.getwWorkReport());
                weekreports1.add(weekreport1);
                 dataList = weekreport.getRecordTimes();
                for (RecordTime recordTime : dataList) {
                    recordTime.setTimeId(UUIDUtil.getUUID2());
                    recordTime.setwId(weekreport1.getwId());
                }
                recordTimeMapper.saveMoreDetialDayDate(dataList);
                weekreportMapper.updateMoreWeekReport(weekreports1);
            }else{
                Weekreport weekreport1=new Weekreport();
                weekreport1.setwId(UUIDUtil.getUUID2());
                weekreport1.setpId(weekreport.getpId());
                weekreport1.setUserId(weekreport.getUserId());
                weekreport1.setTsId(weekreport.getTsId());
                weekreport1.setwStatus(weekreport.getwStatus());
                weekreport1.setwActualProportion(weekreport.getwActualProportion());
                weekreport1.setwPlanProportion(weekreport.getwActualProportion());
                weekreport1.setwRemark(weekreport.getwRemark());
                weekreport1.setwType(weekreport.getwType());
                weekreport1.setwWorkReport(weekreport.getwWorkReport());
                weekreports1.add(weekreport1);
                dataList = weekreport.getRecordTimes();
                for (RecordTime recordTime : dataList) {
                    recordTime.setTimeId(UUIDUtil.getUUID2());
                    recordTime.setwId(weekreport1.getwId());
                }
                recordTimeMapper.saveMoreDetialDayDate(dataList);

            }

        }
        weekreportMapper.addWeekReport(weekreports1);
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

            weekreportMapper.updateActual(wId,amount,valueZ);//20190612 zpl 添加一个传入参数valueZ 日报完成进度
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
