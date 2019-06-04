package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.ProjectPlanMapper;
import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.service.ProjectPlanService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangyanbin
 * @D
 */
@Service
@Transactional
public class ProjectPlanserviceImpl implements ProjectPlanService {

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    //查询所有用于列表展示
    @Override
    public CodeAndMsg selectById() {
        System.out.println(projectPlanMapper.selectById() + "查询成功");
        if (projectPlanMapper.selectById() != null) {
            return CodeAndMsgUtil.setOK("查询成功", projectPlanMapper.selectById());
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    // 查询所有用于项目总计划清单的展示
    @Override
    public CodeAndMsg selectProjectPlanListByPidAndPprojectphase(String pId, Integer pProjectPhase) {
        List<ProjectPlanList> projectPlanLists = projectPlanMapper.selectProjectPlanListByPidAndPprojectphase(pId, pProjectPhase);
        if (projectPlanLists != null) {
            return CodeAndMsgUtil.setOK("查询成功", projectPlanLists);
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    // 根据pName模糊查询项目总体计划列表展示
    @Override
    public CodeAndMsg selectBypName(String pName) {
        List<ProjectPlan> projectPlans = projectPlanMapper.selectBypName(pName);
        if (projectPlans != null) {
            return CodeAndMsgUtil.setOK("查询成功", projectPlans);
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

}
