package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ActionItemMapper;
import com.gedi.projectmanagement.dao.ProjectUserMediumMapper;
import com.gedi.projectmanagement.dao.TaskClassMapper;
import com.gedi.projectmanagement.dao.TaskSubclassMapper;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.ProjectUserMedium;
import com.gedi.projectmanagement.service.TaskClassService;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName : 项目维护
 * @Package : com.gedi.projectmanagement.service.impl
 * @Description : 项目计划列表添加
 * @Author : wangyanbin
 * @Date : 2019/6/5 0005 上午 10:55
 * @Version : 1.0
 */
@Service
@Transactional
public class TaskClassServiceImpl implements TaskClassService {

    //@Resource
    private TaskClassMapper taskClassMapper;

    //@Resource
    private TaskSubclassMapper taskSubclassMapper;

    @Resource
    private ActionItemMapper actionItemMapper;

    @Resource
    private ProjectUserMediumMapper projectUserMediumMapper;

    /**
     * @Description : 新增项目任务类
     * @param : taskClass  taskSubclass  actionItem
     */
    @Override
    public String addTaskClass(List<ActionItem> actionItems) {
        List<ProjectUserMedium>  projectUserMediumList = new ArrayList<>();
       // List<ActionItem> actionItems = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        for (ActionItem actionItem : actionItems) {
            ids.add(actionItem.getaId());
            ProjectUserMedium userMedium = new ProjectUserMedium();
            userMedium.setId(UUIDUtil.getUUID2());
            userMedium.setaId(actionItem.getaId());
            userMedium.setUserId(actionItem.getUserId());
            projectUserMediumList.add(userMedium);
        }

        //插入中间表数据
        projectUserMediumMapper.addProjectUserMedium(projectUserMediumList);
        System.out.println("comcmocmocmocmcmco");
        //插入任务项列表数据
        actionItemMapper.addActionItem(actionItems);
        return "success";
    }


    /**
     * @Description : 新增项目任务类
     * @param list
     */
    /*@Override
    public int addActionItem(List<ActionItem> list) {
        return actionItemMapper.addActionItem(list);
        taskSubclassMapper.addTaskSubclass(taskSubclass);
        actionItemMapper.addActionItem(actionItem);
    }*/

    /**
     * @Description : 新增项目任务子类
     * @param taskSubclass
     */
    /*@Override
    public void addTaskSubclass(TaskSubclass taskSubclass) {
        try {
            taskSubclassMapper.addTaskSubclass(taskSubclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * @Description : 新增项目任务项列表
     * @param actionItem
     */
    /*public void addActionItem(ActionItem actionItem){
        try {
            actionItemMapper.addActionItem(actionItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
