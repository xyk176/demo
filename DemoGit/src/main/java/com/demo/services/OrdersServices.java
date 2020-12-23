package com.demo.services;

import com.demo.model.mdao.OrdersMapper;
import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import com.demo.pojo.SpCommodity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: zouquanxing
 * @description: TODO
 * @Classname OrdersServices
 * @Date 2020/12/22 9:14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrdersServices {
    @Autowired
    OrdersMapper mapper;
    /*
    * 分页查询所有订单（模糊查询）
    * */
    public PageInfo<Orders> selectAll(Integer pageno, Integer size, String ortype, String orsip, String pay){
        System.out.println("乱码："+pay);
        PageHelper.startPage(pageno,size);
        List<Orders> list=mapper.selectAll(ortype,orsip,pay);
        PageInfo<Orders> in=new PageInfo<>(list);
        return in;
    }

    /*
    * 查询所有商品和图片
    * */
    public List<SpCommodity> selectcompic(Integer oiId){
        return mapper.selectcompic(oiId);
    }
}
