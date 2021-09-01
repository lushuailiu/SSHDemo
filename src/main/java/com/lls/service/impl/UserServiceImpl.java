package com.lls.service.impl;

import com.lls.dao.UserDao;
import com.lls.pojo.UserEntity;
import com.lls.service.UserService;
import com.lls.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lls
 * @DateTime: 2021/9/1 15:25
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {
    // 这里业务层调用持久层的方法
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity checklogin(String username, String password) {
        String pd = MD5Utils.md5(password);
        return userDao.selectByUsernameAndPassword(username,pd);
    }
}
