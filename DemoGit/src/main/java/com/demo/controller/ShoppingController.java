package com.demo.controller;/**
 * com.demo.controller
 *
 * @Date 2020-12-21 17:35
 * @Version 1.0
 */

import com.demo.config.MyResult;
import com.demo.services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangWang
 * @description: TODO
 * @Classname ShoppingController
 * @Date 2020-12-21 17:35
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    ShoppingService ss;

    //查询所有商品分类
    @RequestMapping("/s_GoodsType")
    public MyResult s_GoodsType(){
        return MyResult.returnObjs(ss.s_GoodsType());
    }
}
