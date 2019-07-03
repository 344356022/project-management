package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.*;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyanbin
 * @Description :
 */
@Service
@Transactional
public class ProjectPlanserviceImpl implements ProjectPlanService {

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    @Resource
    private ActionItemMapper actionItemMapper;

    @Resource
    private ProjectUserMediumMapper projectUserMediumMapper;

    @Autowired
    private WeekreportMapper weekreportMapper;

    @Autowired
    private JournalMapper journalMapper;

    // 查询所有用于列表展示
    @Override
    public List<ProjectPlan> selectById() {
        List<ProjectPlan> projectPlans = projectPlanMapper.selectById();
        for (ProjectPlan projectPlan : projectPlans) {
            if (null != projectPlan.getpProjectPhaseId() && projectPlan.getpProjectPhaseId() == 1) {
                projectPlan.setpProjectPhaseName("需求分析");
            } else if (null != projectPlan.getpProjectPhaseId() && projectPlan.getpProjectPhaseId() == 2) {
                projectPlan.setpProjectPhaseName("数据处理");
            } else if (null != projectPlan.getpProjectPhaseId() && projectPlan.getpProjectPhaseId() == 3) {
                projectPlan.setpProjectPhaseName("系统开发");
            }
        }
        if (projectPlans != null && projectPlans.size() > 0) {
            return projectPlans;
        } else {
            return null;
        }
    }

    //新增项目总计划
    @Override
    public String addProject(ProjectPlan projectPlan, HttpServletRequest request) {
        projectPlan.setpId(UUIDUtil.getUUID2());
        String startTime = projectPlan.getpStartTime();
        String annualTime = startTime.substring(0, 4);
        projectPlan.setAnnualTime(annualTime);
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        projectPlan.setCreater(user.getName());
        //projectPlan.setCreater("张帅");
        projectPlanMapper.addProject(projectPlan);
        return "success";
    }

    /**
     * 查询所有用于项目总计划清单的展示
     *
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    @Override
    public List<ProjectPlanList> selectProjectPlanListByPidAndpProjectPhaseId(String pId, Integer pProjectPhaseId) {
        List<ProjectPlanList> projectPlanLists = projectPlanMapper.selectProjectPlanListByPidAndpProjectPhaseId(pId,
                pProjectPhaseId);
        for (ProjectPlanList projectPlanList : projectPlanLists) {
            if (null != projectPlanList.getPercentage() && 100 == projectPlanList.getPercentage()) {
                projectPlanList.setState(3);
            }
        }
        return projectPlanLists;
    }

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param projectPlan
     * @return
     */
    @Override
    public List<ProjectPlan> selectBypName(ProjectPlan projectPlan) {
        List<ProjectPlan> projectPlans = projectPlanMapper.selectBypName(projectPlan);
        for (ProjectPlan plan : projectPlans) {
            if (null != plan.getpProjectPhaseId() && plan.getpProjectPhaseId() == 1) {
                plan.setpProjectPhaseName("需求分析");
            } else if (null != plan.getpProjectPhaseId() && plan.getpProjectPhaseId() == 2) {
                plan.setpProjectPhaseName("数据处理");
            } else if (null != plan.getpProjectPhaseId() && plan.getpProjectPhaseId() == 3) {
                plan.setpProjectPhaseName("系统开发");
            }
        }
        return projectPlans;
    }

    /**
     * 根据年度时间查询项目总体计划
     *
     * @param annualTime
     * @return
     */
    @Override
    public List<ProjectPlan> selectByTime(String annualTime) {
        return projectPlanMapper.selectByTime(annualTime);
    }

    @Override
    public CodeAndMsg selectAllProject() {

        if (projectPlanMapper.selectAllProject().size() != 0) {
            return CodeAndMsgUtil.setOK("msg", projectPlanMapper.selectAllProject());
        } else {
            return CodeAndMsgUtil.setERROR("msg", null);
        }

    }

    /**
     * 根据pId删除项目总计划
     *
     * @param pId
     * @return
     */
    @Override
    public String deleteProjectBypId(String pId) {
        List<Weekreport> weekreports = weekreportMapper.selectBypId(pId);
        List<Journal> journals = journalMapper.selectBypId(pId);
        if ((weekreports != null && weekreports.size() > 0) || (journals != null && journals.size() > 0)) {
            return "error";
        } else {
            int i = projectPlanMapper.deleteProjectBypId(pId);
            if (i > 0) {
                int j = actionItemMapper.deleteActionItemBypId(pId);
                int k = projectUserMediumMapper.deletePUMBypId(pId);
            }
            return "success";
        }
    }

    /**
     * 根据pId修改项目总计划
     *
     * @param projectPlan
     * @return
     */
    @Override
    public Map updateProjectBypId(ProjectPlan projectPlan) {
        Map map = new HashMap();
        String startTime = projectPlan.getpStartTime();
        if (startTime != null && startTime != "") {
            String annualTime = startTime.substring(0, 4);
            projectPlan.setAnnualTime(annualTime);
            int i = projectPlanMapper.updateProjectBypId(projectPlan);
            if (i > 0) {
                map.put("success", "success");
            } else {
                map.put("error", "error");
            }
        } else {
            int i = projectPlanMapper.updateProjectBypId(projectPlan);
            if (i > 0) {
                map.put("success", "success");
            } else {
                map.put("error", "error");
            }
        }
        return map;
    }

}
