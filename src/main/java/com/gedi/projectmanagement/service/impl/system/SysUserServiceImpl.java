package com.gedi.projectmanagement.service.impl.system;

import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.system.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 获取系统用户，以及对系统用户操作 业务逻辑层
 * @Author: zhang xingya
 * @Date: 2019/6/28
 * @Version: 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryUserDetail(String userId) {

        return this.sysUserMapper.selectByPrimaryKey(userId);

    }
}
