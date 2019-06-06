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
    List<ProjectPlan> selectById(String pid);

    /*
    新增项目总计划
     */
    public int addProject(ProjectPlan projectPlan);
    //public void addProject(ProjectPlan projectPlan);

    /**
     * 项目计划清单展示
     * @param pId
     * @param pProjectPhaseId
     * @return
     */
    List<ProjectPlanList> selectProjectPlanListByPidAndpProjectPhaseId(@Param("pId") String pId, @Param("pProjectPhaseId") Integer pProjectPhaseId);

    /**
     * 根据pName模糊查询项目总体计划列表展示
     * @param pName
     * @return
     */
    List<ProjectPlan> selectBypName(String pName);

    //查询所有得项目名称以及ID值；
    List<ProjectPlan> selectAllProject();


}