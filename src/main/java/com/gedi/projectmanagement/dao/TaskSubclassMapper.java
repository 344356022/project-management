package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.TaskSubclass;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : wangyanbin
 * @date :
 */
@Mapper
public interface TaskSubclassMapper {
    int deleteByPrimaryKey(String tsId);

    int insert(TaskSubclass record);

    int insertSelective(TaskSubclass record);

    TaskSubclass selectByPrimaryKey(String tsId);

    int updateByPrimaryKeySelective(TaskSubclass record);

    int updateByPrimaryKey(TaskSubclass record);

    //新增项目任务子类
    public void addTaskSubclass(TaskSubclass taskSubclass);
}