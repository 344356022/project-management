package com.gedi.projectmanagement.model;

import java.util.Date;

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

    public Date getwStartTime() {
        return wStartTime;
    }

    public void setwStartTime(Date wStartTime) {
        this.wStartTime = wStartTime;
    }

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
}