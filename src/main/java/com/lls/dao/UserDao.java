package com.lls.dao;

import com.lls.pojo.UserEntity;

import java.util.List;

/**
 * @Author: lls
 * @DateTime: 2021/8/21 20:23
 * @Description: TODO
 */
public interface UserDao {


    // 用户登录验证
    public UserEntity selectByUsernameAndPassword(String username, String password);

    public List<UserEntity> findAll();

}
