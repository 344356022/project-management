package com.gedi.projectmanagement.scheduled;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserListRequest;
import com.dingtalk.api.response.OapiUserListResponse;
import com.gedi.projectmanagement.config.URLConstant;
import com.gedi.projectmanagement.dao.system.SysDepartmentMapper;
import com.gedi.projectmanagement.dao.system.SysUserDepartmentMapper;
import com.gedi.projectmanagement.model.User;
import com.gedi.projectmanagement.model.system.SysDepartment;
import com.gedi.projectmanagement.model.system.SysUser;
import com.gedi.projectmanagement.scheduled.DepartSynchScheduled;
import com.gedi.projectmanagement.service.UserService;
import com.gedi.projectmanagement.util.AccessTokenUtil;
import com.taobao.api.ApiException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private UserService userService;


    @Scheduled(cron = "0 00 03 * * ?")
    public  void queryDepartmentUsers() throws ApiException {
        logger.info("执行钉钉中用户信息同步>>>>>>>>>>>>>>>开始=="+new Date());

        this.userService.doSynchUserTask();

        logger.info("执行钉钉中用户信息同步>>>>>>>>>>>>>>>结束=="+new Date());
    }

}



