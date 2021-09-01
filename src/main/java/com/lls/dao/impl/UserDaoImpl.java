package com.lls.dao.impl;

import com.lls.dao.UserDao;
import com.lls.pojo.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.List;

/**
 * @Author: lls
 * @DateTime: 2021/8/21 20:24
 * @Description: TODO
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {



    /**
     * 使用hibernate提供的模板
     */
    @Autowired
    @Resource
    HibernateTemplate hibernateTemplate;

    @Autowired
    SessionFactory sessionFactory;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public UserEntity selectByUsernameAndPassword(String username, String password) {
        // 登录的逻辑不算难，就是使用 sql 语句查询，username 和 password 两个字段是否存在即可,我们使用的是 hibernate 框架，所以要写 hql 语句
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Query q = session.createQuery("from UserEntity u where u.username = ? and u.password = ?");
        q.setParameter(0,username);
        q.setParameter(1,password);
        UserEntity u = (UserEntity) q.uniqueResult();
        return u;
    }

    @Override
    public List<UserEntity> findAll() {
        // System.out.println(sessionFactory);
        // Query from_user = sessionFactory.getCurrentSession().getNamedQuery("FROM UserEntity");
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Query query = session.createQuery("from UserEntity");
        List list = query.list();
        return list;
    }
}
