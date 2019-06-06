package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ActionItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyanbin
 * @description 任务项接口
 */
@Mapper
public interface ActionItemMapper {
    int deleteByPrimaryKey(String aId);

    int insert(ActionItem record);

    int insertSelective(ActionItem record);

    ActionItem selectByPrimaryKey(String aId);

    /**
     * 项目总体计划清单的动态修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActionItem record);

    int updateByPrimaryKey(ActionItem record);

    /**
     * 批量修改任务项
     * @param actionItemList 任务项集合
     */
    void batchUpdate(@Param("list") List<ActionItem> actionItemList);
}