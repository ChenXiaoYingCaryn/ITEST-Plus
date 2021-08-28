package com.itest.controller;

import com.itest.service.SlideshowService;
import com.itest.utils.JwtTokenUtil;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ChanV
 * @create 2021-08-04-22:46
 */
@Api(tags = {"轮播图"})
@RestController
@Slf4j
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @Autowired
    RedisTemplate redisTemplate;

    @ApiOperation("查询轮播图")
    @PostMapping(value = "/index/slideshow/query/{curPage}/{pageSize}")
    public MsgUtils querySlideshow(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize, HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null){
            return MsgUtils.build(401, "请求未携带token");
        }
        if (redisTemplate.opsForValue().get(token) == null){
            return MsgUtils.build(401, "token已过期, 请重新登录");
        }
        try {
            JwtTokenUtil.verify(token);
        }catch (Exception e){
            e.printStackTrace();
            return MsgUtils.build(100, "验证token失败");
        }
        return this.slideshowService.querySlideshow(curPage, pageSize);

    }

}
