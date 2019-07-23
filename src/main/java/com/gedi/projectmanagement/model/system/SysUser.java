//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gedi.projectmanagement.model.system;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(
        name = "user"
)
public class SysUser {
    @Id
    @Column(
            name = "user_id"
    )
    private String userId;
    @Column(
            name = "union_id"
    )
    private String unionId;
    private String name;
    private String tel;
    @Column(
            name = "work_place"
    )
    private String workPlace;
    private String remark;
    private String mobile;
    private String email;
    @Column(
            name = "org_email"
    )
    private String orgEmail;
    private Boolean active;
    @Column(
            name = "is_admin"
    )
    private Boolean isAdmin;
    @Column(
            name = "is_boss"
    )
    private Boolean isBoss;
    @Column(
            name = "is_hide"
    )
    private Boolean isHide;
    private String department;
    private String position;
    private String acatar;
    @Column(
            name = "hired_date"
    )
    private Date hiredDate;
    @Column(
            name = "job_number"
    )
    private String jobNumber;
    @Column(
            name = "is_leader"
    )
    private Boolean isLeader;
    @Column(
            name = "state_code"
    )
    private String stateCode;
    @Column(
            name = "sys_level"
    )
    private Long sysLevel;
    @Transient
    private List<String> departmentIds;

    public SysUser() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUnionId() {
        return this.unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getWorkPlace() {
        return this.workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOrgEmail() {
        return this.orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail == null ? null : orgEmail.trim();
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsBoss() {
        return this.isBoss;
    }

    public void setIsBoss(Boolean isBoss) {
        this.isBoss = isBoss;
    }

    public Boolean getIsHide() {
        return this.isHide;
    }

    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAcatar() {
        return this.acatar;
    }

    public void setAcatar(String acatar) {
        this.acatar = acatar == null ? null : acatar.trim();
    }

    public Date getHiredDate() {
        return this.hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getJobNumber() {
        return this.jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public Boolean getIsLeader() {
        return this.isLeader;
    }

    public void setIsLeader(Boolean isLeader) {
        this.isLeader = isLeader;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode == null ? null : stateCode.trim();
    }

    public Long getSysLevel() {
        return this.sysLevel;
    }

    public void setSysLevel(Long sysLevel) {
        this.sysLevel = sysLevel;
    }

    public List<String> getDepartmentIds() {
        return this.departmentIds;
    }

    public void setDepartmentIds(List<String> departmentIds) {
        this.departmentIds = departmentIds;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", remark='" + remark + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", orgEmail='" + orgEmail + '\'' +
                ", active=" + active +
                ", isAdmin=" + isAdmin +
                ", isBoss=" + isBoss +
                ", isHide=" + isHide +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", acatar='" + acatar + '\'' +
                ", hiredDate=" + hiredDate +
                ", jobNumber='" + jobNumber + '\'' +
                ", isLeader=" + isLeader +
                ", stateCode='" + stateCode + '\'' +
                ", sysLevel=" + sysLevel +
                ", departmentIds=" + departmentIds +
                '}';
    }
}
