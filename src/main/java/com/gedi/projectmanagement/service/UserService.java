package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.model.User;
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
}
