package com.gedi.projectmanagement.vo;

import com.gedi.projectmanagement.model.RecordTime;

import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/11 14:58
 * @Description:
 */

public class WeekRportInfo {

    private String wId;

    private String wWorkReport;

    private Integer  wActualProportion;

    private Integer wPlanProportion;

    private String wRemark;

    private String pId; // 项目名称

    private String userId; // 用户名称

    private String tsId; // 任务子类名称

    private Integer wStatus;

    private Integer wType;

    private List<RecordTime> recordTimes;

    public WeekRportInfo(){}

    public WeekRportInfo(String wId, String wWorkReport, Integer wActualProportion, Integer wPlanProportion, String wRemark, String pId, String userId, String tsId, Integer wStatus, Integer wType, List<RecordTime> recordTimes) {
        this.wId = wId;
        this.wWorkReport = wWorkReport;
        this.wActualProportion = wActualProportion;
        this.wPlanProportion = wPlanProportion;
        this.wRemark = wRemark;
        this.pId = pId;
        this.userId = userId;
        this.tsId = tsId;
        this.wStatus = wStatus;
        this.wType = wType;
        this.recordTimes = recordTimes;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getwWorkReport() {
        return wWorkReport;
    }

    public void setwWorkReport(String wWorkReport) {
        this.wWorkReport = wWorkReport;
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

    public String getwRemark() {
        return wRemark;
    }

    public void setwRemark(String wRemark) {
        this.wRemark = wRemark;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public Integer getwStatus() {
        return wStatus;
    }

    public void setwStatus(Integer wStatus) {
        this.wStatus = wStatus;
    }

    public Integer getwType() {
        return wType;
    }

    public void setwType(Integer wType) {
        this.wType = wType;
    }

    public List<RecordTime> getRecordTimes() {
        return recordTimes;
    }

    public void setRecordTimes(List<RecordTime> recordTimes) {
        this.recordTimes = recordTimes;
    }

    @Override
    public String toString() {
        return "WeekRportInfo{" +
                "wId='" + wId + '\'' +
                ", wWorkReport='" + wWorkReport + '\'' +
                ", wActualProportion=" + wActualProportion +
                ", wPlanProportion=" + wPlanProportion +
                ", wRemark='" + wRemark + '\'' +
                ", pId='" + pId + '\'' +
                ", userId='" + userId + '\'' +
                ", tsId='" + tsId + '\'' +
                ", wStatus=" + wStatus +
                ", wType=" + wType +
                ", recordTimes=" + recordTimes +
                '}';
    }
}
