package com.demo.controller;

import com.demo.pojo.Outandinput;
import com.demo.pojo.Output;
import com.demo.pojo.Outputxq;
import com.demo.services.InventoryServices;
import com.demo.services.OutandinputServices;
import com.demo.services.OutputServices;
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
 * @Classname OutputController
 * @Date 2020/12/22 20:18
 */
@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputServices os;
    @Autowired
    InventoryServices is;
    @Autowired
    OutandinputServices ois;
    @RequestMapping("insert")
    public Integer insert(@RequestBody Output o){
        o.setOutdate(new Timestamp(System.currentTimeMillis()));
        /*新增出库单*/
        Output output= os.insertoutput(o);
        int a=0;
        for (Outputxq oxq : o.getOutputxqs()) {
            /*新增出库详情*/
            oxq.setOutput(output);
            os.insertoutputxq(oxq);
            is.updatekucunjian(oxq.getOutxqcount(),oxq.getOutxqcount(),oxq.getSproduct().getInventorys().get(0).getInid());
            Outandinput oi=new Outandinput();
            oi.setOutinclass(o.getOutclass());
            oi.setOutincount(oxq.getOutxqcount());
            oi.setProduct(oxq.getSproduct());
            oi.setOutindate(new Timestamp(System.currentTimeMillis()));
            ois.insert(oi);
            a++;
        }
        return a;
    }
    /*
     * @Author xieyukun
     * @Description page
     * @Date 9:15 2020/12/23
     * @param [pageNo, pageSize, outclass, outid, yewuid, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Output>
    */
    @RequestMapping("selectAll")
    public PageInfo<Output> page(@RequestParam("no") Integer pageNo,
                                 @RequestParam(value = "size",required = false) Integer pageSize,
                                 @RequestParam("outclass")String outclass,
                                 @RequestParam("outid")Integer outid,
                                 @RequestParam("yewuid")Integer yewuid,
                                 @RequestParam("date1")String date1,
                                 @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Output> info = os.selectAll(pageNo,size,  outclass, outid, yewuid, date1, date2);
        System.out.println("info:"+info);
        return info;
    }
    /*
     * @Author xieyukun
     * @Description selectoutxq
     * @Date 10:23 2020/12/24
     * @param [outid]
     * @return java.util.List<com.demo.pojo.Output>
    */
    @RequestMapping("selectoutxq")
    public List<Output> selectoutxq(Integer outid){
        return os.selectoutxq(outid);
    }
}
