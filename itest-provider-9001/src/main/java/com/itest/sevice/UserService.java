package com.itest.sevice;

import com.itest.pojo.User;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-08-02-17:16
 */
public interface UserService {


    /**
     * 用户登录
     * @param user
     * @return
     */
    MsgUtils userLogin(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    MsgUtils userRegister(User user);


    /**
     * 修改用户
     * @param user
     * @return
     */
    MsgUtils userUpdate(User user);

    /**
     * 查询用户
     * @param user
     * @return
     */
    User queryUser(int userId);
}
