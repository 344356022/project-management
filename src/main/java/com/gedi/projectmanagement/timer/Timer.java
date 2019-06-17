package com.gedi.projectmanagement.timer;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: renpu
 * @Date: 2019/6/9 16:01
 * @Description:
 */


@Component
public class Timer {


    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 00 15 * * ?")
    public  void queryDepartmentUsers() throws ApiException {

        //每次批量增添的数据都需要进行对库表之前存在的数据进行清空
        userService.deleteAllUserMessage();

        /*116706144:财务部, 116829123:人事行政部, 116692111:实施部,117488653:大数据研发中心],[117572421:开发组, 117568461:创意组, 117443437:需求组]*/

        List<Long> departmentIdValue= new ArrayList<>();

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

            List<User> users=new ArrayList<>();

            DingTalkClient client1 = new DefaultDingTalkClient(URLConstant.URL_USER_ListByGage);
            OapiUserListRequest request1 = new OapiUserListRequest();
            request1.setDepartmentId(aLong);
            request1.setOffset(0L);
            request1.setSize(100L);
            request1.setOrder("entry_desc");
            request1.setHttpMethod("GET");

            OapiUserListResponse listResponse = null;

            try {
                listResponse = client1.execute(request1,accessToken);
                System.out.println(accessToken+"------accessToken2--------");
                List<OapiUserListResponse.Userlist> userlist = listResponse.getUserlist();
                for (OapiUserListResponse.Userlist userlist1 : userlist) {
                            //将数据封装到自己的实体类
                            User user=new User();
                            user.setuName(userlist1.getName());
                            user.setUserId(userlist1.getUserid());
                            user.setuDepartment(userlist1.getDepartment());
                            user.setuPhone(userlist1.getMobile());
                            users.add(user);

                        }

                //调用用户相应增的方法，将数据增添到自己的数据库中；
                userService.insertManyUserMessage(users);
            } catch (ApiException e) {
                e.printStackTrace();
            }

            System.out.println("----------每天的早上08:30分执行定时器的任务执行了-------------");
        }


        }

        }

