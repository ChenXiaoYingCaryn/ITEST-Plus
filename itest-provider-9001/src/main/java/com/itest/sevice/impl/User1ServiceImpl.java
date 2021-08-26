package com.itest.sevice.impl;

import com.itest.dao.User1Dao;
import com.itest.dao.UserDao;
import com.itest.pojo.User;
import com.itest.pojo.User1;
import com.itest.sevice.User1Service;
import com.itest.utils.JwtTokenUtil;
import com.itest.utils.MsgUtils;
import com.itest.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class User1ServiceImpl implements User1Service {

    @Resource
    private User1Dao user1Dao;


    @Override
    public MsgUtils user1Upate(User1 user1) {

        try {
           this.user1Dao.user1Upate(user1);
            return MsgUtils.build(200, "修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return MsgUtils.build(100, e.getMessage());
        }
    }
    }

