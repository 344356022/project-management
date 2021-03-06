package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.ProjectUserMedium;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectUserMediumMapper {
    int deleteByPrimaryKey(String id);

    /*
    新增任务项与人物的关系
     */
    void addProjectUserMedium(@Param("list") List<ProjectUserMedium> projectUserMediumList);

    /**
     * 根据任务项ID集合删除 任务项-用户 关系
     *
     * @param ids 任务项ID集合
     */
    void deleteByAids(@Param("list") List<String> ids);

    /**
     * 批量插入 任务项-人物关系
     *
     * @param userMediumList 任务集合
     */
    void batchInsert(@Param("list") List<ProjectUserMedium> userMediumList);

    /**
     * 根据pId删除项目总计划清单
     *
     * @param pId
     * @return
     */
    public int deletePUMBypId(String pId);

}