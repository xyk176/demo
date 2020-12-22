package com.demo.controller;

import com.demo.pojo.Beput;
import com.demo.services.BeputServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname BeputController
 * @Date 2020/12/22 16:38
 */

@RestController
@RequestMapping("/beput")
public class BeputController {
    @Autowired
    BeputServices bs;
    @RequestMapping("selectAll")
    public PageInfo<Beput> page(@RequestParam("no") Integer pageNo,
                              @RequestParam(value = "size",required = false) Integer pageSize,
                              @RequestParam("beclass")String beclass,
                              @RequestParam("beid")Integer beid,
                              @RequestParam("yewuid")Integer yewuid,
                              @RequestParam("suname")String suname,
                              @RequestParam("date1")String date1,
                              @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Beput> info = bs.selectAll(pageNo,size, beclass, beid, yewuid, suname, date1, date2);
        System.out.println("info:"+info);
        return info;
    }
}
