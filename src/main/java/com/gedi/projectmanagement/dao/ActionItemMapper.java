package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ActionItem;

/**
 * @author wangyanbin
 * @description 任务项接口
 */
public interface ActionItemMapper {
    int deleteByPrimaryKey(String aId);

    int insert(ActionItem record);

    int insertSelective(ActionItem record);

    ActionItem selectByPrimaryKey(String aId);

    int updateByPrimaryKeySelective(ActionItem record);

    int updateByPrimaryKey(ActionItem record);
}