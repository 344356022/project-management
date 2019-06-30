package com.gedi.projectmanagement.dao.system;


import com.gedi.projectmanagement.base.GeneralMapper;
import com.gedi.projectmanagement.model.system.SysDepartmentManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SysDepartmentManagerMapper extends GeneralMapper<SysDepartmentManager> {

    /**
     * 根据部门ID 删除部门管理人
     * @param departmentId
     */
    void deleteByDepartmentId(@Param("departmentId") String departmentId);
}