package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.UserMapper;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CodeAndMsg selectUserBySign(String department) {

        if(userMapper.selectUserBySign(department).size()!=0){
            return CodeAndMsgUtil.setOK("查询成功",userMapper.selectUserBySign(department));
        }else{
            return CodeAndMsgUtil.setERROR("查询失败",null);
        }
    }
}
