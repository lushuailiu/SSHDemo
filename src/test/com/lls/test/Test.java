package com.lls.test;

import com.lls.action.UserAction;
import com.lls.dao.UserDao;
import com.lls.pojo.UserEntity;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: lls
 * @DateTime: 2021/8/31 15:49
 * @Description: TODO
 */

//测试web的时候,需要使用这两个
//@ContextConfiguration(locations = { "classpath:config/applicationContext*.xml", "classpath:config/springmvc.xml" })
//@WebAppConfiguration
public class Test {
    //定义变量
    ApplicationContext ac;   //读取Spring配置文件，返回上下文对象
    UserDao userDao; //用于接收一个UserServiceImpl实例

    @Before
    public void setUp() {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = ac.getBean(UserDao.class);
    }

    @org.junit.Test
    public void select() {
        UserEntity userEntity = userDao.selectByUsernameAndPassword("小刘", "123");
        System.out.println(userEntity);

    }

    @org.junit.Test
    public void findAll() {
        List<UserEntity> all = userDao.findAll();
    }

    @org.junit.Test
    public void action() {
        UserAction bean = ac.getBean(UserAction.class);
        System.out.println(bean);
        bean.login();
    }
}
