package com.demo.services;/**
 * com.demo.services
 *
 * @Date 2020-12-21 17:30
 * @Version 1.0
 */

import com.demo.model.mdao.ShoppingMapper;
import com.demo.pojo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: ZhangWang
 * @description: TODO
 * @Classname ShoppingService
 * @Date 2020-12-21 17:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingService {
    @Autowired
    ShoppingMapper smapper;

    /*
     * @Author xieyukun
     * @Description up_ships
     * @Date 1:31 2020-12-25
     * @param [ship_list]
     * @return java.lang.Integer
     * 拿到所有要添加订单的购物车id   把他们的状态改为0--不可见
    */
    public Integer up_ships(List<Integer> ship_list){
        return smapper.up_ships(ship_list);
    }

    /*
     * @Author xieyukun
     * @Description up_cartNum
     * @Date 1:01 2020-12-25
     * @param [number, shid]
     * @return java.lang.Integer
     * 如果商品已经存在购物车  那么累加数量
    */
    public Integer up_cartNum(Integer number,Integer shid){
        try {
            smapper.up_cartNum(number, shid);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    /*
     * @Author xieyukun
     * @Description s_oldShopping
     * @Date 0:31 2020-12-25
     * @param [comid]
     * @return com.demo.pojo.Shopping
     * 根据新增商品的ID  查看购物车是否存在
    */
    public Shopping s_oldShopping(Integer comid){
        return smapper.s_oldShopping(comid);
    }

    /*
     * @Author xieyukun
     * @Description add_carts
     * @Date 21:00 2020-12-24
     * @param [cart]
     * @return com.demo.pojo.Shopping
     * 添加一条购物信息
    */
    public Shopping add_carts(Shopping cart){
        System.out.println("aaaaaaaaaaaa");
        smapper.add_carts(cart);
        return cart;
    }

    /*
     * @Author xieyukun
     * @Description add_Orderinfo
     * @Date 20:11 2020-12-24
     * @param [l]
     * @return java.lang.Integer
     * 添加订单详情
    */
    public List<OrderInfo> add_Orderinfo(List<OrderInfo> l){
            smapper.add_Orderinfo(l);
            return l;
    }

    /*
     * @Author xieyukun
     * @Description add_Order
     * @Date 17:16 2020-12-24
     * @param [adid, cid, pay, price, remarks, o_date]
     * @return java.lang.Integer
     * 添加一条订单
    */
    public Orders add_Order(Orders o){

            smapper.add_Order(o);
            return o;

    }


    /*
     * @Author xieyukun
     * @Description d_Cart_ByID
     * @Date 10:24 2020-12-24
     * @param [ship]
     * @return java.lang.Integer
     * 根据购物车ID  删除一条购物记录
    */
    public Integer d_Cart_ByID(List<Integer> ship){
        try {
            smapper.d_Cart_ByID(ship);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    /*
     * @Author xieyukun
     * @Description s_Carts
     * @Date 0:40 2020-12-24
     * @param []
     * @return java.util.List<com.demo.pojo.Shopping>
     查询所有购物车
    */
    public List<Shopping> s_Carts(Integer cid){
        return smapper.s_Carts(cid);
    }

    //根据商品ID  查看商品详情
    public List<SpCommodity> s_GoodsXiangQing(Integer goodsID){
        return smapper.s_GoodsXiangQing(goodsID);
    }

    //查询所有商品分类
    public List<SpCommoditycategory> s_GoodsType(){
        return smapper.s_GoodsType();
    }


    //根据商品分类id  查询该分类的所有商品
    public PageInfo<SpCommodity> s_Goods(Integer goodsTypeID,Integer pageNo,Integer pageSize){
        //1.配置分页信息（开始分页）
        PageHelper.startPage(pageNo,pageSize);
        //2.执行分页操作，默认认为是写在开始分页后面的查询方法
        // 会自动被PageHelper拦截下来，执行分页操作
        List<SpCommodity> list = smapper.s_Goods(goodsTypeID);
        //3.将分页数据封装到pageInfo中
        PageInfo<SpCommodity> info =new PageInfo<>(list);
        return info;
    }


}
