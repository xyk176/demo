package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductServicts
 * @Date 2020-12-21 19:27
 */
@Service
public class SpProductServicts {

    @Autowired
    SpProductMapper mapper;

    public void insert(SpProduct product) {
        mapper.insert(product);
    }
}
