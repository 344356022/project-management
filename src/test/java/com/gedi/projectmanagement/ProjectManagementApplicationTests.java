package com.gedi.projectmanagement;


import com.gedi.projectmanagement.mapper.UserMapper;
import com.gedi.projectmanagement.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}
