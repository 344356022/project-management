package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import com.gedi.projectmanagement.vo.CodeAndMsg;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author wangyanbin, zhangshuai
 * @Description : 项目总计划Service接口,项目总计划清单Service接口
 */
public interface ProjectPlanService {

    //查询所有用于项目总计划列表展示
    List<ProjectPlan> selectById();

    //新增项目总计划
    public String addProject(ProjectPlan projectPlan, HttpServletRequest request);

    /**
     * 查询所有用于项目总计划清单的展示
     *
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    List<ProjectPlanList> selectProjectPlanListByPidAndpProjectPhaseId(String pId, Integer pProjectPhaseId);

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param projectPlan
     * @return
     */
    List<ProjectPlan> selectBypName(ProjectPlan projectPlan);

    /**
     * 根据年度时间查询项目总体计划
     *
     * @param annualTime
     * @return
     */
    List<ProjectPlan> selectByTime(String annualTime);

    //查询全部的项目名称；
    CodeAndMsg selectAllProject();

    /**
     * 根据pId删除项目总计划
     *
     * @param pId
     * @return
     */
    String deleteProjectBypId(String pId);

    /**
     * 根据pId修改项目总计划
     *
     * @param projectPlan
     * @return
     */
    Map updateProjectBypId(ProjectPlan projectPlan);

}
