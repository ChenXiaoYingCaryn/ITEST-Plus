package com.itest.sevice;

import com.itest.pojo.User;
import com.itest.pojo.User1;
import com.itest.utils.MsgUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface User1Service {
    //用户修改

    MsgUtils user1Upate(User1 user1);
}
