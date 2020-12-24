package com.demo.services;

import com.demo.model.mdao.SpPictureMapper;
import com.demo.pojo.SpPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpPictureService
 * @Date 2020/12/23 16:05
 */

@Service
public class SpPictureService {
    @Autowired
    SpPictureMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 16:06 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicture>
     * 查询全部图片
    */
    public List<SpPicture> selectAll(){
        return mapper.selectAll();
    }
}
