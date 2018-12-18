package com.yoona.service;

import com.yoona.entity.User;

import java.util.List;


/**
 * @Description:Service接口层
 * @author yoona
 * @date:2018年8月26日
**/

public interface UserService {

    List<User> findAll();
    User findById(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

}
