//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gedi.projectmanagement.model.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(
        name = "sys_department"
)
public class SysDepartment {
    @Id
    @Column(
            name = "department_id"
    )
    private String departmentId;
    @Column(
            name = "department_name"
    )
    private String departmentName;
    @Column(
            name = "parent_id"
    )
    private String parentId;
    @Column(
            name = "create_dept_group"
    )
    private Boolean createDeptGroup;
    @Column(
            name = "auto_add_user"
    )
    private Boolean autoAddUser;
    @Column(
            name = "dept_hiding"
    )
    private Boolean deptHiding;
    @Column(
            name = "outer_dept"
    )
    private Boolean outerDept;
    @Column(
            name = "org_dept_owner"
    )
    private String orgDeptOwner;
    @Column(
            name = "source_identifier"
    )
    private String sourceIdentifier;

    public SysDepartment() {
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Boolean getCreateDeptGroup() {
        return this.createDeptGroup;
    }

    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public Boolean getAutoAddUser() {
        return this.autoAddUser;
    }

    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    public Boolean getDeptHiding() {
        return this.deptHiding;
    }

    public void setDeptHiding(Boolean deptHiding) {
        this.deptHiding = deptHiding;
    }

    public Boolean getOuterDept() {
        return this.outerDept;
    }

    public void setOuterDept(Boolean outerDept) {
        this.outerDept = outerDept;
    }

    public String getOrgDeptOwner() {
        return this.orgDeptOwner;
    }

    public void setOrgDeptOwner(String orgDeptOwner) {
        this.orgDeptOwner = orgDeptOwner == null ? null : orgDeptOwner.trim();
    }

    public String getSourceIdentifier() {
        return this.sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier == null ? null : sourceIdentifier.trim();
    }
}
