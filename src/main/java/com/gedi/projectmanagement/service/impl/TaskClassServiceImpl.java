package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ActionItemMapper;
import com.gedi.projectmanagement.dao.TaskClassMapper;
import com.gedi.projectmanagement.dao.TaskSubclassMapper;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.TaskClass;
import com.gedi.projectmanagement.model.TaskSubclass;
import com.gedi.projectmanagement.service.TaskClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName : 项目维护
 * @Package : com.gedi.projectmanagement.service.impl
 * @Description : 项目计划列表添加
 * @Author : wangyanbin
 * @Date : 2019/6/5 0005 上午 10:55
 * @Version : 1.0
 */
@Service
public class TaskClassServiceImpl implements TaskClassService {

    @Resource
    private TaskClassMapper taskClassMapper;

    @Resource
    private TaskSubclassMapper taskSubclassMapper;

    @Resource
    private ActionItemMapper actionItemMapper;

    /**
     * @Description : 新增项目任务类
     * @param taskClass
     */
    @Override
    public void addTaskClass(TaskClass taskClass) {
        try {
            taskClassMapper.addTaskClass(taskClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description : 新增项目任务子类
     * @param taskSubclass
     */
    @Override
    public void addTaskSubclass(TaskSubclass taskSubclass) {
        try {
            taskSubclassMapper.addTaskSubclass(taskSubclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description : 新增项目任务项列表
     * @param actionItem
     */
    public void addActionItem(ActionItem actionItem){
        try {
            actionItemMapper.addActionItem(actionItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
