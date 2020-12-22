package com.demo.controller;

import com.demo.pojo.Outandinput;
import com.demo.services.OutandinputServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname OutandinputController
 * @Date 2020/12/22 10:42
 */

@RestController
@RequestMapping("/outandinput")
public class OutandinputController {
    @Autowired
    OutandinputServices os;
    /*
     * @Author xieyukun
     * @Description page
     * @Date 16:16 2020/12/22
     * @param [pageNo, pageSize, lname, ltiaoma, yewuid, outinid, outinclass, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Outandinput>
    */
    @RequestMapping("selectAll")
    public PageInfo<Outandinput> page(@RequestParam("no") Integer pageNo,
                                      @RequestParam(value = "size",required = false) Integer pageSize,
                                      @RequestParam("lname")String lname,
                                      @RequestParam("ltiaoma")String ltiaoma,
                                      @RequestParam("yewuid")Integer yewuid,
                                      @RequestParam("outinid")Integer outinid,
                                      @RequestParam("outinclass")String outinclass,
                                      @RequestParam("date1")String date1,
                                      @RequestParam("date2")String date2){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Outandinput> info = os.selectAll(pageNo,size,lname, ltiaoma, yewuid, outinid, outinclass, date1, date2);
        System.out.println("info:"+info);
        return info;
    }
}
