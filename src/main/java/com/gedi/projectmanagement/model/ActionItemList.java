package com.gedi.projectmanagement.model;

import java.util.Date;

/**
 * @ClassName: ActionItemList
 * @Description: TODO
 * @Author zs
 * @Date 2019/6/12 20:05
 * @Version 1.0
 **/
public class ActionItemList {

    private String aId; // 任务项主键ID

    private String aName; // 任务项名称

    private Date aPstartTime; // 计划开始时间

    private Date aPendTime; // 计划结束时间

    private Date aAstartTime; // 实际开始时间

    private Date aAendTime; // 实际结束时间

    private String userId; // 用户ID

    private Integer aPercentage; // 完成百分比

    private Integer aState; // 状态  01-未开始、02-进行中、03-已完成

    private Integer aIsResult; // 成果是否提交  01待提交、02已提交

    private String creater; // 任务项创建人

    private Date createTime; // 任务项创建时间

    private String tsId; // 任务子类ID

    private String tId; // 任务类主键ID

    private String tName; // 任务类名称

    private String pId; // 项目总计划表主键

    private Integer pProjectPhaseId; // 项目阶段ID

    private String tsName; // 任务子类名称


}
