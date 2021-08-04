package com.itest.sevice;

import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-08-04-22:40
 */
public interface SlideshowService {

    /**
     * 查询轮播图
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils querySlideshow(Integer curPage, Integer pageSize);

}
