package com.demo.controller;

import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import com.demo.services.SpProductServicts;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductController
 * @Date 2020-12-21 21:34
 */
@RestController
@RequestMapping("/product")
public class SpProductController {

    @Autowired
    SpProductServicts ps;

    @RequestMapping("/insert")
    public void insert(@RequestBody SpProduct product){
        ps.insert(product);
    }

    @RequestMapping("/all")
    public PageInfo<vo> selectall(@RequestParam("no")Integer no, @RequestParam("size")Integer size){
        PageInfo<vo> info=ps.selectall(no,size);
        return info;
    }

}
