package com.demo.services;/**
 * com.demo.services
 *
 * @Date 2020-12-21 17:30
 * @Version 1.0
 */

import com.demo.model.mdao.ShoppingMapper;
import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpCommoditycategory;
import com.demo.pojo.SpCommoditytopro;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
