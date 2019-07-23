//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gedi.projectmanagement.model.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(
        name = "sys_department_manager"
)
public class SysDepartmentManager {
    @Id
    @Column(
            name = "dm_id"
    )
    private String dmId;
    @Column(
            name = "user_id"
    )
    private String userId;
    @Column(
            name = "department_id"
    )
    private String departmentId;

    public SysDepartmentManager() {
    }

    public String getDmId() {
        return this.dmId;
    }

    public void setDmId(String dmId) {
        this.dmId = dmId == null ? null : dmId.trim();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }
}
