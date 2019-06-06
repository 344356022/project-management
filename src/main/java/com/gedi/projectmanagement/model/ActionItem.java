package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActionItem {
    private String aId; // 任务项主键ID

    private String aName; // 任务项名称

    private Date aPstartTime; // 计划开始时间

    private Date aPendTime; // 计划结束时间

    private Date aAstartTime; // 实际开始时间

    private Date aAendTime; // 实际结束时间

    private String userId; // 用户ID

    private Integer aPercentage; // 完成百分比

    private Integer aState; // 状态 0 未开始，1 进行中，2 已完成

    private Boolean aIsResult; // 成果是否提交  0 待提交 1 已提交

    private String creater; // 任务项创建人

    private Date createTime; // 任务项创建时间

    private String tsId; // 任务子类ID

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getaPstartTime() {
        return aPstartTime;
    }

    public void setaPstartTime(Date aPstartTime) {
        this.aPstartTime = aPstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getaPendTime() {
        return aPendTime;
    }

    public void setaPendTime(Date aPendTime) {
        this.aPendTime = aPendTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getaAstartTime() {
        return aAstartTime;
    }

    public void setaAstartTime(Date aAstartTime) {
        this.aAstartTime = aAstartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getaAendTime() {
        return aAendTime;
    }

    public void setaAendTime(Date aAendTime) {
        this.aAendTime = aAendTime;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
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

    public Boolean getaIsResult() {
        return aIsResult;
    }

    public void setaIsResult(Boolean aIsResult) {
        this.aIsResult = aIsResult;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public ActionItem() {
    }

    public ActionItem(String aId, String aName, Date aPstartTime, Date aPendTime, Date aAstartTime, Date aAendTime, String userId, Integer aPercentage, Integer aState, Boolean aIsResult, String creater, Date createTime, String tsId) {
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

    @Override
    public String toString() {
        return "ActionItem{" +
                "aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", aPstartTime=" + aPstartTime +
                ", aPendTime=" + aPendTime +
                ", aAstartTime=" + aAstartTime +
                ", aAendTime=" + aAendTime +
                ", userId=" + userId +
                ", aPercentage=" + aPercentage +
                ", aState=" + aState +
                ", aIsResult=" + aIsResult +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", tsId='" + tsId + '\'' +
                '}';
    }
}