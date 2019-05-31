package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.TaskClass;

public interface TaskClassMapper {
    int deleteByPrimaryKey(String tId);

    int insert(TaskClass record);

    int insertSelective(TaskClass record);

    TaskClass selectByPrimaryKey(String tId);

    int updateByPrimaryKeySelective(TaskClass record);

    int updateByPrimaryKey(TaskClass record);
}