package com.demo.services;

import com.demo.model.mdao.OrdersMapper;
import com.demo.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Autowired
    InventoryServices is;
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
        mapper.uporder(o);
        System.out.println(o);


        List<OrderInfo> oi=mapper.selectorderinfo(o.getoId());
        System.out.println(oi);
        List<SpCommodity> arr;
        List<SpProduct> arr2;
        for (OrderInfo oir : oi) {
            System.out.println(oir.getOiId());
            arr=mapper.selectspcom(oir.getOiId());
            System.out.println(arr);
            arr2=mapper.selectproduct(mapper.selectspcom(oir.getOiId()).get(0).getComid());
            System.out.println(arr2);
            /*System.out.println(mapper.selectproduct(mapper.selectspcom(oir.getOiId()).get(0).getComid()));*/
        }
        Output output=new Output();
        output.setOutdate(new Timestamp(System.currentTimeMillis()));
        output.setOutclass("销售出库");
        /*新增出库单*/
        Output out= mapper.insertoutput(output);
        int a=0;

        /*遍历出库单新增出库详情单*/
        for (Outputxq oxq : output.getOutputxqs()) {
            /*新增出库详情*/
            oxq.setOutput(output);
            mapper.insertoutputxq(oxq);
            mapper.updatekucunjian(oxq.getOutxqcount(),oxq.getOutxqcount(),oxq.getSproduct().getInventorys().get(0).getInid());
            Outandinput outandinput=new Outandinput();
            outandinput.setOutinclass("销售出库");
            outandinput.setOutincount(oxq.getOutxqcount());
            outandinput.setProduct(oxq.getSproduct());
            outandinput.setOutindate(new Timestamp(System.currentTimeMillis()));
            /*出入库明细新增*/
            /*mapper.insert(outandinput);*/
            a++;
        }
        return a;


        /*System.out.println(oi.get(0).getOiId());
        List<SpCommodity> sp= mapper.selectspcom(oi.get(0).getOiId());
        System.out.println(sp.get(0).getComid());
        List<SpProduct> spp=mapper.selectproduct(sp.get(0).getComid());
        System.out.println(spp.get(0));
        System.out.println(spp.get(1));

        System.out.println(oi.get(1).getOiId());
        List<SpCommodity> sp2= mapper.selectspcom(oi.get(1).getOiId());
        System.out.println(sp2.get(0).getComid());
        List<SpProduct> spp2=mapper.selectproduct(sp2.get(0).getComid());
        System.out.println(spp2.get(0));
        System.out.println(spp2.get(1));*/

        /*Output output=new Output();
        output.setOutid(null);
        output.setOrderss(o);
        output.setOutclass("销售出库");
        output.setOutdate(new Timestamp(System.currentTimeMillis()));
        mapper.insertoutput(output);
        System.out.println(output.getOutid());

        Outputxq outputxq=new Outputxq();*/


    }

    /*查询未发货订单*/
    public PageInfo<Orders> orderstwo(Integer pageno, Integer size, String orsip, String pay){
        System.out.println(orsip+"--"+pay);
        PageHelper.startPage(pageno,size);
        List<Orders> list=mapper.orderstwo(orsip,pay);
        PageInfo<Orders> ok=new PageInfo<>(list);
        return ok;
    }
}
