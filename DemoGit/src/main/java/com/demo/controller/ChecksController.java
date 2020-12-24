package com.demo.controller;

import com.demo.pojo.*;
import com.demo.services.*;
import com.github.pagehelper.PageInfo;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname ChecksController
 * @Date 2020/12/23 9:14
 */
@RestController
@RequestMapping("/checks")
public class ChecksController {
    @Autowired
    ChecksServices cs;
    @Autowired
    BeputServices bs;
    @Autowired
    InventoryServices is;

    @Autowired
    OutputServices os;
    @Autowired
    OutandinputServices ois;
    @RequestMapping("insert")
    public Integer insertcheccks(@RequestBody Checks c){
        int a=0;
        c.setChedate(new Timestamp(System.currentTimeMillis()));
        c.setChestate(1);
        Checks check=cs.insert(c);
        System.out.println(c);
        for (Checkxq cx : c.getCheckxqs()) {
            System.out.println(cx.getProduct());
            System.out.println(cx);
            cx.setChecks(check);
            cs.insertxq(cx);
            System.out.println(cx.getProduct());
            is.updateinentity(cx.getChexqcount(),cx.getChexqcount(),cx.getProduct().getInventorys().get(0).getInid());
            if(cx.getCheblcount()>0){
                Beput b=new Beput();
                /*盘盈*/
                b.setBeclass("盘盈入库");
                b.setBeremark(c.getCheremark());
                b.setYewuid(c.getCheid());
                b.setBedate(new Timestamp(System.currentTimeMillis()));
                Beput bid= bs.insert(b);
                    System.out.println(b);
                    Beputxq bexq=new Beputxq();
                    bexq.setBeput(bid);
                    bexq.setLibecount(cx.getCheblcount());
                    bexq.setProduct(cx.getProduct());
                    //新增入库详情
                    bs.insertxq(bexq);
                    Outandinput o = new Outandinput();
                    /*出入库明细添加*/
                    o.setOutinclass("盘盈入库");
                    /*盈亏数量*/
                    o.setOutincount(cx.getCheblcount());
                    o.setProduct(cx.getProduct());
                    o.setOutindate(new Timestamp(System.currentTimeMillis()));
                    ois.insert(o);
            }else{
                /*盘亏*/
                Output o=new Output();
                o.setOutclass("盘亏出库");
                o.setOutremark(c.getCheremark());
                o.setYewuid(c.getCheid());
                o.setOutdate(new Timestamp(System.currentTimeMillis()));
                /*新增出库单*/
                Output output= os.insertoutput(o);
                    /*新增出库详情*/
                    Outputxq oxq=new Outputxq();
                    oxq.setOutput(o);
                    oxq.setOutxqcount(-cx.getCheblcount());
                    oxq.setSproduct(cx.getProduct());
                    os.insertoutputxq(oxq);
                    Outandinput oi=new Outandinput();
                    oi.setOutinclass("盘亏出库");
                    /*盈亏数量*/
                    oi.setOutincount(-cx.getCheblcount());
                    oi.setProduct(cx.getProduct());
                    oi.setOutindate(new Timestamp(System.currentTimeMillis()));
                    ois.insert(oi);
            }
                a++;
        }
        return a;
    }
    /*
     * @Author xieyukun
     * @Description selectAndproduct
     * @Date 14:45 2020/12/24
     * @param [pageNo, pageSize, cheid, lname, ltiaoma, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Checks>
    */
    @RequestMapping("selectAndproduct")
    public PageInfo<Checks> selectAndproduct(@RequestParam("no") Integer pageNo,
                                 @RequestParam(value = "size",required = false) Integer pageSize,
                                 @RequestParam("cheid")Integer cheid,
                                 @RequestParam("lname")String lname,
                                 @RequestParam("ltiaoma")String ltiaoma,
                                 @RequestParam("date1")String date1,
                                 @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Checks> info = cs.selectAndproduct(pageNo,size, cheid, lname, ltiaoma, date1,  date2);
        System.out.println("info:"+info);
        return info;
    }
    /*
     * @Author xieyukun
     * @Description selectAndchecksxq
     * @Date 15:11 2020/12/24
     * @param [cheid]
     * @return java.util.List<com.demo.pojo.Checks>
    */
    @RequestMapping("selectAndchecksxq")
    public List<Checks> selectAndchecksxq(@RequestParam("cheid") Integer cheid){
        return cs.selectAndchecksxq(cheid);
    }
}
