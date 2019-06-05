package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangyanbin
 * @description 项目总计划实体类
 */
public class ProjectPlan {
    private String pId;

    private String pName;

    private Date pStartTime;

    private Date pEndTime;

    private Integer pProjectPhaseId;

    private BigDecimal pProgress;

    private Date createTime;

    private String creater;

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

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getpStartTime() {
        return pStartTime;
    }

    public void setpStartTime(Date pStartTime) {
        this.pStartTime = pStartTime;
    }

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getpEndTime() {
        return pEndTime;
    }

    public void setpEndTime(Date pEndTime) {
        this.pEndTime = pEndTime;
    }

    public Integer getpProjectPhaseId() {
        return pProjectPhaseId;
    }

    public void setpProjectPhaseId(Integer pProjectPhaseId) {
        this.pProjectPhaseId = pProjectPhaseId;
    }

    public BigDecimal getpProgress() {
        return pProgress;
    }

    public void setpProgress(BigDecimal pProgress) {
        this.pProgress = pProgress;
    }

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public ProjectPlan(String pId, String pName, Date pStartTime, Date pEndTime, Integer pProjectPhaseId, BigDecimal pProgress, Date createTime, String creater) {
        this.pId = pId;
        this.pName = pName;
        this.pStartTime = pStartTime;
        this.pEndTime = pEndTime;
        this.pProjectPhaseId = pProjectPhaseId;
        this.pProgress = pProgress;
        this.createTime = createTime;
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "ProjectPlan{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", pStartTime=" + pStartTime +
                ", pEndTime=" + pEndTime +
                ", pProjectPhaseId=" + pProjectPhaseId +
                ", pProgress=" + pProgress +
                ", createTime=" + createTime +
                ", creater='" + creater + '\'' +
                '}';
    }
}