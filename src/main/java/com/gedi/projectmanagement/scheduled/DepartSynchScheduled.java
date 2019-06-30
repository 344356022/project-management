package com.gedi.projectmanagement.scheduled;

import com.gedi.projectmanagement.service.system.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * 定时任务:
 * 1:同步用户 Timer.java
 * 2：同步部门
 * 3：同步角色 TODO
 * @author zhang xingya
 * @since 1.0.0
 */
@Component
public class DepartSynchScheduled {
    private static Logger logger = LoggerFactory.getLogger(DepartSynchScheduled.class);

	@Autowired
	private SysDepartmentService sysDepartmentService;

	/**
	 * 每天凌晨1点执行
     * 执行部门信息同步
	 */
    @Scheduled(cron = "0 00 01 * * ?")
	public void synchDepartmentScheduled(){
        logger.info("执行钉钉中部门信息同步>>>>>>>>>>>>>>>开始=="+new Date());

        this.sysDepartmentService.doSynchDepartmentTask();

        logger.info("执行钉钉中部门信息同步>>>>>>>>>>>>>>>结束=="+new Date());
	}


	
}
