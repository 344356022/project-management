package com.gedi.projectmanagement.model;

import java.util.Date;

public class ActionItem {
    private String aId;

    private String aName;

    private Date aPstartTime;

    private Date aPendTime;

    private Date aAstartTime;

    private Date aAendTime;

    private Integer aUserId;

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

    public Date getaPstartTime() {
        return aPstartTime;
    }

    public void setaPstartTime(Date aPstartTime) {
        this.aPstartTime = aPstartTime;
    }

    public Date getaPendTime() {
        return aPendTime;
    }

    public void setaPendTime(Date aPendTime) {
        this.aPendTime = aPendTime;
    }

    public Date getaAstartTime() {
        return aAstartTime;
    }

    public void setaAstartTime(Date aAstartTime) {
        this.aAstartTime = aAstartTime;
    }

    public Date getaAendTime() {
        return aAendTime;
    }

    public void setaAendTime(Date aAendTime) {
        this.aAendTime = aAendTime;
    }

    public Integer getaUserId() {
        return aUserId;
    }

    public void setaUserId(Integer aUserId) {
        this.aUserId = aUserId;
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
}