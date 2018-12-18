package com.yoona.service.impl;

import com.yoona.dao.UserDao;
import com.yoona.entity.User;
import com.yoona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:Service实现层：调用Dao层中的方法
 * @author yoona
 * @date:2018年8月26日
**/

@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private UserDao userDao;
    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }


}
