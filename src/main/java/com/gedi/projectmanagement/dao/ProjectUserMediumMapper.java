package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectUserMedium;

public interface ProjectUserMediumMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectUserMedium record);

    int insertSelective(ProjectUserMedium record);

    ProjectUserMedium selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectUserMedium record);

    int updateByPrimaryKey(ProjectUserMedium record);
}