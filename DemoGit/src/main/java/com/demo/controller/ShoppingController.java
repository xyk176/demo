package com.demo.controller;/**
 * com.demo.controller
 *
 * @Date 2020-12-21 17:35
 * @Version 1.0
 */

import com.demo.config.MyResult;
import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import com.demo.pojo.Shopping;
import com.demo.pojo.SpCommodity;
import com.demo.services.ShoppingService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
     * @Description up_ships
     * @Date 14:29 2020-12-25
     * @param [ship_list]
     * @return com.demo.config.MyResult
     * 购物完成  修改状态
    */
    @RequestMapping("/up_ships")
    public MyResult up_ships(@RequestBody List<Integer> ship_list){
        System.out.println("修改购物车状态--参数=="+ship_list);
        int i = ss.up_ships(ship_list);
        return i>0?MyResult.SUCCESS:MyResult.ERROR("修改购物车状态错误");
    }

    /*
     * @Author xieyukun
     * @Description up_cartNum
     * @Date 1:32 2020-12-25
     * @param [number, shid]
     * @return com.demo.config.MyResult
     * 如果商品已经存在购物车  那么累加数量
    */
    @RequestMapping("/up_cartNum")
    public MyResult up_cartNum(@RequestParam("number")Integer number,@RequestParam("shid") Integer shid){
        System.out.println("如果存在相同的物品--参数=="+number+"=="+shid);
        int i = ss.up_cartNum(number, shid);
        return i>0?MyResult.SUCCESS:MyResult.ERROR("修改错误");
    }

    /*
     * @Author xieyukun
     * @Description s_oldShopping
     * @Date 1:01 2020-12-25
     * @param [comid]
     * @return com.demo.config.MyResult
     * 查看添加的商品 是否已经存在于购物车中
    */
    @RequestMapping("/s_oldShopping")
    public MyResult s_oldShopping(Integer comid){
        return MyResult.returnObj(ss.s_oldShopping(comid));
    }

    /*
     * @Author xieyukun
     * @Description add_carts
     * @Date 1:02 2020-12-25
     * @param [cart]
     * @return com.demo.config.MyResult
     * 添加一条购物信息
    */
    @RequestMapping("/add_carts")
    public MyResult add_carts(@RequestBody Shopping cart){
        System.out.println(cart);
        return MyResult.returnObj(ss.add_carts(cart));
    }

    /*
     * @Author xieyukun
     * @Description add_Orderinfo
     * @Date 20:15 2020-12-24
     * @param [l]
     * @return com.demo.config.MyResult
     * 添加订单详情
    */
    @RequestMapping("/add_Orderinfo")
    public MyResult add_Orderinfo(@RequestBody List<OrderInfo> l){
        System.out.println(l);
        return MyResult.returnObj(ss.add_Orderinfo(l));
    }

    @RequestMapping("/add_Order")
    public MyResult add_Order(@RequestBody Orders o ){
        return MyResult.returnObj(ss.add_Order(o));
    }

    /*
     * @Author xieyukun
     * @Description d_Cart_ByID
     * @Date 17:18 2020-12-24
     * @param [shid]
     * @return com.demo.config.MyResult
     * 批量删除购物车  物理删除
    */
    @RequestMapping("/d_Cart_ByID")
    public MyResult d_Cart_ByID(@RequestBody List<Integer> shid){
        int result = ss.d_Cart_ByID(shid);
        return result>0?MyResult.SUCCESS:MyResult.ERROR("修改失败");
    }

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
