package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.RecordTimeMapper;
import com.gedi.projectmanagement.dao.WeekreportMapper;
import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.model.RecordTime;
import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.DetialDayDate;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.WeekRportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<Weekreport> selectWeekReportDetial(String userDepartment,String wStarTime,String wEndTime) {
        if(weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime).size()!=0&&weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime)!=null){
            return weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime);
        }else{
            return null;
        }
    }


    @Override
    public String addWeekReport(List<WeekRportInfo> weekreports) {
        List<RecordTime> dataList=null;
        List<Weekreport> weekreports1=new ArrayList<>();
        ServletRequestAttributes rr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = rr.getRequest();
        HttpSession session = request.getSession();
        String uDepartment = (String)session.getAttribute("department");
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
                weekreport1.setwPlanProportion(weekreport.getwPlanProportion());
                weekreport1.setwRemark(weekreport.getwRemark());
                weekreport1.setwType(weekreport.getwType());
                weekreport1.setwWorkReport(weekreport.getwWorkReport());
                weekreport1.setUserDepartmet(uDepartment);
                String sTime=weekreport.getwStartTime();
                System.out.println(sTime+"----------中国标准时间sssss--------------");
                List<String> tweleveDayDate= DetialDayDate.getTweleveDayDates(sTime);
                String startTime = tweleveDayDate.get(0);
                String endTime = tweleveDayDate.get(11);
                System.out.println(startTime+"-------------开始时间与结束时间-------------"+endTime);
                weekreport1.setwEndTime(endTime);
                weekreport1.setwStartTime(startTime);
                weekreports1.add(weekreport1);
                 dataList = weekreport.getRecordTimes();
                for (RecordTime recordTime : dataList) {
                    recordTime.setTimeId(UUIDUtil.getUUID2());
                    recordTime.setwId(weekreport1.getwId());
                    List<String> tweleveDayDate1= DetialDayDate.getTweleveDayDates(sTime);
                    for (String s : tweleveDayDate1) {
                        String substring = s.substring(8,10);
                        if(substring.equals(recordTime.getName())){
                            String substring1 = s.substring(5, 10);
                            recordTime.setName(substring1);
                        }
                    }
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
                weekreport1.setwPlanProportion(weekreport.getwPlanProportion());
                weekreport1.setwRemark(weekreport.getwRemark());
                weekreport1.setwType(weekreport.getwType());
                weekreport1.setwWorkReport(weekreport.getwWorkReport());
                weekreport1.setUserDepartmet(uDepartment);
                String sTime=weekreport.getwStartTime();
                System.out.println(sTime+"----------中国标准时间sssss--------------");
                List<String> tweleveDayDate= DetialDayDate.getTweleveDayDates(sTime);
                String startTime = tweleveDayDate.get(0);
                String endTime = tweleveDayDate.get(11);
                System.out.println(startTime+"-------------开始时间与结束时间-------------"+endTime);
                weekreport1.setwEndTime(endTime);
                weekreport1.setwStartTime(startTime);
                weekreports1.add(weekreport1);
                dataList = weekreport.getRecordTimes();
                for (RecordTime recordTime : dataList) {
                    recordTime.setTimeId(UUIDUtil.getUUID2());
                    recordTime.setwId(weekreport1.getwId());
                    List<String> tweleveDayDate1= DetialDayDate.getTweleveDayDates(sTime);
                    for (String s : tweleveDayDate1) {
                        String substring = s.substring(8,10);
                        if(substring.equals(recordTime.getName())){
                            String substring1 = s.substring(5, 10);
                            recordTime.setName(substring1);
                        }
                    }
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
        Weekreport weekreport = weekreportMapper.selectProjectById(wId);
        Integer actualProportion = weekreport.getwActualProportion();
        Integer planproportion = weekreport.getwPlanProportion();
        if(actualProportion==null){
            Double actual = Double.valueOf(planproportion) / new Double(100);
            amount= (int) (actual * valueZ);
            if(amount!=planproportion){
                weekreportMapper.updateActual(wId,amount,valueZ);//20190612 zpl 添加一个传入参数valueZ 日报完成进度
                codeAndMsg.setCode(200);
                codeAndMsg.setMsg("修改状态成功");
                codeAndMsg.setResult(true);
                return codeAndMsg;
            }else {
                weekreportMapper.updateActualAndStatus(wId,amount,valueZ);
                codeAndMsg.setCode(200);
                codeAndMsg.setMsg("修改状态成功");
                codeAndMsg.setResult(true);
                return codeAndMsg;
            }
        }else {
            if(actualProportion<valueZ){
                Double actual = Double.valueOf(planproportion) / new Double(100);
                //通过日报员工的完成进度占比，计算出实际占总工作的占比
                amount= (int) (actual * valueZ);
                if(amount!=planproportion){
                    weekreportMapper.updateActual(wId,amount,valueZ);//20190612 zpl 添加一个传入参数valueZ 日报完成进度
                    codeAndMsg.setCode(200);
                    codeAndMsg.setMsg("修改状态成功");
                    codeAndMsg.setResult(true);
                    return codeAndMsg;
                }else if(amount==planproportion) {
                    weekreportMapper.updateActualAndStatus(wId,amount,valueZ);
                    codeAndMsg.setCode(200);
                    codeAndMsg.setMsg("修改状态成功");
                    codeAndMsg.setResult(true);
                    return codeAndMsg;
                }
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


    @Override
    public CodeAndMsg deleteWeekReportById(String wId) {

        CodeAndMsg codeAndMsg=new CodeAndMsg();
        if(weekreportMapper.selectByWeekReportId(wId)!=null){
            recordTimeMapper.deleteDayDate(wId);
            weekreportMapper.deleteWeekReportById(wId);
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
    public CodeAndMsg dailyAddRecord(Weekreport weekreport) {
        CodeAndMsg codeAndMsg=new CodeAndMsg();
        String userId = weekreport.getUserId();
        SysUser user = sysUserMapper.selectUserById(userId);
        List<String> tweleveDayDate = DetialDayDate.getTweleveDayDate();
        String startTime = tweleveDayDate.get(0);
        String endTime = tweleveDayDate.get(11);
        if(weekreport!=null&&user!=null){
            weekreport.setwId(UUIDUtil.getUUID2());
            weekreport.setwStartTime(startTime);
            weekreport.setwEndTime(endTime);
            weekreport.setwStatus(null);
            String other = weekreport.getwId();
            RecordTime recordTime=new RecordTime();
            recordTime.setTimeId(UUIDUtil.getUUID2());
            recordTime.setwId(other);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String dailyTime = simpleDateFormat.format(date);
            recordTime.setName(dailyTime);
            recordTimeMapper.addDailyTime(recordTime);
            weekreportMapper.dailyAddRecord(weekreport);
            codeAndMsg.setCode(200);
            codeAndMsg.setMsg("添加成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setData(weekreport.getwId());
            return codeAndMsg;
        }else{
            codeAndMsg.setResult(false);
            codeAndMsg.setCode(400);
            codeAndMsg.setMsg("数据有误");
            return codeAndMsg;

        }

    }


}
