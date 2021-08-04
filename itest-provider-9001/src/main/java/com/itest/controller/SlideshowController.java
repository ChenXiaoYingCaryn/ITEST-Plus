package com.itest.controller;

import com.itest.sevice.SlideshowService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-08-04-22:43
 */
@RestController
@RequestMapping("/index/slideshow")
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @RequestMapping(value = "/query/{curPage}/{pageSize}", method = RequestMethod.GET)
    public MsgUtils querySlideshow(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize){
        return this.slideshowService.querySlideshow(curPage, pageSize);
    }

}
