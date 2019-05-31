package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.TaskSubclass;

public interface TaskSubclassMapper {
    int deleteByPrimaryKey(String tsId);

    int insert(TaskSubclass record);

    int insertSelective(TaskSubclass record);

    TaskSubclass selectByPrimaryKey(String tsId);

    int updateByPrimaryKeySelective(TaskSubclass record);

    int updateByPrimaryKey(TaskSubclass record);
}