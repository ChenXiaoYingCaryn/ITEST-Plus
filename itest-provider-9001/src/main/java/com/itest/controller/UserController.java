package com.itest.controller;


import com.itest.pojo.User;
import com.itest.sevice.UserService;
import com.itest.utils.MsgUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    RedisTemplate redisTemplate;


    @PostMapping("/userLogin")
    public MsgUtils login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){

        if (StringUtils.isBlank(user.getUserAccount()) || StringUtils.isBlank(user.getUserPwd())){
            return MsgUtils.build(400, "用户名或密码不能为空");
        }
        return this.userService.userLogin(user);
    }

    @PostMapping("/userRegister")
    public MsgUtils register(@RequestBody User user){
        if (user.getUserAccount() == null || user.getUserPwd() == null){
            return MsgUtils.build(400, "用户名和密码不能为空");
        }
        return this.userService.userRegister(user);
    }







}
