package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.RecordTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/10 8:58
 * @Description:
 */

@Mapper
public interface RecordTimeMapper {

    //批量增添每天的具体的时间进行保存
    void saveMoreDetialDayDate(@Param("list") List<RecordTime> recordTimes);

    //清除所有过期日期
    void deleteAllDate();

    //更改日期的状态；
    void updateSignStatus();

    //根据双周计划的ID值移除所对应的时间
    void  deleteDayDate(String wId);


    //供日报提供的其他任务的时间接口
    void addDailyTime(RecordTime recordTime);


}
