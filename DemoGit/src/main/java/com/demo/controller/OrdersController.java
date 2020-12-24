package com.demo.controller;

import com.demo.pojo.*;
import com.demo.services.OrdersServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: zouquanxing
 * @description: TODO
 * @Classname OrdersController
 * @Date 2020/12/22 9:18
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    OrdersServices os;

    /*
     * 分页查询所有订单（模糊查询）
     * */
    @RequestMapping("/all")
    public PageInfo<Orders> selectAll(Integer pageno, Integer size, String ortype, String orsip, String pay) {
        System.out.println("进入方法：" + pageno + "--" + size + "--" + ortype + "--" + orsip + "--" + pay);
        PageInfo<Orders> list = os.selectAll(pageno, size, ortype, orsip, pay);
        return list;
    }

    @RequestMapping("/selectcompic")
    public List<picvo> selectcompic(Integer oId){
        System.out.println(oId);
        return os.selectcompic(oId);
    }

    /*根据编号查询订单*/
    @RequestMapping("/seorder")
    public ordervo seorder(Integer oId){
        return os.seorder(oId);
    }

    /*根据编号修改订单状态*/
    @RequestMapping("uporder")
    public Integer uporder(Integer oId, String oDate, String pay, String price, String orsip, String remarks) throws ParseException {
        System.out.println("进入方法："+oId+"--"+oDate+"--"+pay+"--"+price+"--"+orsip+"--"+remarks);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        Date odate=simpleDateFormat.parse(oDate);
        BigDecimal bigDecimal=new BigDecimal(price);
        return os.uporder(oId,odate,pay,bigDecimal,orsip,remarks);
    }

    /*查询所有未发货订单*/
    @RequestMapping("wei")
    public PageInfo<Orders> orderstwo(Integer pageno,Integer size,String pay,String orsip){
        System.out.println("进入方法："+pageno+"--"+size+"--"+pay+"--"+orsip);
        PageInfo<Orders> list=os.orderstwo(pageno,size,pay,orsip);
        return list;
    }
}
