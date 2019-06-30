package com.gedi.projectmanagement.model.system;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "user")
public class SysUser {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 分机号（仅限企业内部开发调用）
     */
    private String tel;

    /**
     * 办公地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 备注
     */
    private String remark;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 员工电子邮箱
     */
    private String email;

    /**
     * 员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     */
    @Column(name = "org_email")
    private String orgEmail;

    /**
     * 是否已经激活，true表示已激活，false表示未激活
     */
    private Boolean active;

    /**
     * 是否为企业的管理员，true表示是，false表示不是
     */
    @Column(name = "is_admin")
    private Boolean isAdmin;

    /**
     * 是否为企业的老板，true表示是，false表示不是
     */
    @Column(name = "is_boss")
    private Boolean isBoss;

    /**
     * 是否号码隐藏，true表示隐藏，false表示不隐藏
     */
    @Column(name = "is_hide")
    private Boolean isHide;

    /**
     * 成员所属部门id列表
     */
    private String department;

    /**
     * 职位信息
     */
    private String position;

    /**
     * 头像url
     */
    private String acatar;

    /**
     * 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    @Column(name = "hired_date")
    private Date hiredDate;

    /**
     * 员工工号
     */
    @Column(name = "job_number")
    private String jobNumber;

    /**
     * 是否是高管
     */
    @Column(name = "is_leader")
    private Boolean isLeader;

    /**
     * 国家地区码
     */
    @Column(name = "state_code")
    private String stateCode;

    /**
     * 如果是管理员。管理员角色级别，1:主管理员，2:子管理员
     */
    @Column(name = "sys_level")
    private Long sysLevel;

    /**
     * 部门ID集合
     * 成员所属部门id列表
     */
    @Transient
    private List<String> departmentIds;



    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     *
     * @return union_id - 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     *
     * @param unionId 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * 获取员工姓名
     *
     * @return name - 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工姓名
     *
     * @param name 员工姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分机号（仅限企业内部开发调用）
     *
     * @return tel - 分机号（仅限企业内部开发调用）
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置分机号（仅限企业内部开发调用）
     *
     * @param tel 分机号（仅限企业内部开发调用）
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取办公地点
     *
     * @return work_place - 办公地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置办公地点
     *
     * @param workPlace 办公地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取员工电子邮箱
     *
     * @return email - 员工电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置员工电子邮箱
     *
     * @param email 员工电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     *
     * @return org_email - 员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     */
    public String getOrgEmail() {
        return orgEmail;
    }

    /**
     * 设置员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     *
     * @param orgEmail 员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     */
    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail == null ? null : orgEmail.trim();
    }

    /**
     * 获取是否已经激活，true表示已激活，false表示未激活
     *
     * @return active - 是否已经激活，true表示已激活，false表示未激活
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 设置是否已经激活，true表示已激活，false表示未激活
     *
     * @param active 是否已经激活，true表示已激活，false表示未激活
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 获取是否为企业的管理员，true表示是，false表示不是
     *
     * @return is_admin - 是否为企业的管理员，true表示是，false表示不是
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置是否为企业的管理员，true表示是，false表示不是
     *
     * @param isAdmin 是否为企业的管理员，true表示是，false表示不是
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取是否为企业的老板，true表示是，false表示不是
     *
     * @return is_boss - 是否为企业的老板，true表示是，false表示不是
     */
    public Boolean getIsBoss() {
        return isBoss;
    }

    /**
     * 设置是否为企业的老板，true表示是，false表示不是
     *
     * @param isBoss 是否为企业的老板，true表示是，false表示不是
     */
    public void setIsBoss(Boolean isBoss) {
        this.isBoss = isBoss;
    }

    /**
     * 获取是否号码隐藏，true表示隐藏，false表示不隐藏
     *
     * @return is_hide - 是否号码隐藏，true表示隐藏，false表示不隐藏
     */
    public Boolean getIsHide() {
        return isHide;
    }

    /**
     * 设置是否号码隐藏，true表示隐藏，false表示不隐藏
     *
     * @param isHide 是否号码隐藏，true表示隐藏，false表示不隐藏
     */
    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    /**
     * 获取成员所属部门id列表
     *
     * @return department - 成员所属部门id列表
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置成员所属部门id列表
     *
     * @param department 成员所属部门id列表
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 获取职位信息
     *
     * @return position - 职位信息
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位信息
     *
     * @param position 职位信息
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取头像url
     *
     * @return acatar - 头像url
     */
    public String getAcatar() {
        return acatar;
    }

    /**
     * 设置头像url
     *
     * @param acatar 头像url
     */
    public void setAcatar(String acatar) {
        this.acatar = acatar == null ? null : acatar.trim();
    }

    /**
     * 获取入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     *
     * @return hired_date - 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * 设置入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     *
     * @param hiredDate 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * 获取员工工号
     *
     * @return job_number - 员工工号
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * 设置员工工号
     *
     * @param jobNumber 员工工号
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    /**
     * 获取是否是高管
     *
     * @return is_leader - 是否是高管
     */
    public Boolean getIsLeader() {
        return isLeader;
    }

    /**
     * 设置是否是高管
     *
     * @param isLeader 是否是高管
     */
    public void setIsLeader(Boolean isLeader) {
        this.isLeader = isLeader;
    }

    /**
     * 获取国家地区码
     *
     * @return state_code - 国家地区码
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * 设置国家地区码
     *
     * @param stateCode 国家地区码
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode == null ? null : stateCode.trim();
    }

    /**
     * 获取如果是管理员。管理员角色级别，1:主管理员，2:子管理员
     *
     * @return sys_level - 如果是管理员。管理员角色级别，1:主管理员，2:子管理员
     */
    public Long getSysLevel() {
        return sysLevel;
    }

    /**
     * 设置如果是管理员。管理员角色级别，1:主管理员，2:子管理员
     *
     * @param sysLevel 如果是管理员。管理员角色级别，1:主管理员，2:子管理员
     */
    public void setSysLevel(Long sysLevel) {
        this.sysLevel = sysLevel;
    }

    public List<String> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<String> departmentIds) {
        this.departmentIds = departmentIds;
    }
}