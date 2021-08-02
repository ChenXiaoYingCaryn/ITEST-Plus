package com.itest.controller;

import com.itest.pojo.User;
import com.itest.service.UserService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChanV
 * @create 2021-08-02-18:16
 */
@Api(tags = {"用户"})
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @ApiOperation("用户登录")
    @PostMapping(value = "/consumer/login/userLogin")
    public MsgUtils login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        log.info("用户名: " + user.getUserAccount());
        log.info("密码: " + user.getUserPwd());
        MsgUtils msg = this.userService.login(user);
        String token = (String) msg.getData();
        if (token != null){
            response.addHeader("token", token);
            return new MsgUtils(200, "登陆成功");
        }else {
            return new MsgUtils(msg.getCode(), msg.getMsg());
        }
    }

}
