package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
//项目任务项实体类
public class ActionItem {
    private String aId;

    private String aName;

    private Date aPstartTime;

    private Date aPendTime;

    private Date aAstartTime;

    private Date aAendTime;

    private Integer userId;

    private Integer aPercentage;

    private Integer aState;

    private Boolean aIsResult;

    private String creater;

    private Date createTime;

    private String tsId;

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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getaPstartTime() {
        return aPstartTime;
    }

    public void setaPstartTime(Date aPstartTime) {
        this.aPstartTime = aPstartTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getaPendTime() {
        return aPendTime;
    }

    public void setaPendTime(Date aPendTime) {
        this.aPendTime = aPendTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getaAstartTime() {
        return aAstartTime;
    }

    public void setaAstartTime(Date aAstartTime) {
        this.aAstartTime = aAstartTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getaAendTime() {
        return aAendTime;
    }

    public void setaAendTime(Date aAendTime) {
        this.aAendTime = aAendTime;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public ActionItem(String aId, String aName, Date aPstartTime, Date aPendTime, Date aAstartTime, Date aAendTime, Integer userId, Integer aPercentage, Integer aState, Boolean aIsResult, String creater, Date createTime, String tsId) {
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