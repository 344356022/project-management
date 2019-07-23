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

    //查询用户的唯一表示主键id值；
    List<SysUser> selectAllUserId();

    //删除表里的所有数据
    void deleteAllUserMessage();

    /**
     * 根据用户ID查询用户名称
     *
     * @param userId
     * @return
     */
    String selectNameByUserId(String userId);

    //根据用户ID值获取员工的具体信息
    SysUser selectUserById(String userId);

    //根据部门以及标签进行查询部门普通员工
    List<SysUser> selectUserByDepartment(String department);

    //查询双周计划中的操作人
    List<SysUser> queryCreater();

    //查询全部的员工
    List<SysUser> queryAllStaff();

}