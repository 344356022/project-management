package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskSubclass {
    private String tsId;

    private String tsName;

    private String pId;

    private String tId;

    private Date createTime;

    private String creater;

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

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

    public TaskSubclass() {
    }

    public TaskSubclass(String tsId, String tsName, String pId, String tId, Date createTime, String creater) {
        this.tsId = tsId;
        this.tsName = tsName;
        this.pId = pId;
        this.tId = tId;
        this.createTime = createTime;
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "TaskSubclass{" +
                "tsId='" + tsId + '\'' +
                ", tsName='" + tsName + '\'' +
                ", pId='" + pId + '\'' +
                ", tId='" + tId + '\'' +
                ", createTime=" + createTime +
                ", creater='" + creater + '\'' +
                '}';
    }
}