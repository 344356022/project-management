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

    /**
     * 新增项目中的任务项列表
     */
    public void addActionItem(@Param("list") List<ActionItem> actionItems);

    /**
     * 批量修改任务项
     *
     * @param actionItems 任务项集合
     */
    void batchUpdate(@Param("list") List<ActionItem> actionItems);

    /**
     * 根据pId删除项目总计划清单
     *
     * @param pId
     * @return
     */
    public int deleteActionItemBypId(String pId);
}