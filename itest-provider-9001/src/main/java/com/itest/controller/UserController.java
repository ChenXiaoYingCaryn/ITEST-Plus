package com.itest.controller;


import com.itest.pojo.User;
import com.itest.pojo.User1;
import com.itest.sevice.User1Service;
import com.itest.sevice.UserService;
import com.itest.utils.MsgUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChanV
 * @create 2021-08-02-17:21
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private User1Service user1Service;

    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public MsgUtils login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){

        if (StringUtils.isBlank(user.getUserAccount()) || StringUtils.isBlank(user.getUserPwd())){
            return MsgUtils.build(400, "用户名或密码不能为空");
        }
        return this.userService.userLogin(user);
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public MsgUtils register(@RequestBody User user){
        if (user.getUserAccount() == null || user.getUserPwd() == null){
            return MsgUtils.build(400, "用户名和密码不能为空");
        }
        return this.userService.userRegister(user);
    }


    //修改的代码
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public MsgUtils update(@RequestBody User user,User1 user1){
        //查询指定的用户
        User user2 = userService.queryUser(user.getUserId());
        System.out.println(user2);
        if(!user.getUserAccount().equals("string")){
            user2.setUserAccount(user.getUserAccount());
        }
        if(!user.getUserEmail().equals("string")){
            user2.setUserEmail(user.getUserEmail());
        }
        if(!user.getUserName().equals("string")){
            user2.setUserName(user.getUserName());
        }
        if(!user.getUserImage().equals("string")){
            user2.setUserImage(user.getUserEmail());
        }
        if(!user.getUserPwd().equals("string")){
            user2.setUserPwd(user.getUserPwd());
        }
        if(!user.getUserRole().equals("string")){
            user2.setUserRole(user.getUserRole());
        }
        if(!user.getUserSex().equals("string")){
            user2.setUserSex(user.getUserSex());
        }
        this.userService.userUpdate(user2);
        user1.setUserId(user.getUserId());
        return this.user1Service.user1Upate(user1);
    }







}
