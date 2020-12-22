package com.demo.controller;

import com.demo.pojo.SpProductsort;
import com.demo.services.SpProductsortServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductsortController
 * @Date 2020-12-22 10:48
 */
@RestController
@RequestMapping("/sort")
public class SpProductsortController {

    @Autowired
    SpProductsortServices ps;

    @RequestMapping("/all")
    public List<SpProductsort> selectFu(){
        return ps.selectFu();
    }
    @RequestMapping("/byid")
    public List<SpProductsort> selectByid(Integer id){
        return ps.selectByid(id);
    }

    @RequestMapping("/add")
    public void insert(@RequestBody SpProductsort r){
        System.out.println(r);
        ps.insert(r);
    }
}
