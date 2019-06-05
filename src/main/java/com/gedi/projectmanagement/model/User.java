package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private String userId;

    private Integer uPhone;

    private String uName;

    private String uDepartment;

    private Integer uSign;

    private Boolean uStatus;

    private Date createTime;

    private Date updateTime;

    private String creater;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getuPhone() {
        return uPhone;
    }

    public void setuPhone(Integer uPhone) {
        this.uPhone = uPhone;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuDepartment() {
        return uDepartment;
    }

    public void setuDepartment(String uDepartment) {
        this.uDepartment = uDepartment;
    }

    public Integer getuSign() {
        return uSign;
    }

    public void setuSign(Integer uSign) {
        this.uSign = uSign;
    }

    public Boolean getuStatus() {
        return uStatus;
    }

    public void setuStatus(Boolean uStatus) {
        this.uStatus = uStatus;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }
}