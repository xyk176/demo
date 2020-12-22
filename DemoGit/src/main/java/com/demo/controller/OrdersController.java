package com.demo.controller;

import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpPicture;
import com.demo.services.OrdersServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SpCommodity> selectcompic(@RequestBody List<OrderInfo> list){
        List<SpCommodity> selectcompic = null;
        for (OrderInfo orderInfo : list) {
            System.out.println(orderInfo);
            selectcompic=os.selectcompic(orderInfo.getOiId());
        }
        return selectcompic;
    }


}
