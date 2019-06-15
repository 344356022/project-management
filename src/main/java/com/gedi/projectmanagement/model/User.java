package com.gedi.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

//用户实体类
public class User {
    private String userId; // 用户ID

    private String uPhone; // 用户手机号

    private String uName; // 用户名称

    private String uDepartment; // 用户所属部门

    private Integer uSign; // 权限 1 超管，2 管理员，3 员工

    private Integer uStatus; // 状态 0 正常，1 删除

    private String createTime; // 用户创建时间

    private String upStringTime; // 修改时间

    private String creater; // 用户创建人

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
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

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public User() {
    }

    public User(String userId, String uPhone, String uName, String uDepartment, Integer uSign, Integer uStatus, String createTime, String upStringTime, String creater) {
        this.userId = userId;
        this.uPhone = uPhone;
        this.uName = uName;
        this.uDepartment = uDepartment;
        this.uSign = uSign;
        this.uStatus = uStatus;
        this.createTime = createTime;
        this.upStringTime = upStringTime;
        this.creater = creater;
    }

    public User(String userId, String uPhone, String uName, String uDepartment) {
        this.userId = userId;
        this.uPhone = uPhone;
        this.uName = uName;
        this.uDepartment = uDepartment;
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
                ", upStringTime=" + upStringTime +
                ", creater='" + creater + '\'' +
                '}';
    }
}