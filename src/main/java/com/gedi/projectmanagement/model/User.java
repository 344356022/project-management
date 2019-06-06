package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private String userId; // 用户ID

    private Integer uPhone; // 用户手机号

    private String uName; // 用户名称

    private String uDepartment; // 用户所属部门

    private Integer uSign; // 权限 1 超管，2 管理员，3 员工

    private Boolean uStatus; // 状态 0 正常，1 删除

    private Date createTime; // 用户创建时间

    private Date updateTime; // 修改时间

    private String creater; // 用户创建人

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public User() {
    }

    public User(String userId, Integer uPhone, String uName, String uDepartment, Integer uSign, Boolean uStatus, Date createTime, Date updateTime, String creater) {
        this.userId = userId;
        this.uPhone = uPhone;
        this.uName = uName;
        this.uDepartment = uDepartment;
        this.uSign = uSign;
        this.uStatus = uStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", uPhone=" + uPhone +
                ", uName='" + uName + '\'' +
                ", uDepartment='" + uDepartment + '\'' +
                ", uSign=" + uSign +
                ", uStatus=" + uStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creater='" + creater + '\'' +
                '}';
    }
}