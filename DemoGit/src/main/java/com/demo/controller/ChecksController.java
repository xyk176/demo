package com.demo.controller;

import com.demo.pojo.Checks;
import com.demo.services.ChecksServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname ChecksController
 * @Date 2020/12/23 9:14
 */
@RestController
@RequestMapping("/checks")
public class ChecksController {
    @Autowired
    ChecksServices cs;
    @RequestMapping("selectAndproduct")
    public PageInfo<Checks> selectAndproduct(@RequestParam("no") Integer pageNo,
                                 @RequestParam(value = "size",required = false) Integer pageSize,
                                 @RequestParam("cheid")Integer cheid,
                                 @RequestParam("lname")String lname,
                                 @RequestParam("ltiaoma")String ltiaoma,
                                 @RequestParam("date1")String date1,
                                 @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Checks> info = cs.selectAndproduct(pageNo,size, cheid, lname, ltiaoma, date1,  date2);
        System.out.println("info:"+info);
        return info;
    }
}
