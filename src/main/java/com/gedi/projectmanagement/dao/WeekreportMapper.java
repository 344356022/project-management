package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.vo.WeekRportInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeekreportMapper {
    int deleteByPrimaryKey(String wId);

    int insert(Weekreport record);

    int insertSelective(Weekreport record);

    Weekreport selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(Weekreport record);

    int updateByPrimaryKey(Weekreport record);

    //展示双周计划表得所有具体内容
    List<Weekreport> selectWeekReportDetial();

    //批量添加双周计划表的
    void  addWeekReport(@Param("list") List<Weekreport> weekreports);

    //修改WeekReport的进行状态修改为暂停状态
    void updateWeekReportStop(String wId);

    //修改WeekReport的暂停状态修改为进行状态
    void updateWeekReportAction(String wId);

    //根据相应的Id值，去查询所对应的项目里的计划百分比；
    Weekreport selectProjectById(String wId);

    //修改动态修改实际占比值 20190612 zpl 添加一个传入参数rFinish
    void updateActual(@Param("wId") String wId, @Param("valueZ") int valueZ,@Param("rFinish") int rFinish);

    //查询weekReport的id是否存在
    Weekreport selectByWeekReportId(String wId);

    //更新双周计划的信息
    void updateWeekReportMesg(String wId);

    //批量修改双周计划信息
   void updateMoreWeekReport(@Param("list")List<Weekreport> weekreports);
}