package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

//项目任务类实体类
import java.util.List;

public class TaskClass {
    private String tId; // 任务类主键ID

    private String tName; // 任务类名称

    private String pId; // 项目总计划表主键

    private String createTime; // 任务类创建时间

    private String creater; // 任务类创建人

    private Integer pProjectPhaseId; // 项目阶段ID

    private List<TaskSubclass> taskSubclasses;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
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

    public Integer getpProjectPhaseId() {
        return pProjectPhaseId;
    }

    public void setpProjectPhaseId(Integer pProjectPhaseId) {
        this.pProjectPhaseId = pProjectPhaseId;
    }

    public TaskClass() {
    }

    public TaskClass(String tId, String tName, String pId, String createTime, String creater, Integer pProjectPhaseId) {
        this.tId = tId;
        this.tName = tName;
        this.pId = pId;
        this.createTime = createTime;
        this.creater = creater;
        this.pProjectPhaseId = pProjectPhaseId;
    }

    @Override
    public String toString() {
        return "TaskClass{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", pId='" + pId + '\'' +
                ", createTime=" + createTime +
                ", creater='" + creater + '\'' +
                ", pProjectPhaseId=" + pProjectPhaseId +
                '}';
    }
}