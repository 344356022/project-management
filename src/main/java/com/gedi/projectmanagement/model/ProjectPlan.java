package com.gedi.projectmanagement.model;

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

    private Integer pProjectPhase;

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

    public Date getpStartTime() {
        return pStartTime;
    }

    public void setpStartTime(Date pStartTime) {
        this.pStartTime = pStartTime;
    }

    public Date getpEndTime() {
        return pEndTime;
    }

    public void setpEndTime(Date pEndTime) {
        this.pEndTime = pEndTime;
    }

    public Integer getpProjectPhase() {
        return pProjectPhase;
    }

    public void setpProjectPhase(Integer pProjectPhase) {
        this.pProjectPhase = pProjectPhase;
    }

    public BigDecimal getpProgress() {
        return pProgress;
    }

    public void setpProgress(BigDecimal pProgress) {
        this.pProgress = pProgress;
    }

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
}