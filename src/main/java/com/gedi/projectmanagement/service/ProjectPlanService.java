package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangyanbin, zhangshuai
 * @Description : 项目总计划Service接口,项目总计划清单Service接口
 */
public interface ProjectPlanService {

    //查询所有用于项目总计划列表展示
    CodeAndMsg selectById();

    // 查询所有用于项目总计划清单的展示
    CodeAndMsg selectProjectPlanListByPidAndPprojectphase(String pId, Integer pProjectPhase);

    // 根据pName模糊查询项目总体计划列表展示
    CodeAndMsg selectBypName(String pName);

}
