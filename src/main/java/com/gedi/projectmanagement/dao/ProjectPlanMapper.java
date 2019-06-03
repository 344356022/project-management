package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectPlan;
import org.apache.ibatis.annotations.Mapper;

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

}