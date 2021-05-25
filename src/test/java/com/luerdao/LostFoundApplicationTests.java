package com.luerdao;

import com.luerdao.dao.UserMapper;
import com.luerdao.entity.User;
import com.luerdao.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostFoundApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userService.getUser("2018211683");
        System.out.println(user);
        String stu = userMapper.getStuByName("xzh");
        System.out.println("学号是"+stu);
    }

}
