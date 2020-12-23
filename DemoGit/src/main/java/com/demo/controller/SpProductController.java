package com.demo.controller;

import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import com.demo.services.SpProductService;
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
    SpProductService ps;

    @RequestMapping("/insert")
    public void insert(@RequestBody SpProduct product){
        ps.insert(product);
    }

    @RequestMapping("/all")
    public List<vo> selectall(){
        return ps.selectall();
    }

    @RequestMapping("/page")
    public PageInfo<SpProduct> page(@RequestParam("no") Integer pageNo,
                                @RequestParam(value = "size",required = false) Integer pageSize,
                                @RequestParam("lname")String lname){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<SpProduct> info = ps.selectAll(pageNo,size,lname);
        System.out.println("info:"+info);
        return info;
    }
}
