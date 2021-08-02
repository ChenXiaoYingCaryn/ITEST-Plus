package com.itest.service;

import com.itest.pojo.User;
import com.itest.utils.MsgUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

/**
 * @author ChanV
 * @create 2021-08-02-18:01
 */
@FeignClient(value = "itest-provider-9001")
public interface UserService {

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping(value = "/user/userLogin")
    public MsgUtils login(@PathParam("user") User user);

}
