package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ActionItem;

public interface ActionItemMapper {
    int deleteByPrimaryKey(String aId);

    int insert(ActionItem record);

    int insertSelective(ActionItem record);

    ActionItem selectByPrimaryKey(String aId);

    int updateByPrimaryKeySelective(ActionItem record);

    int updateByPrimaryKey(ActionItem record);
}