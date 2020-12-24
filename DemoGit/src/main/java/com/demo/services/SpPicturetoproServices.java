package com.demo.services;

import com.demo.model.mdao.SpPicturetoproMapper;
import com.demo.pojo.SpPicturetopro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpPicturetoproServices
 * @Date 2020-12-24 14:24
 */
@Service
public class SpPicturetoproServices {
    @Autowired
    SpPicturetoproMapper mapper;

    public int insert(SpPicturetopro record){
        return mapper.insert(record);
    }
}
