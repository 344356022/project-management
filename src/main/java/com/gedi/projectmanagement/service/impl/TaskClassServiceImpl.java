package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.*;
import com.gedi.projectmanagement.model.ActionItem;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectUserMedium;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.TaskClassService;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Resource
    private TaskClassMapper taskClassMapper;

    @Resource
    private TaskSubclassMapper taskSubclassMapper;

    @Resource
    private ActionItemMapper actionItemMapper;

    @Resource
    private ProjectUserMediumMapper projectUserMediumMapper;

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    /**
     * @param : taskClass  taskSubclass  actionItem
     * @Description : 新增项目任务列表
     */
    @Override
    public String addTaskClass(List<ActionItem> actionItems, HttpServletRequest request) {
        List<ProjectUserMedium> projectUserMediumList = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        ProjectPlan projectPlan = new ProjectPlan();
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");

        for (ActionItem actionItem : actionItems) {
            if (null != actionItem.getaPercentage() && 100 == actionItem.getaPercentage()) {
                actionItem.setaState(3);
            }
            actionItem.setaId(UUIDUtil.getUUID2());
            actionItem.setCreater(user.getName());
            //actionItem.setCreater("张帅");
            ProjectUserMedium userMedium = new ProjectUserMedium();
            userMedium.setId(UUIDUtil.getUUID2());
            userMedium.setaId(actionItem.getaId());
            userMedium.setUserId(actionItem.getUserId());
            userMedium.setpId(actionItem.getpId());
            projectUserMediumList.add(userMedium);
        }

        //插入中间表数据
        projectUserMediumMapper.addProjectUserMedium(projectUserMediumList);

        //插入任务项列表数据
        actionItemMapper.addActionItem(actionItems);

        //修改项目阶段
        if (actionItems.size() > 0 && actionItems != null) {
            projectPlan.setpProjectPhaseId(actionItems.get(0).getpProjectPhaseId());
            projectPlan.setpId(actionItems.get(0).getpId());
            this.projectPlanMapper.updateBypId(projectPlan);
        }
        return "success";
    }


}
