package com.gedi.projectmanagement.dao;

import com.gedi.projectmanagement.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据部门以及标签进行查询部门普通员工
    List<User> selectUserBySign(String department);

}