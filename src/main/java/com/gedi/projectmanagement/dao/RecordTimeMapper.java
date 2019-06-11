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

}
