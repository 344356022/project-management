package com.gedi.projectmanagement.service.impl.system;

import com.gedi.projectmanagement.dao.system.SysUserMapper;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.service.system.SysUserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 获取系统用户，以及对系统用户操作 业务逻辑层
 *
 * @Author: zhang xingya
 * @Date: 2019/6/28
 * @Version: 1.0
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryUserDetail(String userId) {

        return this.sysUserMapper.selectByPrimaryKey(userId);

    }

    @Override
    public CodeAndMsg selectAllUser() {
        if (sysUserMapper.selectAllUser().size() != 0 && sysUserMapper.selectAllUser() != null) {
            return CodeAndMsgUtil.setOK("查询成功", sysUserMapper.selectAllUser());
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public CodeAndMsg selectUserBySign(String department) {
        if (sysUserMapper.selectUserBySign(department).size() != 0 && sysUserMapper.selectUserBySign(department) != null) {
            return CodeAndMsgUtil.setOK("查询成功", sysUserMapper.selectUserBySign(department));
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

}
