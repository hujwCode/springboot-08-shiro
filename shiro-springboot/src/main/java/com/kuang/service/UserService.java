package com.kuang.service;

import com.kuang.pojo.User;

/**
 * @author hujiawei
 * @date 2020/5/29 11:26 下午
 */
public interface UserService {
    User queryUserByName(String userName);

}
