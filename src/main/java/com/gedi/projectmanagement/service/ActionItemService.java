package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.vo.CodeAndMsg;

import java.util.List;

/**
 * @ClassName: ActionItemService
 * @Description: 用于对项目管理总计划清单的修改
 * @Author: zhangshuai
 * @Date 2019/6/5 17:53
 * @Version 1.0
 **/
public interface ActionItemService {

    /**
     * 批量修改任务项
     *
     * @param actionItems 任务项内容集合
     * @return
     */
    String batchUpdateActionItems(List<ActionItem> actionItems);

}
