//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gedi.projectmanagement.model.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(
        name = "sys_user_department"
)
public class SysUserDepartment {
    @Id
    @Column(
            name = "user_department_id"
    )
    private String userDepartmentId;
    @Column(
            name = "department_id"
    )
    private String departmentId;
    @Column(
            name = "user_id"
    )
    private String userId;

    public SysUserDepartment() {
    }

    public String getUserDepartmentId() {
        return this.userDepartmentId;
    }

    public void setUserDepartmentId(String userDepartmentId) {
        this.userDepartmentId = userDepartmentId == null ? null : userDepartmentId.trim();
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}
