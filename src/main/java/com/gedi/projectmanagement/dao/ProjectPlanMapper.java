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
    int deleteByPrimaryKey(String pId);

    int insert(ProjectPlan record);

    int insertSelective(ProjectPlan record);

    int updateByPrimaryKeySelective(ProjectPlan record);

    int updateByPrimaryKey(ProjectPlan record);

    /*
    项目总计划列表展示
     */
    List<ProjectPlan> selectById();


    public void addProject(ProjectPlan projectPlan);

    /**
     * 项目计划清单展示
     *
     * @param pId
     * @param pProjectPhase
     * @return
     */
    List<ProjectPlanList> selectProjectPlanListByPidAndPprojectphase(@Param("pId") String pId, @Param("pProjectPhase") Integer pProjectPhase);

    /**
     * 根据pName模糊查询项目总体计划列表展示
     *
     * @param pName
     * @return
     */
    List<ProjectPlan> selectBypName(String pName);



}