package com.gedi.projectmanagement.service;

import com.gedi.projectmanagement.vo.CodeAndMsg;

public interface UserService {

    //根据部门以及标签进行查询部门普通员工
    CodeAndMsg selectUserBySign(String department);
}
