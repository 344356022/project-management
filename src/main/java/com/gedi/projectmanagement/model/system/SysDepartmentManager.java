package com.gedi.projectmanagement.model.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_department_manager")
public class SysDepartmentManager {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "dm_id")
    private String dmId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private String departmentId;

    /**
     * 获取主键ID
     *
     * @return dm_id - 主键ID
     */
    public String getDmId() {
        return dmId;
    }

    /**
     * 设置主键ID
     *
     * @param dmId 主键ID
     */
    public void setDmId(String dmId) {
        this.dmId = dmId == null ? null : dmId.trim();
    }

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
     * 获取部门ID
     *
     * @return department_id - 部门ID
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门ID
     *
     * @param departmentId 部门ID
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }
}