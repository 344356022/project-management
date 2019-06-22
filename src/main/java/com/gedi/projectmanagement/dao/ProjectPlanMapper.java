package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.model.ProjectPlanList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyanbin
 * @description 项目总计划接口
 */
@Mapper
public interface ProjectPlanMapper {

    /*
    项目总计划列表展示
     */
    List<ProjectPlan> selectById();

    /*
    新增项目总计划
     */
    public void addProject(ProjectPlan projectPlan);

    /**
     * 项目计划清单展示
     *
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    List<ProjectPlanList> selectProjectPlanListByPidAndpProjectPhaseId(@Param("pId") String pId, @Param(
            "pProjectPhaseId") Integer pProjectPhaseId);

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param projectPlan
     * @return
     */
    List<ProjectPlan> selectBypName(@Param("projectPlan") ProjectPlan projectPlan);

    /**
     * 根据年度时间查询项目总体计划
     *
     * @param annualTime
     * @return
     */
    List<ProjectPlan> selectByTime(@Param("annualTime") String annualTime);

    //查询所有得项目名称以及ID值；
    List<ProjectPlan> selectAllProject();


    /**
     * 根据项目ID 更新项目进度
     *
     * @param projectPlan
     */
    void updateBypId(@Param("projectPlan") ProjectPlan projectPlan);

    /**
     * 根据pId删除项目总计划
     *
     * @param pId
     * @return
     */
    public int deleteProjectBypId(String pId);

}