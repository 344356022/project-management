package com.gedi.projectmanagement.service.impl;

import com.gedi.projectmanagement.dao.UserMapper;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CodeAndMsg selectUserBySign(String department) {

        if(userMapper.selectUserBySign(department).size()!=0&&userMapper.selectUserBySign(department)!=null){
            return CodeAndMsgUtil.setOK("查询成功",userMapper.selectUserBySign(department));
        }else{
            return CodeAndMsgUtil.setERROR("查询失败",null);
        }
    }

    @Override
    public CodeAndMsg insertManyUserMessage(List<User> list) {

        CodeAndMsg codeAndMsg=new CodeAndMsg();
        if(list.size()!=0){
            userMapper.insertManyUserMessage(list);
            codeAndMsg.setMsg("添加成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setCode(200);
        }else {
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);
            codeAndMsg.setMsg("添加失败");
        }
        return codeAndMsg;
    }

    @Override
    public List<User> selectAllUserId() {
        return userMapper.selectAllUserId();
    }

    @Override
    public void deleteAllUserMessage() {
        userMapper.deleteAllUserMessage();
    }
}
