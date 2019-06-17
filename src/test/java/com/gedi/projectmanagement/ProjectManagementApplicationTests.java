package com.gedi.projectmanagement;


import com.gedi.projectmanagement.model.Weekreport;
import com.gedi.projectmanagement.service.WeekReportService;
import com.gedi.projectmanagement.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementApplicationTests {

    @Autowired
    private WeekReportService weekReportService;

    @Test
    public void contextLoads() {
        String s = UUIDUtil.getUUID2();
        System.out.println(s);
    }

  /*  @Test
    public void test1(){
        weekReportService.addWeekReport(new Weekreport("78945612300aa","e6b0fda2b9a34d34aaa32e797adb2008",new Date(),new Date(),"21f7b679ae29402984b1ed58f04e4eca","f9dd3e12f01344b5be057f4a2a8542a2","f9dd3e12f01344b5be057f4a2a8542a2",100,20,20,"王宁",50));


    }*/

}
