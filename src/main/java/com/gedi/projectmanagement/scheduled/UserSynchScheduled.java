package com.gedi.projectmanagement.scheduled;

import com.gedi.projectmanagement.service.system.SysUserService;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**  定时任务：抓取用户信息
 * 同时更新到数据库里
 * @Author: renpu
 * @Date: 2019/6/9 16:01
 * @Description:
 */


@Component
public class UserSynchScheduled {
    private static Logger logger = LoggerFactory.getLogger(DepartSynchScheduled.class);

    @Autowired
    private SysUserService sysUserService;


    @Scheduled(cron = "0 00 03 * * ?")
    public  void queryDepartmentUsers() {
        logger.info("执行钉钉中用户信息同步>>>>>>>>>>>>>>>开始=="+new Date());

        this.sysUserService.doSynchUserTask();

        logger.info("执行钉钉中用户信息同步>>>>>>>>>>>>>>>结束=="+new Date());
    }

}



