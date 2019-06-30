package com.gedi.projectmanagement.dao.system;


import com.gedi.projectmanagement.base.GeneralMapper;
import com.gedi.projectmanagement.model.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends GeneralMapper<SysUser> {

    void batchUpdateUser(@Param("list") List<SysUser> userList);

    List<SysUser> selectAllUser();

    //根据部门以及标签进行查询部门普通员工
    List<SysUser> selectUserBySign(@Param("department") String department);

}