package com.itest.dao;

import com.itest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ChanV
 * @create 2021-08-02-17:07
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select user_id, user_account, user_pwd, user_name, user_sex, user_email, user_image, create_time from it_user where user_account = #{user.userAccount} and user_pwd = #{user.userPwd} and is_deleted = 0")
    User userLogin(@Param("user") User user);

}
