package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.*;
import com.gedi.projectmanagement.model.Journal;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    //查询所有用于列表展示
    @Override
    public List<ProjectPlan> selectById() {
        List<ProjectPlan> projectPlans = projectPlanMapper.selectById();
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
        /*HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        projectPlan.setCreater(user.getuName());*/
        projectPlan.setCreater("张帅");
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
        return projectPlanMapper.selectProjectPlanListByPidAndpProjectPhaseId(pId, pProjectPhaseId);
    }

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param projectPlan
     * @return
     */
    @Override
    public List<ProjectPlan> selectBypName(ProjectPlan projectPlan) {
        return projectPlanMapper.selectBypName(projectPlan);
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
