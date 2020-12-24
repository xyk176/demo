package com.demo.controller;

import com.demo.pojo.Inventory;
import com.demo.pojo.Inventorylist;
import com.demo.services.InventoryServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname InventoryController
 * @Date 2020/12/21 21:06
 */

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryServices is;
    @RequestMapping("updatemaxcount")
    public Integer updatemaxcount( @RequestBody Inventorylist i){
        System.out.println(i);
        int a=0;
        for (Inventory o : i.getInventory()) {
            is.updatemaxcount(i.getMaxcount(),o.getInid());
            a++;
        }
        return a;
    }
    /*
     * @Author xieyukun
     * @Description page
     * @Date 9:25 2020/12/22
     * @param [pageNo, pageSize, lname, ltiaoma]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Inventory>
    */
    @RequestMapping("/selectAndproductAll")
    public PageInfo<Inventory> page(@RequestParam("no") Integer pageNo,
                               @RequestParam(value = "size",required = false) Integer pageSize,
                               @RequestParam("lname")String lname,
                               @RequestParam("ltiaoma")String ltiaoma){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Inventory> info = is.selectAndproductAll(pageNo,size,lname,ltiaoma);
        System.out.println("info:"+info);
        return info;
    }
}
