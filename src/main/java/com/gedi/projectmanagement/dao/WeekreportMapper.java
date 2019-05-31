package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.Weekreport;

public interface WeekreportMapper {
    int deleteByPrimaryKey(String wId);

    int insert(Weekreport record);

    int insertSelective(Weekreport record);

    Weekreport selectByPrimaryKey(String wId);

    int updateByPrimaryKeySelective(Weekreport record);

    int updateByPrimaryKey(Weekreport record);
}