package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ActionItemMapper;
import com.gedi.projectmanagement.dao.ProjectPlanMapper;
import com.gedi.projectmanagement.dao.ProjectUserMediumMapper;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.util.UUIDUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    //查询所有用于列表展示
    @Override
    public CodeAndMsg selectById() {
        List<ProjectPlan> projectPlans = projectPlanMapper.selectById();
        if (projectPlans != null) {
            return CodeAndMsgUtil.setOK("查询成功", projectPlans);
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }


    //新增项目总计划
    @Override
    public String addProject(ProjectPlan projectPlan) {
        projectPlan.setpId(UUIDUtil.getUUID2());
        String startTime = projectPlan.getpStartTime();
        String annualTime = startTime.substring(0, 4);
        projectPlan.setAnnualTime(annualTime);
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
     * @param pName
     * @return
     */
    @Override
    public List<ProjectPlan> selectBypName(String pName) {
        return projectPlanMapper.selectBypName(pName);
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
        int i = projectPlanMapper.deleteProjectBypId(pId);
        if (i > 0) {
            int j = actionItemMapper.deleteActionItemBypId(pId);
            int k = projectUserMediumMapper.deletePUMBypId(pId);
        }
        return "success";
    }

}
