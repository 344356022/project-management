package com.gedi.projectmanagement.service.system;

import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.vo.CodeAndMsg;

/** 获取系统用户，以及对系统用户操作
 * @Author: zhang xingya
 * @Date: 2019/6/28
 * @Version: 1.0
 */
public interface SysUserService {

    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    SysUser queryUserDetail(String  userId);

    CodeAndMsg selectAllUser();

    //根据部门以及标签进行查询部门普通员工
    CodeAndMsg selectUserBySign(String department);
}
