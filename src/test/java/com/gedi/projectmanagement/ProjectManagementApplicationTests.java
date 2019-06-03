package com.gedi.projectmanagement;


import com.gedi.projectmanagement.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementApplicationTests {

    @Test
    public void contextLoads() {
        String s = UUIDUtil.getUUID2();
        System.out.println(s);
    }

}
