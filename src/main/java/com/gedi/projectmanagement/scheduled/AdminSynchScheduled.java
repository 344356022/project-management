package com.gedi.projectmanagement.scheduled;

import com.gedi.projectmanagement.service.UserService;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**  定时任务：获取管理员列表
 * 同时更新到数据库里
 * @Author: zhang xingya
 * @Date: 2019/6/30 16:01
 * @Description:
 */


@Component
public class AdminSynchScheduled {
    private static Logger logger = LoggerFactory.getLogger(AdminSynchScheduled.class);

    @Autowired
    private UserService userService;


    @Scheduled(cron = "0 00 04 * * ?")
    public  void queryDepartmentUsers() throws ApiException {
        logger.info("执行钉钉中获取管理员列表同步>>>>>>>>>>>>>>>开始=="+new Date());

//        this.userService.doSynchAdminTask();

        logger.info("执行钉钉中获取管理员列表同步>>>>>>>>>>>>>>>结束=="+new Date());
    }

}



