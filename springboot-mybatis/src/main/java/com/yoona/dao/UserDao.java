package com.yoona.dao;

import java.util.List;


import org.apache.ibatis.annotations.*;

import com.yoona.entity.User;

/**
 * @Description:用户映射类，调用UserDao.xml中的SQL方法
 * @author yoona
 * @date:2018年8月26日
 */



    @Mapper
    public interface UserDao {

        List<User> findAll();
        User findById(int id);
        int insertUser(User user);
        int updateUser(User user);
        int deleteUser(int id);

    }
