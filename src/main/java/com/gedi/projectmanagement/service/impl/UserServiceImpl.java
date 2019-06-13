package com.gedi.projectmanagement.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.UserMapper;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.gedi.projectmanagement.vo.CodeAndMsg;
import com.gedi.projectmanagement.vo.CodeAndMsgUtil;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public CodeAndMsg selectUserBySign() {

        if (userMapper.selectUserBySign().size() != 0 && userMapper.selectUserBySign() != null) {
            return CodeAndMsgUtil.setOK("查询成功", userMapper.selectUserBySign());
        } else {
            return CodeAndMsgUtil.setERROR("查询失败", null);
        }
    }

    @Override
    public CodeAndMsg insertManyUserMessage(List<User> list) {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        if (list.size() != 0) {
            userMapper.insertManyUserMessage(list);
            codeAndMsg.setMsg("添加成功");
            codeAndMsg.setResult(true);
            codeAndMsg.setCode(200);
        } else {
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

    @Override
    public CodeAndMsg updateUserMessage() {

        CodeAndMsg codeAndMsg = new CodeAndMsg();
        try {
            //每次批量增添的数据都需要进行对库表之前存在的数据进行清空
            userMapper.deleteAllUserMessage();

            /*116706144:财务部, 116829123:人事行政部, 116692111:实施部,117488653:大数据研发中心],[117572421:开发组, 117568461:创意组, 117443437:需求组]*/

            List<Long> departmentIdValue = new ArrayList<>();

            //开发组部门的Id值；
            departmentIdValue.add(117572421L);

            //财务部ID值
            departmentIdValue.add(116706144L);

            //人事行政部ID值
            departmentIdValue.add(116829123L);

            //实施部ID值
            departmentIdValue.add(116692111L);

            //创意组ID值
            departmentIdValue.add(117568461L);

            //需求组ID值
            departmentIdValue.add(117443437L);


            for (Long aLong : departmentIdValue) {


                String accessToken = AccessTokenUtil.getToken();

                List<User> users = new ArrayList<>();

                DingTalkClient client1 = new DefaultDingTalkClient(URLConstant.URL_USER_ListByGage);
                OapiUserListRequest request1 = new OapiUserListRequest();
                request1.setDepartmentId(aLong);
                request1.setOffset(0L);
                request1.setSize(100L);
                request1.setOrder("entry_desc");
                request1.setHttpMethod("GET");

                OapiUserListResponse listResponse = null;

                try {
                    listResponse = client1.execute(request1, accessToken);
                    System.out.println(accessToken + "------accessToken2--------");
                    List<OapiUserListResponse.Userlist> userlist = listResponse.getUserlist();
                    for (OapiUserListResponse.Userlist userlist1 : userlist) {
                        //将数据封装到自己的实体类
                        User user = new User();
                        user.setuName(userlist1.getName());
                        user.setUserId(userlist1.getUserid());
                        user.setuDepartment(userlist1.getDepartment());
                        user.setuPhone(userlist1.getMobile());
                        user.setUpStringTime(userlist1.getDepartment());
                        users.add(user);

                    }

                    //调用用户相应增的方法，将数据增添到自己的数据库中；
                    userMapper.insertManyUserMessage(users);
                } catch (ApiException e) {
                    e.printStackTrace();
                }

                System.out.println("----------每天的早上08:30分执行定时器的任务执行了-------------");
            }

            codeAndMsg.setMsg("更新用户信息成功");
            codeAndMsg.setCode(200);
            codeAndMsg.setResult(true);
        } catch (Exception e) {
            codeAndMsg.setMsg("更新用户信息失败");
            codeAndMsg.setCode(400);
            codeAndMsg.setResult(false);
        }

        return codeAndMsg;
    }

    @Override
    public String selectNameByUserId(String userId) {
        return userMapper.selectNameByUserId(userId);
    }
}
