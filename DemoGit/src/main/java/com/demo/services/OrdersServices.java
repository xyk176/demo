package com.demo.services;

import com.demo.model.mdao.OrdersMapper;
import com.demo.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public List<picvo> selectcompic(Integer oId){
        return mapper.selectcompic(oId);
    }

    /*根据编号查询订单*/
    public ordervo seorder(Integer oId){
        return mapper.seorder(oId);
    }

    /*根据订单编号修改订单状态*/
    public Integer uporder(Integer oId, Date oDate, String pay, BigDecimal price,String orsip,String remarks){
        Orders o=new Orders();
        o.setoId(oId);
        o.setoDate(oDate);
        o.setPay(pay);
        o.setPrice(price);
        o.setOrsip(orsip);
        o.setRemarks(remarks);
        o.setOrtype("已发货");
        return mapper.uporder(o);
    }

    /*查询未发货订单*/
    public PageInfo<Orders> orderstwo(Integer pageno, Integer size, String orsip, String pay){
        PageHelper.startPage(pageno,size);
        List<Orders> list=mapper.orderstwo(orsip,pay);
        PageInfo<Orders> ok=new PageInfo<>(list);
        return ok;
    }
}
