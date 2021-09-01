package com.lls.service;

import com.lls.pojo.UserEntity;

/**
 * @Author: lls
 * @DateTime: 2021/9/1 15:24
 * @Description: TODO
 */
public interface UserService {
    /**
     *    登录验证
     * @param username
     * @param password
     * @return
     */
    UserEntity checklogin(String username, String password);
}
