package com.gedi.projectmanagement.dao.system;


import com.gedi.projectmanagement.base.GeneralMapper;
import com.gedi.projectmanagement.model.system.SysUserDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDepartmentMapper extends GeneralMapper<SysUserDepartment> {

    /**
     * 删除用户-部门关系
     * @param userIds 用户ID集合
     */
    void deleteAllMsg(@Param("list") List<String> userIds);

}