package com.gedi.projectmanagement.dao.system;


import com.gedi.projectmanagement.base.GeneralMapper;
import com.gedi.projectmanagement.model.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends GeneralMapper<SysUser> {

    void batchUpdateUser(@Param("list") List<SysUser> userList);

}