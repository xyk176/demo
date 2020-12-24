package com.demo.controller;

import com.demo.pojo.Beput;
import com.demo.pojo.Beputxq;
import com.demo.pojo.Outandinput;
import com.demo.services.BeputServices;
import com.demo.services.InventoryServices;
import com.demo.services.OutandinputServices;
import com.github.pagehelper.PageInfo;
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
 * @Classname BeputController
 * @Date 2020/12/22 16:38
 */

@RestController
@RequestMapping("/beput")
public class BeputController {
    @Autowired
    BeputServices bs;
    @Autowired
    InventoryServices is;
    @Autowired
    OutandinputServices os;
    /*
     * @Author xieyukun
     * @Description page
     * @Date 9:15 2020/12/23
     * @param [pageNo, pageSize, beclass, beid, yewuid, suname, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Beput>
    */
    @RequestMapping("selectAll")
    public PageInfo<Beput> page(@RequestParam("no") Integer pageNo,
                              @RequestParam(value = "size",required = false) Integer pageSize,
                              @RequestParam("beclass")String beclass,
                              @RequestParam("beid")Integer beid,
                              @RequestParam("yewuid")Integer yewuid,
                              @RequestParam("suname")String suname,
                              @RequestParam("date1")String date1,
                              @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Beput> info = bs.selectAll(pageNo,size, beclass, beid, yewuid, suname, date1, date2);
        System.out.println("info:"+info);
        return info;
    }
    /*
     * @Author xieyukun
     * @Description selectbeputxq
     * @Date 14:55 2020/12/23
     * @param [beid]
     * @return java.util.List<com.demo.pojo.Beput>
    */
    @RequestMapping("selectbeputxq")
    public List<Beput> selectbeputxq(Integer beid){
        return bs.selectbeputxq(beid);
    }
    /*
     * @Author xieyukun
     * @Description insert 单品入库
     * @Date 15:29 2020/12/23
     * @param [b]
     * @return java.lang.Integer
    */
    @RequestMapping("insert")
    public Integer insert(@RequestBody Beput b){
         //新增入库单
         b.setBedate(new Timestamp(System.currentTimeMillis()));
         Beput bid= bs.insert(b);
         System.out.println(b);
         int a=0;
         for (Beputxq bexq : b.getBeputxqs()) {
            bexq.setBeput(bid);
            bexq.setLibecount(bexq.getLibecount());
            //新增入库详情
            bs.insertxq(bexq);
            is.update(bexq.getLibecount(),bexq.getLibecount(),bexq.getProduct().getLid());
             Outandinput o=new Outandinput();
             o.setOutinclass(b.getBeclass());
             o.setOutincount(bexq.getLibecount());
             o.setProduct(bexq.getProduct());
             o.setOutindate(new Timestamp(System.currentTimeMillis()));
             os.insert(o);
            a++;
         }
        return a;
    }
}
