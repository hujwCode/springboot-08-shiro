package com.kuang.service.impl;

import com.kuang.dao.UserDao;
import com.kuang.pojo.User;

import com.kuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hujiawei
 * @date 2020/5/29 11:32 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User queryUserByName(String userName) {
        return userDao.queryUserByName(userName);
    }
}
