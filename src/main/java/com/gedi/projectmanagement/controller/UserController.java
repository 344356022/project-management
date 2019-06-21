package com.gedi.projectmanagement.controller;

import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: renpu
 * @Date: 2019/6/10 8:36
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //手动维护用户信息
    @RequestMapping("/updateUserMessage")
    public CodeAndMsg updateUserMessage(){
       return userService.updateUserMessage();
    }


    //获取责任人
    @GetMapping("selectAllUser")
    public CodeAndMsg selectAllUser() {
        return userService.selectAllUser();
    }
}
