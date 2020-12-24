package com.demo.services;

import com.demo.model.mdao.SpPicturesortMapper;
import com.demo.pojo.SpPicturesort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpPicturesortService
 * @Date 2020/12/23 16:06
 */

@Service
public class SpPicturesortService {
    @Autowired
    SpPicturesortMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description selectAllByPic
     * @Date 16:07 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicturesort>
     * 关联图片查询全部图片分组
    */
    public List<SpPicturesort> selectAllByPic(){
        return mapper.selectAllByPic();
    }
}
