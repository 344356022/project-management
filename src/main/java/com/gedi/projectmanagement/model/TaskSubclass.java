package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
//项目任务子类实体类
public class TaskSubclass {
    private String tsId; // 任务子类主键ID

    private String tsName; // 任务子类名称

    private String pId; // 项目总计划表主键

    private String tId; // 任务类ID

    private Date createTime; // 任务子类创建时间

    private String creater; // 任务子类创建人

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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