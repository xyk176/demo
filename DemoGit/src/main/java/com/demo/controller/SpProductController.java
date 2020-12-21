package com.demo.controller;

import com.demo.pojo.SpProduct;
import com.demo.services.SpProductServicts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductController
 * @Date 2020-12-21 19:31
 */
@RestController
@RequestMapping("/product")
public class SpProductController {
    @Autowired
    SpProductServicts ps;

    @RequestMapping("insert")
    public void insert(SpProduct product){
        ps.insert(product);
    }
}
