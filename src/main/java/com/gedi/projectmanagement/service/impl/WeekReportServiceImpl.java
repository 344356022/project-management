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
    public List<Weekreport> selectWeekReportDetial(String userDepartment,String wStarTime,String wEndTime,String wCreater, Integer wStatus, String pId) {
        if(weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime,wCreater,wStatus,pId).size()!=0&&weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime,wCreater,wStatus,pId)!=null){
            return weekreportMapper.selectWeekReportDetial(userDepartment,wStarTime,wEndTime,wCreater,wStatus,pId);
        }else{
            return null;
        }
    }


    @Override
    public String addWeekReport(List<WeekRportInfo> weekreports) {

        //创建时间集合
        List<RecordTime> dataList=null;

        //创建周计划集合
        List<Weekreport> weekreports1=new ArrayList<>();

        //spring框架获取session的方式
        ServletRequestAttributes rr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = rr.getRequest();
        HttpSession session = request.getSession();

        //从sesson里获取当前登陆用户的部门标识
        String uDepartment = (String)session.getAttribute("department");

        //从session里获取当前
        String wCreater=(String)session.getAttribute("w_creater");

        //遍历从前端传来的数据进行赋值到实体进行操作库表
        for (WeekRportInfo weekreport : weekreports) {

            //判断此数据是否已经在库表存在
            if(weekreport.getwId()!=null){

                //创建周计划的对象
                Weekreport weekreport1=new Weekreport();

                //获取数据在库表的唯一主键值
                String wId =weekreport.getwId();

                //根据唯一的主键值删除对应的时间
                recordTimeMapper.deleteDayDate(wId);

                //根据相应的主键值，清空所有数据
                weekreportMapper.updateWeekReportMesg(wId);

                //将数据进行存储到对象里
                weekreport1.setwId(wId);
                weekreport1.setrFinish(weekreport.getrFinish());
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
                //weekreport1.setrFinish(0);
                weekreport1.setwActualProportion(0);
                weekreport1.setrFinish(weekreport.getrFinish());
                String sTime=weekreport.getwStartTime();

                //根据前端传来的开始时间阶段的值例：“2019-07-15”,计算出连续12天的具体每天对应的日期，获取下标为零所对应的值
                List<String> tweleveDayDate= DetialDayDate.getTweleveDayDates(sTime);
                String startTime = tweleveDayDate.get(0);
               String endTime = tweleveDayDate.get(11);
                //String sendTime = weekreport.getwEndTime();

                //根据前端传送过来的结束时间例：“2019-07-26”，计算出第七天的所对应的具体日期
                //String endTime = DetialDayDate.getSevenDay(sendTime);
                weekreport1.setwEndTime(endTime);
                weekreport1.setwStartTime(startTime);
                weekreport1.setwCreater(wCreater);
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
                //weekreport1.setrFinish(0);
                weekreport1.setwActualProportion(0);
                weekreport1.setrFinish(weekreport.getrFinish());
                String sTime=weekreport.getwStartTime();
                List<String> tweleveDayDate= DetialDayDate.getTweleveDayDates(sTime);
                String startTime = tweleveDayDate.get(0);
                String endTime = tweleveDayDate.get(11);
                //String sendTime = weekreport.getwEndTime();
                //String endTime = DetialDayDate.getSevenDay(sendTime);
                weekreport1.setwEndTime(endTime);
                weekreport1.setwStartTime(startTime);
                weekreport1.setwCreater(wCreater);
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
