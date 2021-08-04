package com.itest.dao;

import com.itest.pojo.Slideshow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-08-04-22:38
 */
@Mapper
@Repository
public interface SlideshowDao {

    @Select("SELECT image_id, image_introduction, image_url FROM it_slideshow WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Slideshow> querySlideshow(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
