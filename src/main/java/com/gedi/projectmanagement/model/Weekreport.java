package com.gedi.projectmanagement.model;

import com.gedi.projectmanagement.model.system.SysUser;

import java.util.List;
public class Weekreport {

    private String wId;

    private String pId;

    private String wStartTime;

    private String wEndTime;

    private String tsId;

    private String wWorkReport;

    private String userId;

    private Integer wActualProportion;

    private Integer wPlanProportion;

    private Integer wStatus;

    private String wRemark;

    private String userDepartmet;

    private List<ProjectPlan> projectPlans;

    private List<SysUser> users;

    private List<ActionItem> actionItems;

    private Integer rFinish;

    private List<RecordTime> recordTimes;

    private List<TaskSubclass> taskSubclasses;

    private Integer wType;

    private String wCreater;

    public String getwCreater() {
        return wCreater;
    }

    public void setwCreater(String wCreater) {
        this.wCreater = wCreater;
    }

    public String getUserDepartmet() {
        return userDepartmet;
    }

    public void setUserDepartmet(String userDepartmet) {
        this.userDepartmet = userDepartmet;
    }

    public Integer getwType() {
        return wType;
    }

    public void setwType(Integer wType) {
        this.wType = wType;
    }

    public Integer getrFinish() {
        return rFinish;
    }

    public List<TaskSubclass> getTaskSubclasses() {
        return taskSubclasses;
    }

    public void setTaskSubclasses(List<TaskSubclass> taskSubclasses) {
        this.taskSubclasses = taskSubclasses;
    }

    public void setrFinish(Integer rFinish) {
        this.rFinish = rFinish;
    }

    public List<ActionItem> getActionItems() {
        return actionItems;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public List<RecordTime> getRecordTimes() {
        return recordTimes;
    }

    public void setRecordTimes(List<RecordTime> recordTimes) {
        this.recordTimes = recordTimes;
    }

    public void setActionItems(List<ActionItem> actionItems) {
        this.actionItems = actionItems;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
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

    public String getwStartTime() {
        return wStartTime;
    }

    public void setwStartTime(String wStartTime) {
        this.wStartTime = wStartTime;
    }

    public String getwEndTime() {
        return wEndTime;
    }

    public void setwEndTime(String wEndTime) {
        this.wEndTime = wEndTime;
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

    public Weekreport(String wId, String pId, String tsId, String wWorkReport, String userId, Integer wActualProportion, Integer wPlanProportion, Integer wStatus, String wRemark,Integer wType) {
        this.wId = wId;
        this.pId = pId;
        this.tsId = tsId;
        this.wWorkReport = wWorkReport;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wStatus = wStatus;
        this.wRemark = wRemark;
        this.wType=wType;
    }
    public Weekreport(String wId, String pId, String tsId, String wWorkReport, String userId, Integer wActualProportion, Integer wPlanProportion, Integer wStatus, String wRemark,Integer rFinish,Integer wType,String userDepartmet) {
        this.wId = wId;
        this.pId = pId;
        this.tsId = tsId;
        this.wWorkReport = wWorkReport;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wStatus = wStatus;
        this.wRemark = wRemark;
        this.rFinish=rFinish;
        this.wType=wType;
        this.userDepartmet=userDepartmet;

    }



    public Weekreport(String pId, String tsId, String userId, Integer wActualProportion,  String userDepartmet,String wWorkReport) {
        this.pId = pId;
        this.tsId = tsId;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.userDepartmet = userDepartmet;
        this.wWorkReport=wWorkReport;
    }


    public Weekreport(String wId, String pId, String wStartTime, String wEndTime, String tsId, String wWorkReport, String userId, Integer wActualProportion, Integer wPlanProportion, Integer wStatus, String wRemark, String userDepartmet, Integer rFinish, Integer wType,String wCreater) {
        this.wId = wId;
        this.pId = pId;
        this.wStartTime = wStartTime;
        this.wEndTime = wEndTime;
        this.tsId = tsId;
        this.wWorkReport = wWorkReport;
        this.userId = userId;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wStatus = wStatus;
        this.wRemark = wRemark;
        this.userDepartmet = userDepartmet;
        this.rFinish = rFinish;
        this.wType = wType;
        this.wCreater=wCreater;
    }

    @Override
    public String toString() {
        return "Weekreport{" +
                "wId='" + wId + '\'' +
                ", pId='" + pId + '\'' +
                ", wStartTime='" + wStartTime + '\'' +
                ", wEndTime='" + wEndTime + '\'' +
                ", tsId='" + tsId + '\'' +
                ", wWorkReport='" + wWorkReport + '\'' +
                ", userId='" + userId + '\'' +
                ", wActualProportion=" + wActualProportion +
                ", wPlanProportion=" + wPlanProportion +
                ", wStatus=" + wStatus +
                ", wRemark='" + wRemark + '\'' +
                ", userDepartmet='" + userDepartmet + '\'' +
                ", rFinish=" + rFinish +
                ", wType=" + wType +
                ", wCreater='" + wCreater + '\'' +
                '}';
    }
}