package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName: ProjectPlanList
 * @Description: 项目计划清单
 * @Author zhangshuai
 * @Date 2019/6/3 16:50
 * @Version 1.0
 **/
public class ProjectPlanList {

    private Integer pProjectPhaseId; // 项目阶段ID
    private String tName; // 任务类名称
    private String tsName; // 任务子类名称
    private String aName; // 任务项名称
    private Date apsTime; // 计划开始时间
    private Date apeTime; // 计划结束时间
    private Date aasTime; // 实际开始时间
    private Date aaeTime; // 实际结束时间
    private Integer percentage; // 完成百分比
    private Integer state; // 状态
    private Boolean aisResult; // 成果是否提交  0 待提交 1 已提交
    private String username; // 负责人

    public ProjectPlanList() {
    }

    public ProjectPlanList(Integer pProjectPhaseId, String tName, String tsName, String aName, Date apsTime, Date apeTime, Date aasTime, Date aaeTime, Integer percentage, Integer state, Boolean aisResult, String username) {
        this.pProjectPhaseId = pProjectPhaseId;
        this.tName = tName;
        this.tsName = tsName;
        this.aName = aName;
        this.apsTime = apsTime;
        this.apeTime = apeTime;
        this.aasTime = aasTime;
        this.aaeTime = aaeTime;
        this.percentage = percentage;
        this.state = state;
        this.aisResult = aisResult;
        this.username = username;
    }

    public Integer getpProjectPhaseId() {
        return pProjectPhaseId;
    }

    public void setpProjectPhaseId(Integer pProjectPhaseId) {
        this.pProjectPhaseId = pProjectPhaseId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getApsTime() {
        return apsTime;
    }

    public void setApsTime(Date apsTime) {
        this.apsTime = apsTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getApeTime() {
        return apeTime;
    }

    public void setApeTime(Date apeTime) {
        this.apeTime = apeTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAasTime() {
        return aasTime;
    }

    public void setAasTime(Date aasTime) {
        this.aasTime = aasTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAaeTime() {
        return aaeTime;
    }

    public void setAaeTime(Date aaeTime) {
        this.aaeTime = aaeTime;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getResult() {
        return aisResult;
    }

    public void setResult(Boolean result) {
        aisResult = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ProjectPlanList{" +
                "pProjectPhaseId=" + pProjectPhaseId +
                ", tName='" + tName + '\'' +
                ", tsName='" + tsName + '\'' +
                ", aName='" + aName + '\'' +
                ", apsTime=" + apsTime +
                ", apeTime=" + apeTime +
                ", aasTime=" + aasTime +
                ", aaeTime=" + aaeTime +
                ", percentage=" + percentage +
                ", state=" + state +
                ", aisResult=" + aisResult +
                ", username='" + username + '\'' +
                '}';
    }
}
