package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
