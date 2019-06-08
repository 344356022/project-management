package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.TaskSubclass;

import java.util.List;

/**
 * @ProjectName : 项目维护
 * @Package : com.gedi.projectmanagement.service;
 * @Description : 项目任务类、项目任务子类、项目任务项列表添加
 * @Author : wangyanbin
 * @Date : 2019/6/5 0005 上午 10:57
 * @Version : 1.0
 */
public interface TaskClassService {

    /*
    新增项目中的任务类
     */
    public String addTaskClass(List<ActionItem> actionItems);

    /*
    新增项目中任务子类
     */
  //  public void addTaskSubclass(TaskSubclass taskSubclass);

    /*
    新增项目中任务项列表
     */
  //  public void addActionItem(ActionItem actionItem);

}
