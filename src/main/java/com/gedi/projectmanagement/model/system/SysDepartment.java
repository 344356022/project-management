package com.gedi.projectmanagement.model.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_department")
public class SysDepartment {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "department_id")
    private String departmentId;

    /**
     * 部门名称
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 父部门ID，根部门为1
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    @Column(name = "create_dept_group")
    private Boolean createDeptGroup;

    /**
     * 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    @Column(name = "auto_add_user")
    private Boolean autoAddUser;

    /**
     * 是否隐藏部门，true表示隐藏，false表示显示
     */
    @Column(name = "dept_hiding")
    private Boolean deptHiding;

    /**
     * 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     */
    @Column(name = "outer_dept")
    private Boolean outerDept;

    /**
     * 企业群群主
     */
    @Column(name = "org_dept_owner")
    private String orgDeptOwner;

    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门
     */
    @Column(name = "source_identifier")
    private String sourceIdentifier;

    /**
     * 获取主键ID
     *
     * @return department_id - 主键ID
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置主键ID
     *
     * @param departmentId 主键ID
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * 获取部门名称
     *
     * @return department_name - 部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置部门名称
     *
     * @param departmentName 部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * 获取父部门ID，根部门为1
     *
     * @return parent_id - 父部门ID，根部门为1
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父部门ID，根部门为1
     *
     * @param parentId 父部门ID，根部门为1
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     *
     * @return create_dept_group - 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    public Boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    /**
     * 设置是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     *
     * @param createDeptGroup 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    /**
     * 获取当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     *
     * @return auto_add_user - 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    public Boolean getAutoAddUser() {
        return autoAddUser;
    }

    /**
     * 设置当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     *
     * @param autoAddUser 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     */
    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    /**
     * 获取是否隐藏部门，true表示隐藏，false表示显示
     *
     * @return dept_hiding - 是否隐藏部门，true表示隐藏，false表示显示
     */
    public Boolean getDeptHiding() {
        return deptHiding;
    }

    /**
     * 设置是否隐藏部门，true表示隐藏，false表示显示
     *
     * @param deptHiding 是否隐藏部门，true表示隐藏，false表示显示
     */
    public void setDeptHiding(Boolean deptHiding) {
        this.deptHiding = deptHiding;
    }

    /**
     * 获取是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     *
     * @return outer_dept - 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     */
    public Boolean getOuterDept() {
        return outerDept;
    }

    /**
     * 设置是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     *
     * @param outerDept 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     */
    public void setOuterDept(Boolean outerDept) {
        this.outerDept = outerDept;
    }

    /**
     * 获取企业群群主
     *
     * @return org_dept_owner - 企业群群主
     */
    public String getOrgDeptOwner() {
        return orgDeptOwner;
    }

    /**
     * 设置企业群群主
     *
     * @param orgDeptOwner 企业群群主
     */
    public void setOrgDeptOwner(String orgDeptOwner) {
        this.orgDeptOwner = orgDeptOwner == null ? null : orgDeptOwner.trim();
    }

    /**
     * 获取部门标识字段，开发者可用该字段来唯一标识一个部门
     *
     * @return source_identifier - 部门标识字段，开发者可用该字段来唯一标识一个部门
     */
    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    /**
     * 设置部门标识字段，开发者可用该字段来唯一标识一个部门
     *
     * @param sourceIdentifier 部门标识字段，开发者可用该字段来唯一标识一个部门
     */
    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier == null ? null : sourceIdentifier.trim();
    }
}