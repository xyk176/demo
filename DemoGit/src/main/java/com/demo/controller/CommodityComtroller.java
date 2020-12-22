package com.demo.controller;

import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpCommoditycategory;
import com.demo.pojo.SpPicture;
import com.demo.pojo.SpProduct;
import com.demo.services.SpCommodityService;
import com.demo.services.SpCommoditycategoryService;
import com.demo.services.SpProductServicts;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/commoditycomtroller")
public class CommodityComtroller {
    @Autowired
    SpCommodityService comser;
    @Autowired
    SpCommoditycategoryService ccyser;
    @Autowired
    SpProductServicts proser;

    /*
     * @Author xiahaifeng
     * @Description selectall_pttiaojian
     * @Date 10:29 2020/12/22
     * @param [tiaojian, canshu, pageNum, pageSize]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.SpCommodity>
     * 带分页的简单条件查询全部商品
    */
    @RequestMapping("/selectall_pttiaojian")
    public PageInfo<SpCommodity> selectall_pttiaojian(@RequestParam("tiaojian")String tiaojian, @RequestParam("canshu")String canshu, @RequestParam("current")Integer pageNum, @RequestParam("size")Integer pageSize){
        PageInfo<SpCommodity> pageInfo= comser.selectAllByPt(tiaojian,canshu,pageNum,pageSize);
        return pageInfo;
    }

    /*
     * @Author xiahaifeng
     * @Description selectall_shangpinleimu
     * @Date 15:37 2020/12/22
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditycategory>
     * 查询全部商品类目
    */
    @RequestMapping("/selectall_shangpinleimu")
    public List<SpCommoditycategory> selectall_shangpinleimu(){
        return ccyser.selectAll();
    }


    /*
     * @Author xiahaifeng
     * @Description selectallpro_pttiaojian
     * @Date 19:39 2020/12/22
     * @param [tiaojian, canshu, pageNum, pageSize]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.SpProduct>
     * 带分页和基本条件的查询全部单品
    */
    @RequestMapping("/selectallpro_pttiaojian")
    public PageInfo<SpProduct> selectallpro_pttiaojian(@RequestParam("tiaojian")String tiaojian, @RequestParam("canshu")String canshu, @RequestParam("current")Integer pageNum, @RequestParam("size")Integer pageSize){
        PageInfo<SpProduct> pageInfo= proser.selectAllByPt(tiaojian,canshu,pageNum,pageSize);
        return pageInfo;
    }
    
}
