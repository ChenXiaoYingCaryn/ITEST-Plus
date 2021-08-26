package com.itest.dao;

import com.itest.pojo.User;
import com.itest.pojo.User1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface User1Dao {

    /**
     * 用户修改 kwq
     * @param
     * @return
     */
    @Update("update it_userinfo set user_nickname=#{user1.userNickname}," +
            "user_interest=#{user1.userInterest}," +
            "user_address=#{user1.userAddress}" +
            "WHERE user_id = #{user1.userId}")
    int user1Upate(@Param("user1") User1 user1);

}
