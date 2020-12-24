package com.demo.controller;/**
 * com.demo.controller
 *
 * @Date 2020-12-21 17:35
 * @Version 1.0
 */

import com.demo.config.MyResult;
import com.demo.pojo.SpCommodity;
import com.demo.services.ShoppingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*
     * @Author xieyukun
     * @Description s_Carts
     * @Date 0:42 2020-12-24
     * @param []
     * @return com.demo.config.MyResult
     * 查询所有购物车
    */
    @RequestMapping("/s_Carts")
    public MyResult s_Carts(Integer cid){
        System.out.println("客户ID=="+cid);
        return MyResult.returnObjs(ss.s_Carts(cid));
    }

    /*
     * @Author xieyukun
     * @Description s_GoodsXiangQing
     * @Date 0:43 2020-12-24
     * @param [goodsID]
     * @return com.demo.config.MyResult
     * 根据商品ID  查看商品详情
    */
    @RequestMapping("/s_GoodsXiangQing")
    public MyResult s_GoodsXiangQing(Integer goodsID){
        return MyResult.returnObjs(ss.s_GoodsXiangQing(goodsID));
    }

    /*
     * @Author xieyukun
     * @Description s_Goods
     * @Date 0:43 2020-12-24
     * @param [goodsTypeID, pageNo, pageSize]
     * @return com.demo.config.MyResult
     * 根据商品分类id  查询该分类的所有商品
    */
    @RequestMapping("/s_Goods")
    public MyResult s_Goods(Integer goodsTypeID,Integer pageNo , Integer pageSize){
        int no = (pageNo!=null && pageNo>=1)?pageNo:1;
        int size = (pageSize!=null && pageSize>=1)?pageSize:8;
        PageInfo<SpCommodity> pageInfo=ss.s_Goods(goodsTypeID, pageNo, pageSize);
        return MyResult.returnObj(pageInfo);
    }

    /*
     * @Author xieyukun
     * @Description s_GoodsType
     * @Date 0:43 2020-12-24
     * @param []
     * @return com.demo.config.MyResult
     * 查询所有商品分类
    */
    @RequestMapping("/s_GoodsType")
    public MyResult s_GoodsType(){
        return MyResult.returnObjs(ss.s_GoodsType());
    }
}
