package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.TaskSubclass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskSubclassMapper {
    int deleteByPrimaryKey(String tsId);

    int insert(TaskSubclass record);

    int insertSelective(TaskSubclass record);

    TaskSubclass selectByPrimaryKey(String tsId);

    int updateByPrimaryKeySelective(TaskSubclass record);

    int updateByPrimaryKey(TaskSubclass record);

    //查询全部的任务类子类的名称以及Id值
    List<TaskSubclass> queryTaskSubIdAndName();

    //新增项目任务子类
    public void addTaskSubclass(TaskSubclass taskSubclass);
}