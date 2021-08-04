package com.itest.sevice.impl;

import com.itest.dao.SlideshowDao;
import com.itest.pojo.Slideshow;
import com.itest.sevice.SlideshowService;
import com.itest.utils.MsgUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChanV
 * @create 2021-08-04-22:41
 */
@Service
public class SlideshowServiceImpl implements SlideshowService {

    @Resource
    private SlideshowDao slideshowDao;


    @Override
    public MsgUtils querySlideshow(Integer curPage, Integer pageSize) {
        try {
            List<Slideshow> slideshows = this.slideshowDao.querySlideshow(curPage, pageSize);
            return MsgUtils.build(200, "查询轮播图成功", slideshows);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
