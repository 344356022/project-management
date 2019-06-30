package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //根据部门以及标签进行查询部门普通员工
    CodeAndMsg selectUserBySign(String department);

    //通过调用钉钉第三方接口，获取部门下的所有员工信息，批量增添到自己的数据库中进行储存；
    CodeAndMsg insertManyUserMessage(@Param("list") List<User> list);

    //查询用户的唯一表示主键id值；
    List<User> selectAllUserId();

    //删除表里的所有数据
    void deleteAllUserMessage();

    //手动进行维护用户数据；
    CodeAndMsg updateUserMessage();

    //根据用户ID值获取员工的具体信息
    CodeAndMsg selectUserById(String userId);

    //查询全部员工
   CodeAndMsg selectAllUser();

    /**
     * 根据用户ID查询用户名称
     *
     * @param userId
     * @return
     */
    String selectNameByUserId(String userId);

    /**
     * 批量插入用户
     * @param users
     */
    void batchInsertUser(List<SysUser> users);

    /**
     * 执行同步用户信息定时计划
     */
    void doSynchUserTask();

    /**
     * 执行同步获取管理员列表
     */
    void doSynchAdminTask() throws Exception;
}
