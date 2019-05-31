package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectPlan;

public interface ProjectPlanMapper {
    int deleteByPrimaryKey(String pId);

    int insert(ProjectPlan record);

    int insertSelective(ProjectPlan record);

    ProjectPlan selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(ProjectPlan record);

    int updateByPrimaryKey(ProjectPlan record);
}