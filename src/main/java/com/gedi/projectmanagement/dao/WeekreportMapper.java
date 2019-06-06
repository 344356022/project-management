package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Weekreport;
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
    List<Weekreport> selectById();

    //生成双周计划表
    void  addWeekReport(Weekreport weekreport);

    //修改WeekReport的进行状态修改为暂停状态
    void updateWeekReportStop(String wId);

    //修改WeekReport的暂停状态修改为进行状态
    void updateWeekReportAction(String wId);

    //根据相应的Id值，去查询所对应的项目里的计划百分比；
    Weekreport selectProjectById(String wId);

    //修改动态修改实际占比值
    void updateActual(@Param("wId") String wId, @Param("valueZ") int valueZ);

    //查询weekReport的id是否存在
    Weekreport selectByWeekReportId(String wId);
}