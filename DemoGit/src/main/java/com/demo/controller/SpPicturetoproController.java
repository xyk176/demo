package com.demo.controller;

import com.demo.pojo.SpPicturetopro;
import com.demo.pojo.SpProduct;
import com.demo.services.SpPicturetoproServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpPicturetoproController
 * @Date 2020-12-24 14:26
 */
@RestController
@RequestMapping("/picturetopro")
public class SpPicturetoproController {
    @Autowired
    SpPicturetoproServices ps;

    @RequestMapping("/add")
    public void insert(@RequestBody SpProduct record){
        System.out.println("什么鬼"+record);
        ps.insert(record);

    }
}
