package com.demo.controller;

import com.demo.pojo.SpCommodity;
import com.demo.service.SpCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/textcoller")
public class textCotroller{
    @Autowired
    SpCommodityService comser;

    @RequestMapping("/selectall")
    public List<SpCommodity> selectall(){
        List<SpCommodity> list= comser.selectAll();
        for (SpCommodity spCommodity : list) {
            System.out.println("商品："+spCommodity);
        }
        return list;
    }


}
