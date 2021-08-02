package com.itest.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * JTW工具类
 *
 * @author ChanV
 * @create 2021-02-23-15:05
 */

public class JwtTokenUtil {

    /**
     * 签名密钥
     */
    public static final String SIGN = "iTest418";

    /**
     * token有效期，默认两个小时
     */
    public static final Long EXPIRATION_TIME = 1000L*60*60*2;


    /**
     * 生成token
     * @param map
     * @return
     */
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        //默认2小时过期
        instance.add(Calendar.HOUR, 2);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) ->{
            builder.withClaim(k, v);
        });

        //指定令牌过期时间
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC512(SIGN));
        return token;
    }


    /**
     * 验证token 合法性
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC512(SIGN)).build().verify(token);
    }


    /**
     * 验证token合法性，并获取token中的信息
     * @param token
     * @return
     */
    public static String getPayload(String token){
        DecodedJWT decodedJWT = JwtTokenUtil.verify(token);
        return Base64Utils.decode(decodedJWT.getPayload());
    }


    /**
     * 从payload中获取userId
     * @param deCodePayload
     * @return
     */
    public static Long getUserId(String deCodePayload){
        JSONObject jsonObject = JSONObject.parseObject(deCodePayload);
        long user_id = Long.parseLong((String) jsonObject.get("user_id"));
        return user_id;
    }

    public static String getUsername(String deCodePayload){
        JSONObject jsonObject = JSONObject.parseObject(deCodePayload);
        String user_name = (String) jsonObject.get("user_name");
        return user_name;
    }
}