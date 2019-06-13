package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据部门以及标签进行查询部门普通员工
    List<User> selectUserBySign();

    //通过调用钉钉第三方接口，获取部门下的所有员工信息，批量增添到自己的数据库中进行储存；
    void insertManyUserMessage(@Param("list") List<User> list);

    //查询用户的唯一表示主键id值；
    List<User> selectAllUserId();

    //删除表里的所有数据
    void deleteAllUserMessage();

    /**
     * 根据用户ID查询用户名称
     *
     * @param userId
     * @return
     */
    String selectNameByUserId(String userId);

}