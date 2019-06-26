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


    //根据部门标记进行获取部门下所对应的所有员工以及ID值
    @GetMapping("selectUserByDepartment")
    public CodeAndMsg selectUserByDepartment(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String department = (String)session.getAttribute("uDepartment");
        return userService.selectUserBySign(department);
    }

    //根据项目总总计划维护页面 的tab页面    筛选出所对应的所有员工以及ID值
    @GetMapping("selectUserByTabFlag")
    public CodeAndMsg selectUserByTabFlag(String tabFlag) {
        String department="";
        if(tabFlag.equals("1")){//需求分析
            department="[117443437]";
        }else if(tabFlag .equals("2")){//数据处理
            department="[119455108]";
        }else if(tabFlag.equals("3")){//系统开发
            department="[117572421]";
        }else{
            return userService.selectAllUser();
        }
        return userService.selectUserBySign(department);
    }

}
