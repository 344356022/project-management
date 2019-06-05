package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.TaskClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskClassMapper {
    /*
    新增项目任务类
     */
    public void addTaskClass(TaskClass taskClass);
}