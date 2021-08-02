package com.itest.sevice.impl;

import com.itest.dao.RedisDao;
import com.itest.dao.UserDao;
import com.itest.pojo.User;
import com.itest.sevice.UserService;
import com.itest.utils.JwtTokenUtil;
import com.itest.utils.MsgUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChanV
 * @create 2021-08-02-17:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Resource
    private RedisDao redisDao;


    @Override
    public MsgUtils userLogin(User user) {
        try {
            //根据用户id和密码获取用户信息
            User DBUser = this.userDao.userLogin(user);
            if(DBUser == null){
                return MsgUtils.build(405,"用户名或密码错误");
            }
            //生成token
            Map<String, String> map = new HashMap<String, String>();
            map.put("user_id", DBUser.getUserId()+"");
            map.put("user_role", DBUser.getUserRole());
            String token = JwtTokenUtil.getToken(map);
            redisDao.put(token, String.valueOf(DBUser.getUserId()), 1000L * 60 * 60);
            return MsgUtils.build(200, "登录成功", token);
        }catch (Exception e){
            e.printStackTrace();
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
