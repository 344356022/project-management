package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ActionItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * @author wangyanbin
 * @description 任务项接口
 */
@Mapper
public interface ActionItemMapper {

    /**
     * 新增项目中的任务项列表
     */
    public void addActionItem(@Param("list") List<ActionItem>  actionItems);

    /**
     * 批量修改任务项
     *
     * @param actionItems 任务项集合
     */
    void batchUpdate(@Param("list") List<ActionItem> actionItems);
}