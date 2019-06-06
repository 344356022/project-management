package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Weekreport {
    private String wId;

    private String pId;

    private Date wStartTime;

    private Date wEndTime;

    private String aId;

    private String wWorkReport;

    private String userId;

    private Integer wActualProportion;

    private Integer wPlanProportion;

    private Integer wStatus;

    private String wRemark;

    private List<ProjectPlan> projectPlans;

    private List<User> users;

    private List<ActionItem> actionItems;

    private Integer rFinish;

    public Integer getrFinish() {
        return rFinish;
    }

    public void setrFinish(Integer rFinish) {
        this.rFinish = rFinish;
    }

    public List<ActionItem> getActionItems() {
        return actionItems;
    }

    public void setActionItems(List<ActionItem> actionItems) {
        this.actionItems = actionItems;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getwStartTime() {
        return wStartTime;
    }

    public void setwStartTime(Date wStartTime) {
        this.wStartTime = wStartTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getwEndTime() {
        return wEndTime;
    }

    public void setwEndTime(Date wEndTime) {
        this.wEndTime = wEndTime;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getwWorkReport() {
        return wWorkReport;
    }

    public void setwWorkReport(String wWorkReport) {
        this.wWorkReport = wWorkReport;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getwActualProportion() {
        return wActualProportion;
    }

    public void setwActualProportion(Integer wActualProportion) {
        this.wActualProportion = wActualProportion;
    }

    public Integer getwPlanProportion() {
        return wPlanProportion;
    }

    public void setwPlanProportion(Integer wPlanProportion) {
        this.wPlanProportion = wPlanProportion;
    }

    public Integer getwStatus() {
        return wStatus;
    }

    public void setwStatus(Integer wStatus) {
        this.wStatus = wStatus;
    }

    public String getwRemark() {
        return wRemark;
    }

    public void setwRemark(String wRemark) {
        this.wRemark = wRemark;
    }

    public List<ProjectPlan> getProjectPlans() {
        return projectPlans;
    }

    public void setProjectPlans(List<ProjectPlan> projectPlans) {
        this.projectPlans = projectPlans;
    }

    public Weekreport() {
    }

    public Weekreport(String wId, String pId, Date wStartTime, Date wEndTime, String aId, String wWorkReport, String userId, Integer wActualProportion, Integer wPlanProportion, Integer wStatus, String wRemark) {
        this.wId = wId;
        this.pId = pId;
        this.wStartTime = wStartTime;
        this.wEndTime = wEndTime;
        this.aId = aId;
        this.wWorkReport = wWorkReport;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wStatus = wStatus;
        this.wRemark = wRemark;
    }

    public Weekreport(String wId, String pId, Date wStartTime, Date wEndTime, String aId, String wWorkReport, String userId, Integer wActualProportion, Integer wPlanProportion, Integer wStatus, String wRemark,Integer rFinish) {
        this.wId = wId;
        this.pId = pId;
        this.wStartTime = wStartTime;
        this.wEndTime = wEndTime;
        this.aId = aId;
        this.wWorkReport = wWorkReport;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wStatus = wStatus;
        this.wRemark = wRemark;
        this.rFinish=rFinish;
    }



    @Override
    public String toString() {
        return "Weekreport{" +
                "wId='" + wId + '\'' +
                ", pId='" + pId + '\'' +
                ", wStartTime=" + wStartTime +
                ", wEndTime=" + wEndTime +
                ", aId='" + aId + '\'' +
                ", wWorkReport='" + wWorkReport + '\'' +
                ", userId='" + userId + '\'' +
                ", wActualProportion=" + wActualProportion +
                ", wPlanProportion=" + wPlanProportion +
                ", wStatus=" + wStatus +
                ", wRemark='" + wRemark + '\'' +
                '}';
    }
}