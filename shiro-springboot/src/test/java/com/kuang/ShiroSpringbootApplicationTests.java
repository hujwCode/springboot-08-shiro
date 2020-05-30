package com.kuang;

import com.kuang.dao.UserDao;
import com.kuang.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("李四"));

    }
    @Test
    void contextLoads1() {
        System.out.println(userDao.selectByPrimaryKey(2));

    }


}
