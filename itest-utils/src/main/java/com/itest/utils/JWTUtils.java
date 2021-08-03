package com.itest.utils;

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
public class JWTUtils {

    private static final String SIGN = "itest";

    //生成Token
    //header.payload.sign
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) ->{
            builder.withClaim(k, v);
        });


        String token = builder.withExpiresAt(instance.getTime())       //指定令牌过期时间
                .sign(Algorithm.HMAC256(SIGN));         //sign
        return token;
    }




    //验证token 合法性
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    //验证token合法性，并获取token中的信息
    public static String getTokenInfo(String token){
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return Base64Utils.decode(decodedJWT.getPayload());
    }

}
