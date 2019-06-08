package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ActionItem {
    private String aId; // 任务项主键ID

    private String aName; // 任务项名称

    private String aPstartTime; // 计划开始时间

    private String aPendTime; // 计划结束时间

    private String aAstartTime; // 实际开始时间

    private String aAendTime; // 实际结束时间

    private String userId; // 用户ID

    private Integer aPercentage; // 完成百分比

    private Integer aState; // 状态 0 未开始，1 进行中，2 已完成

    private Integer aIsResult; // 成果是否提交  0 待提交 1 已提交

    private String creater; // 任务项创建人

    private Date createTime; // 任务项创建时间

    private String tsId; // 任务子类ID

    public ActionItem() {
    }

    public ActionItem(String aId, String aName, String aPstartTime, String aPendTime, String aAstartTime, String aAendTime, String userId, Integer aPercentage, Integer aState, Integer aIsResult, String creater, Date createTime, String tsId) {
        this.aId = aId;
        this.aName = aName;
        this.aPstartTime = aPstartTime;
        this.aPendTime = aPendTime;
        this.aAstartTime = aAstartTime;
        this.aAendTime = aAendTime;
        this.userId = userId;
        this.aPercentage = aPercentage;
        this.aState = aState;
        this.aIsResult = aIsResult;
        this.creater = creater;
        this.createTime = createTime;
        this.tsId = tsId;
    }

    public ActionItem(String aId, String aName, String aPstartTime, String aPendTime, String aAstartTime, String aAendTime,Integer aPercentage, Integer aState, Integer aIsResult, String creater, Date createTime, String tsId) {
        this.aId = aId;
        this.aName = aName;
        this.aPstartTime = aPstartTime;
        this.aPendTime = aPendTime;
        this.aAstartTime = aAstartTime;
        this.aAendTime = aAendTime;
        this.userId = userId;
        this.aPercentage = aPercentage;
        this.aState = aState;
        this.aIsResult = aIsResult;
        this.creater = creater;
        this.createTime = createTime;
        this.tsId = tsId;
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
    public String getaPstartTime() {
        return aPstartTime;
    }

    public void setaPstartTime(String aPstartTime) {
        this.aPstartTime = aPstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getaPendTime() {
        return aPendTime;
    }

    public void setaPendTime(String aPendTime) {
        this.aPendTime = aPendTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getaAstartTime() {
        return aAstartTime;
    }

    public void setaAstartTime(String aAstartTime) {
        this.aAstartTime = aAstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getaAendTime() {
        return aAendTime;
    }

    public void setaAendTime(String aAendTime) {
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
                ", aPercentage=" + aPercentage +
                ", aState=" + aState +
                ", aIsResult=" + aIsResult +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", tsId='" + tsId + '\'' +
                '}';
    }
}