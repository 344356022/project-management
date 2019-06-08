package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ActionItemMapper;
import com.gedi.projectmanagement.dao.ProjectUserMediumMapper;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.ProjectUserMedium;
import com.gedi.projectmanagement.service.ActionItemService;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ActionItemServiceImpl
 * @Description: 用于对项目管理总计划清单的修改
 * @Author: zhangshuai
 * @Date 2019/6/5 17:59
 * @Version 1.0
 **/
@Service
@Transactional
public class ActionItemServiceImpl implements ActionItemService {

    @Resource
    private ActionItemMapper actionItemMapper;

    @Resource
    private ProjectUserMediumMapper projectUserMediumMapper;


    /**
     * 用于对项目管理总计划清单的修改
     *
     * @param actionItems 任务项内容集合
     * @return
     */
    @Override
    public String batchUpdateActionItems(List<ActionItem> actionItems) {
        List<ProjectUserMedium> userMediumList = new ArrayList<>();
        //List<ActionItem> actionItemList = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        for (ActionItem actionItem : actionItems) {
            ids.add(actionItem.getaId());
            ProjectUserMedium userMedium = new ProjectUserMedium();
            userMedium.setId(UUIDUtil.getUUID2());
            userMedium.setaId(actionItem.getaId());
            userMedium.setUserId(actionItem.getUserId());
            userMediumList.add(userMedium);
        }

        // 先查看数据库里面有没有数据，有的话，先删除再插入
        this.projectUserMediumMapper.deleteByAids(ids);
        // 批量插入
        this.projectUserMediumMapper.batchInsert(userMediumList);
        // 批量修改任务项
        this.actionItemMapper.batchUpdate(actionItems);

        return "success";
    }

}
