package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductService
 * @Date 2020-12-21 21:32
 */
@Service
public class SpProductService {
    @Autowired
    SpProductMapper mapper;

    public void insert(SpProduct product) {
        mapper.insert(product);
    }
    // 查询单品表及其分类
    public List<vo> selectall(){
        return mapper.selectAll();
    }
}
