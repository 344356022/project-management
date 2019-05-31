package com.gedi.projectmanagement.model;

import java.math.BigDecimal;
import java.util.Date;

public class Journal {
    private String rbId;

    private String wId;

    private String pId;

    private String aId;

    private String userId;

    private Integer finish;

    private String finishContent;

    private BigDecimal finishProcess;

    private String deliver;

    private Date createTime;

    private String creater;

    public String getRbId() {
        return rbId;
    }

    public void setRbId(String rbId) {
        this.rbId = rbId;
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

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public String getFinishContent() {
        return finishContent;
    }

    public void setFinishContent(String finishContent) {
        this.finishContent = finishContent;
    }

    public BigDecimal getFinishProcess() {
        return finishProcess;
    }

    public void setFinishProcess(BigDecimal finishProcess) {
        this.finishProcess = finishProcess;
    }

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
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