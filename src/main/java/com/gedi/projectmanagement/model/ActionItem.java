package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ActionItem {
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

    private String pId; // 项目总计划表sID

    private Integer pProjectPhaseId; // 项目阶段ID 1-需求分析、2-数据处理、3-系统开发

    public ActionItem() {
    }

    public ActionItem(String aId, String aName, Date aPstartTime, Date aPendTime, Date aAstartTime, Date aAendTime, String userId, Integer pProjectPhaseId,Integer aPercentage, Integer aState, Integer aIsResult, String creater, Date createTime, String tsId, String pId) {
        this.aId = aId;
        this.aName = aName;
        this.aPstartTime = aPstartTime;
        this.aPendTime = aPendTime;
        this.aAstartTime = aAstartTime;
        this.aAendTime = aAendTime;
        this.userId = userId;
        this.pProjectPhaseId = pProjectPhaseId;
        this.aPercentage = aPercentage;
        this.aState = aState;
        this.aIsResult = aIsResult;
        this.creater = creater;
        this.createTime = createTime;
        this.tsId = tsId;
        this.pId = pId;
    }

    public ActionItem(String aId, String aName, Date aPstartTime, Date aPendTime, Date aAstartTime, Date aAendTime,Integer pProjectPhaseId,Integer aPercentage, Integer aState, Integer aIsResult, String creater, Date createTime, String tsId,String pId) {
        this.aId = aId;
        this.aName = aName;
        this.aPstartTime = aPstartTime;
        this.aPendTime = aPendTime;
        this.aAstartTime = aAstartTime;
        this.aAendTime = aAendTime;
        this.pProjectPhaseId = pProjectPhaseId;
        this.aPercentage = aPercentage;
        this.aState = aState;
        this.aIsResult = aIsResult;
        this.creater = creater;
        this.createTime = createTime;
        this.tsId = tsId;
        this.pId = pId;
    }





    private List<TaskSubclass> taskSubclasses;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getaPstartTime() {
        return aPstartTime;
    }

    public void setaPstartTime(Date aPstartTime) {
        this.aPstartTime = aPstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getaPendTime() {
        return aPendTime;
    }

    public void setaPendTime(Date aPendTime) {
        this.aPendTime = aPendTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getaAstartTime() {
        return aAstartTime;
    }

    public void setaAstartTime(Date aAstartTime) {
        this.aAstartTime = aAstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getaAendTime() {
        return aAendTime;
    }

    public void setaAendTime(Date aAendTime) {
        this.aAendTime = aAendTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getaPercentage() {
        return aPercentage;
    }

    public void setaPercentage(Integer aPercentage) {
        this.aPercentage = aPercentage;
    }

    public Integer getaState() {
        return aState;
    }

    public void setaState(Integer aState) {
        this.aState = aState;
    }

    public Integer getaIsResult() {
        return aIsResult;
    }

    public void setaIsResult(Integer aIsResult) {
        this.aIsResult = aIsResult;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public List<TaskSubclass> getTaskSubclasses() {
        return taskSubclasses;
    }

    public void setTaskSubclasses(List<TaskSubclass> taskSubclasses) {
        this.taskSubclasses = taskSubclasses;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getpProjectPhaseId() {
        return pProjectPhaseId;
    }

    public void setpProjectPhaseId(Integer pProjectPhaseId) {
        this.pProjectPhaseId = pProjectPhaseId;
    }

    @Override
    public String toString() {
        return "ActionItem{" +
                "aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", aPstartTime=" + aPstartTime +
                ", aPendTime=" + aPendTime +
                ", aAstartTime=" + aAstartTime +
                ", aAendTime=" + aAendTime +
                ", userId='" + userId + '\'' +
                ", pProjectPhaseId=" + pProjectPhaseId +
                ", aPercentage=" + aPercentage +
                ", aState=" + aState +
                ", aIsResult=" + aIsResult +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", tsId='" + tsId + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }
}