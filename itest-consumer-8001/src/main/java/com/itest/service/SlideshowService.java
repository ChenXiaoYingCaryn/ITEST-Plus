package com.itest.service;

import com.itest.utils.MsgUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

/**
 * @author ChanV
 * @create 2021-08-04-22:46
 */
@FeignClient(value = "itest-provider-9001")
public interface SlideshowService {

    /**
     * 查询轮播图
     * @param curPage
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/index/slideshow/query/{curPage}/{pageSize}")
    MsgUtils querySlideshow(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize);

}
