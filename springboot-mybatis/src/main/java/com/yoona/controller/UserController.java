package com.yoona.controller;

import com.yoona.entity.User;
import com.yoona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * @Description:写一个Restful接口(实现用户的增删改查),调用Service层的方法来实现增删改查
 * @author:yoona
 * @date:2018年8月26日
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserService userService;


    @RequestMapping(value="/findAll",method=RequestMethod.GET)
    public List<User> findAll(){
        System.out.println("查询所有用户");
        List<User> userList = userService.findAll();
        for(User user :userList) {
            System.out.println("用户："+user);
        }
        return userList;
    }

    /**
     * @Description:根据用户ID查询用户信息
     * 访问地址：http://localhost:8088/users/findById/1
     * 在postman插件中选择GET方法
     * @param id
     * @return
     * @author:yoona
     * @date:2018年8月26日
     */
    @RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
    public User findById(@PathVariable("id") int id) {
        System.out.println("根据用户ID查询用户信息");
        User user = userService.findById(id);
        System.out.println("用户："+user);
        return user;
    }

    /**
     * @Description:新增用户
     * 访问地址：http://localhost:8088/users/insertUser
     * 在postman插件中选择POST方法，然后在body中填写要增加的信息
     * {"userId":"27","userName":"老王","userAge":"27","userSex":"男"}
     * @param user
     * @return
     * @author:yoona
     * @date:2018年8月26日
     */
    @RequestMapping(value="/insertUser",method=RequestMethod.POST)
    public String insertUser(@RequestBody User user) {
        System.out.println("新增用户");
        int result = userService.insertUser(user);
        if(result == 1) {
            return "success";
        }else {
            return "error";
        }
    }
    /**
     * @Description:修改用户
     * 访问地址：http://localhost:8088/users/updateUser
     * 在postman插件中选择PUT方法，然后在body中填写要修改的信息
     * {"userId":"27","userName":"老王","userAge":"60","userSex":"女"}
     * @param user
     * @return
     * @author:yoona
     * @date:2018年8月26日
     */
    @RequestMapping(value="/updateUser",method=RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        System.out.println("修改用户");
        int result = userService.updateUser(user);
        if(result == 1) {
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * @Description:根据用户ID删除用户
     * 访问地址：http://localhost:8088/users/deleteUser?id=xx
     * @param id
     * @return
     * @author:yoona
     * @date:2018年8月26日
     */
    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    public String deleteUser(@RequestParam("id") int id) {
        System.out.println("根据用户ID删除用户");
        int result = userService.deleteUser(id);
        if(result == 1) {
            return "success";
        }else {
            return "error";
        }
    }

}
