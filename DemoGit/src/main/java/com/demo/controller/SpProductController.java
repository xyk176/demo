package com.demo.controller;

import com.demo.pojo.Inventory;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import com.demo.services.SpProductServicts;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PageInfo<vo> selectall(@RequestParam(value = "id" ,required = false)Integer id, @RequestParam("no")Integer no, @RequestParam("size")Integer size){
        PageInfo<vo> info=ps.selectall(id,no,size);
        return info;
    }

    @RequestMapping("/updateproduct/{lid}")
    public void updateproduct(@RequestBody SpProduct product,@PathVariable Integer lid){
        System.out.println(lid);
        ps.updateproduct(product,lid);
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
