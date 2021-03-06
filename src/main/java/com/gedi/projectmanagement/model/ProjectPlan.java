package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author wangyanbin
 * @description 项目总计划实体类
 */
public class ProjectPlan {
    private String pId; // 项目总计划表主键

    private String pName; // 项目名称

    private String pStartTime; // 项目计划开始时间

    private String pEndTime; // 项目计划结束时间

    private Integer pProjectPhaseId; // 项目阶段ID

    private String pProjectPhaseName; // 项目阶段名称

    private Integer pProgress; // 项目总体完成进度

    private String createTime; // 项目创建时间

    private String creater; // 项目创建人

    private String annualTime; // 年度时间

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getpStartTime() {
        return pStartTime;
    }

    public void setpStartTime(String pStartTime) {
        this.pStartTime = pStartTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getpEndTime() {
        return pEndTime;
    }

    public void setpEndTime(String pEndTime) {
        this.pEndTime = pEndTime;
    }

    public Integer getpProjectPhaseId() {
        return pProjectPhaseId;
    }

    public void setpProjectPhaseId(Integer pProjectPhaseId) {
        this.pProjectPhaseId = pProjectPhaseId;
    }

    public Integer getpProgress() {
        return pProgress;
    }

    public void setpProgress(Integer pProgress) {
        this.pProgress = pProgress;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }


    public ProjectPlan() {
    }

    public ProjectPlan(String pId, Integer pProjectPhaseId) {
        this.pId = pId;
        this.pProjectPhaseId = pProjectPhaseId;
    }

    public ProjectPlan(String pId, String pName, String pStartTime, String pEndTime, Integer pProjectPhaseId,
                       Integer pProgress, String createTime, String creater, String annualTime) {
        this.pId = pId;
        this.pName = pName;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pProjectPhaseId = pProjectPhaseId;
        this.pProgress = pProgress;
        this.createTime = createTime;
        this.creater = creater;
        this.annualTime = annualTime;
    }

    public ProjectPlan(String pId, String pName, String pStartTime, String pEndTime, Integer pProgress) {
        this.pId = pId;
        this.pName = pName;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pProgress = pProgress;
    }

    public ProjectPlan(String pId, String pName, String pStartTime, String pEndTime, Integer pProgress,
                       String annualTime) {
        this.pId = pId;
        this.pName = pName;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pProgress = pProgress;
        this.annualTime = annualTime;
    }

    public String getAnnualTime() {
        return annualTime;
    }

    public void setAnnualTime(String annualTime) {
        this.annualTime = annualTime;
    }

    public String getpProjectPhaseName() {
        return pProjectPhaseName;
    }

    public void setpProjectPhaseName(String pProjectPhaseName) {
        this.pProjectPhaseName = pProjectPhaseName;
    }

    @Override
    public String toString() {
        return "ProjectPlan{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pStartTime='" + pStartTime + '\'' +
                ", pEndTime='" + pEndTime + '\'' +
                ", pProjectPhaseId=" + pProjectPhaseId +
                ", pProgress=" + pProgress +
                ", createTime='" + createTime + '\'' +
                ", creater='" + creater + '\'' +
                ", annualTime='" + annualTime + '\'' +
                '}';
    }
}