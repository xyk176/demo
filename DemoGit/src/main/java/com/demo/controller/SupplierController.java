package com.demo.controller;

import com.demo.pojo.Supplier;
import com.demo.services.SupplierServices;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname SupplierController
 * @Date 2020/12/23 10:12
 */

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierServices ss;
    /*
     * @Author xieyukun
     * @Description selectAll
     * @Date 14:55 2020/12/23
     * @param [pageNo, pageSize, suname, sulxr, sulxrphone, suid]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Supplier>
    */
    @RequestMapping("selectAll")
    public PageInfo<Supplier> selectAll(@RequestParam("no") Integer pageNo,
                                               @RequestParam(value = "size",required = false) Integer pageSize,
                                               @RequestParam("suname")String suname,
                                               @RequestParam("sulxr")String sulxr,
                                               @RequestParam("sulxrphone")String sulxrphone,
                                               @RequestParam("suid")Integer suid){
        Integer size = 1;
        if(pageSize!=null){
            size = pageSize;
        }
        PageInfo<Supplier> info = ss.selectAll(pageNo,size, suname, sulxr, sulxrphone, suid);
        System.out.println("info:"+info);
        return info;
    }
    @RequestMapping("selectNewBeput")
    public List<Supplier> selectNewBeput(){
        return ss.selectNewBeput();
    }

    @RequestMapping("insert")
    public Integer insert(@RequestBody Supplier s){
        System.out.println(s);
        return ss.insert(s);
    }
}
