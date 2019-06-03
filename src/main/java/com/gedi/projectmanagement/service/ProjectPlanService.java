package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.ProjectPlan;
import com.gedi.projectmanagement.vo.CodeAndMsg;

/**
 * @author wangyanbin
 * @Description : 项目总计划Service接口
 */
public interface ProjectPlanService {

    //查询所有用于项目总计划列表展示
    CodeAndMsg selectById();
}
