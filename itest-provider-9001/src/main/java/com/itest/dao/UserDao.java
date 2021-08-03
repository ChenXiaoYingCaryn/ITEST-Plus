package com.itest.dao;

import com.itest.pojo.User;
import org.apache.ibatis.annotations.Insert;
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
    @Select("SELECT user_id, user_account, user_pwd, user_name, user_sex, user_email, user_image, create_time " +
            "FROM it_user " +
            "WHERE user_account = #{user.userAccount} and user_pwd = #{user.userPwd} and is_deleted = 0")
    User userLogin(@Param("user") User user);

    /**
     * 用户注册
     * @param user
     */
    @Insert("INSERT INTO it_user (user_account, user_pwd, user_name, user_sex, user_email, user_image, user_role) " +
            "VALUES (#{user.userAccount}, #{user.userPwd}, #{user.userName}, #{user.userSex}, #{user.userEmail}, #{user.userImage}, #{user.userRole})")
    void userRegister(@Param("user") User user);

    /**
     * 判断用户是否已经注册
     * @param user
     * @return
     */
    @Select("SELECT * FROM it_user WHERE user_name = #{user.userName}")
    User userIsRegister(@Param("user") User user);

}
