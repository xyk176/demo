package com.demo.services;

import com.demo.model.mdao.InventoryMapper;
import com.demo.model.mdao.OrdersMapper;
import com.demo.model.mdao.OutputMapper;
import com.demo.model.mdao.OutputxqMapper;
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
    InventoryMapper is;
    @Autowired
    OutputxqMapper om;
    @Autowired
    OutandinputServices ois;
    @Autowired
    OutputServices os;
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
        SpCommodity arr;
        int coms = 0;
        int comd = 0;
        List<SpProduct> arr2=null;
        for (OrderInfo oir : oi) {
            System.out.println(oir.getOiId());
            arr=mapper.selectspcom(oir.getOiId());
            System.out.println(arr);
            arr2=mapper.selectproduct(arr.getComid());
            System.out.println(arr2);
            
            for (SpProduct spProduct : arr2) {
                comd=spProduct.getCommoditytopro().get(0).getCtpnum();
                System.out.println("单品数量"+spProduct.getCommoditytopro().get(0).getCtpnum());
            }
            /*System.out.println(mapper.selectproduct(mapper.selectspcom(oir.getOiId()).get(0).getComid()));*/
            coms=oir.getComs()*comd;
            System.out.println(coms);
            
        }
        Output output=new Output();
        output.setOrderss(o);
        output.setOutdate(new Timestamp(System.currentTimeMillis()));
        output.setOutclass("销售出库");
        /*新增出库单*/
        Output out= os.insertoutput(output);
        int a=0;
        for (SpProduct sp : arr2) {
            Outputxq oxq=new Outputxq();
            oxq.setOutput(out);
            oxq.setOutxqcount(coms);
            oxq.setSproduct(sp);
            om.insert(oxq);
            System.out.println(oxq);

            is.updatekucunjian(coms,coms,oxq.getSproduct().getInventorys().get(0).getInid());
            System.out.println(oxq.getSproduct().getInventorys().get(0).getInid());
            Outandinput outandinput=new Outandinput();
            outandinput.setOutinclass("销售出库");
            outandinput.setOutincount(coms);
            outandinput.setProduct(sp);
            outandinput.setOutindate(new Timestamp(System.currentTimeMillis()));
            /*出入库明细新增*/
            ois.insert(outandinput);
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
    public PageInfo<Orders> orderstwo(Integer pageno, Integer size, String pay, String orsip){
        System.out.println(orsip+"--"+pay);
        PageHelper.startPage(pageno,size);
        List<Orders> list=mapper.orderstwo(pay,orsip);
        PageInfo<Orders> ok=new PageInfo<>(list);
        return ok;
    }
}
