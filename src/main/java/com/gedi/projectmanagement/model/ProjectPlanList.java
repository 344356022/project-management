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

    private Integer pProjectPhase;
    private String tName;
    private String name;
    private String aname;
    private Date apstime;
    private Date apetime;
    private Date aastime;
    private Date aaetime;
    private Integer percentage;
    private Integer state;
    private Boolean isresult;

    public ProjectPlanList() {
    }

    public ProjectPlanList(Integer pProjectPhase, String tName, String name, String aname, Date apstime, Date apetime, Date aastime, Date aaetime, Integer percentage, Integer state, Boolean isresult) {
        this.pProjectPhase = pProjectPhase;
        this.tName = tName;
        this.name = name;
        this.aname = aname;
        this.apstime = apstime;
        this.apetime = apetime;
        this.aastime = aastime;
        this.aaetime = aaetime;
        this.percentage = percentage;
        this.state = state;
        this.isresult = isresult;
    }

    public Integer getpProjectPhase() {
        return pProjectPhase;
    }

    public void setpProjectPhase(Integer pProjectPhase) {
        this.pProjectPhase = pProjectPhase;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getApstime() {
        return apstime;
    }

    public void setApstime(Date apstime) {
        this.apstime = apstime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getApetime() {
        return apetime;
    }

    public void setApetime(Date apetime) {
        this.apetime = apetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAastime() {
        return aastime;
    }

    public void setAastime(Date aastime) {
        this.aastime = aastime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAaetime() {
        return aaetime;
    }

    public void setAaetime(Date aaetime) {
        this.aaetime = aaetime;
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

    public Boolean getIsresult() {
        return isresult;
    }

    public void setIsresult(Boolean isresult) {
        this.isresult = isresult;
    }

    @Override
    public String toString() {
        return "ProjectPlanList{" +
                "pProjectPhase=" + pProjectPhase +
                ", tName='" + tName + '\'' +
                ", name='" + name + '\'' +
                ", aname='" + aname + '\'' +
                ", apstime=" + apstime +
                ", apetime=" + apetime +
                ", aastime=" + aastime +
                ", aaetime=" + aaetime +
                ", percentage=" + percentage +
                ", state=" + state +
                ", isresult=" + isresult +
                '}';
    }
}
