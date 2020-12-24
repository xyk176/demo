package com.demo.controller;

import com.demo.pojo.Inventory;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import com.demo.services.SpProductService;
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
    SpProductServicts ps;
    @Autowired
    SpProductService pps;

    @RequestMapping("/insert")
    public void insert(@RequestBody SpProduct product){
        ps.insert(product);
    }

    @RequestMapping("/all")
    public PageInfo<vo> selectall(@RequestParam(value = "id" ,required = false)Integer id, @RequestParam("no")Integer no, @RequestParam("size")Integer size){
        PageInfo<vo> info=ps.selectall(id,no,size);
        return info;
    }

    @RequestMapping("/updateproduct")
    public void updateproduct(@RequestParam(value = "lname" ,required = false) String lname,
                              @RequestParam(value = "lguige" ,required = false) String lguige,
                              @RequestParam(value = "ldanwei" ,required = false) String ldanwei,
                              @RequestParam(value = "ltiaoma" ,required = false) Integer ltiaoma,
                              @RequestParam(value = "lchengben" ,required = false) String lchengben,
                              @RequestParam(value = "lid" ,required = false) Integer lid){
        ps.updateproduct(lname, lguige, ldanwei, ltiaoma, lchengben, lid);
        System.out.println(lname+lguige+ldanwei+ ltiaoma+lchengben+ lid);
    }

    @RequestMapping("/page")
    public PageInfo<SpProduct> page(@RequestParam("no") Integer pageNo,
                                @RequestParam(value = "size",required = false) Integer pageSize,
                                @RequestParam("lname")String lname){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<SpProduct> info = pps.selectAll(pageNo,size,lname);
        System.out.println("info:"+info);
        return info;
    }

    /*删除单品*/
    @RequestMapping("/delete")
    public int deleteByPrimaryKey(Integer lid){
        return ps.deleteByPrimaryKey(lid);
    }
    /*删除库存*/
    @RequestMapping("/delete2")
    public int deleteByPrimaryKey2(Integer lid){
        return ps.deleteByPrimaryKey2(lid);
    }

    /*修改单品分类*/
    @RequestMapping("/delectfenlei")
    public void delectfenlei(Integer lid){
        ps.delectfenlei(lid);
    }
}
