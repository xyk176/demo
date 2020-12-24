package com.demo.controller;

import com.demo.config.SpCommodityparameterVO;
import com.demo.config.SpCommoditypropertyVO;
import com.demo.pojo.*;
import com.demo.services.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    SpPicturesortService pisser;
    @Autowired
    SpPictureService picser;
    @Autowired
    SpCommoditypropertyService cpyser;
    @Autowired
    SpCommodityparameterService cprser;
    @Autowired
    SpCommoditylabelService cllser;


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

    /**
     * @Author xiahaifeng
     * @Description selectall_pic
     * @Date 16:11 2020/12/23
     * @param
     * @return java.util.List<com.demo.pojo.SpPicture>
     * 查询全部图片
    */
    @RequestMapping("/selectall_pic")
    public List<SpPicture> selectall_pic(){
        return picser.selectAll();
    }

    /*
     * @Author xiahaifeng
     * @Description selectall_picspic
     * @Date 16:12 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicturesort>
     * 关联图片查询全部图片分组
    */
    @RequestMapping("/selectall_picspic")
    public List<SpPicturesort> selectall_picspic(){
        return pisser.selectAllByPic();
    }

    /*
     * @Author xiahaifeng
     * @Description com_insert
     * @Date 21:19 2020/12/23
     * @param [com]
     * @return boolean
     * 新增商品
    */
    @RequestMapping("/com_insert")
    public boolean com_insert(@RequestBody SpCommodity com){
        return comser.insert(com);
    }


    /*
     * @Author xiahaifeng
     * @Description selectall_cpy
     * @Date 23:23 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodityproperty>
     * 查询全部商品属性
    */
    @RequestMapping("/selectall_cpy")
    public List<SpCommoditypropertyVO> selectall_cpy(){
        List<SpCommoditypropertyVO> newlist = new ArrayList<>();
        List<SpCommodityproperty> list = cpyser.selectAll();
        for (SpCommodityproperty spCommodityproperty1 : list) {
            if(spCommodityproperty1.getCpytopid()==null){
                newlist.add(new SpCommoditypropertyVO(spCommodityproperty1,null));
            }
        }
        for (SpCommoditypropertyVO spCommodityproperty1 : newlist) {
            List<SpCommodityproperty> shuju = new ArrayList<>();
            for (SpCommodityproperty spCommodityproperty2 : list) {
                if(spCommodityproperty1.getCpy().getCpyid().equals(spCommodityproperty2.getCpytopid())){
                    shuju.add(spCommodityproperty2);
                }
            }
            spCommodityproperty1.setCpylist(shuju);
        }
        return newlist;
    }


    /*
     * @Author xiahaifeng
     * @Description selectall_cpr
     * @Date 14:23 2020/12/24
     * @param []
     * @return java.util.List<com.demo.config.SpCommodityparameterVO>
     * 查询全部商品参数
    */
    @RequestMapping("/selectall_cpr")
    public List<SpCommodityparameterVO> selectall_cpr(){
        List<SpCommodityparameterVO> newlist = new ArrayList<>();
        List<SpCommodityparameter> list = cprser.selectAll();
        for (SpCommodityparameter cpr1 : list) {
            if(cpr1.getCprtopid()==null){
                newlist.add(new SpCommodityparameterVO(cpr1,null));
            }
        }
        for (SpCommodityparameterVO cpr1 : newlist) {
            List<SpCommodityparameter> shuju = new ArrayList<>();
            for (SpCommodityparameter cpr2 : list) {
                if(cpr1.getCpr().getCprid().equals(cpr2.getCprtopid())){
                    shuju.add(cpr2);
                }
            }
            cpr1.setCprlist(shuju);
        }
        return newlist;
    }

    /*
     * @Author xiahaifeng
     * @Description cpy_insert
     * @Date 11:35 2020/12/24
     * @param [com]
     * @return boolean
     * 新增商品属性
    */
    @RequestMapping("/cpy_insert")
    public boolean cpy_insert(@RequestBody List<SpCommodityproperty> cpys){
        return cpyser.insert(cpys);
    }

    /*
     * @Author xiahaifeng
     * @Description cpr_insert
     * @Date 14:35 2020/12/24
     * @param [cprs]
     * @return boolean
     * 新增商品参数
    */
    @RequestMapping("/cpr_insert")
    public boolean cpr_insert(@RequestBody List<SpCommodityparameter> cprs){
        return cprser.insert(cprs);
    }


    /*
     * @Author xiahaifeng
     * @Description selectall_cll
     * @Date 15:46 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 查询全部商品标签
    */
    @RequestMapping("/selectall_cll")
    public List<SpCommoditylabel> selectall_cll(){
        return cllser.selectAll();
    }


    /*
     * @Author xiahaifeng
     * @Description selectall_cll
     * @Date 15:46 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 根据主键修改商品可售状态
     */
    @RequestMapping("/cpr_updateByPrimaryKeyByStus")
    public boolean cpr_updateByPrimaryKeyByStus(@RequestBody SpCommodity com){
        return comser.updateByPrimaryKeyByStus(com);
    }

    /*
     * @Author xiahaifeng
     * @Description selectall_cll
     * @Date 15:46 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 根据主键修改商品可售状态
     */
    @RequestMapping("/cpr_updatecomstus")
    public boolean cpr_updatecomstus(@RequestBody List<SpCommodity> coms){
        boolean isok = true;
        for (SpCommodity com : coms) {
            boolean isno =  comser.updateByPrimaryKeyByStus(com);
            if(!isno){
                isok=false;
            }
        }
        return isok;
    }


    /*
     * @Author xiahaifeng
     * @Description selectallcll_tiaojian
     * @Date 17:44 2020/12/24
     * @param [canshu]
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 带条件的联合商品查询全部标签
    */
    @RequestMapping("/selectallcll_tiaojian")
    public List<SpCommoditylabel> selectallcll_tiaojian(@RequestParam("canshu")String canshu){
        return cllser.selectAllAndCom(canshu);
    }


    /*
     * @Author xiahaifeng
     * @Description cll_insetupdate
     * @Date 17:46 2020/12/24
     * @param [cll]
     * @return boolean
     * 商品标签修改和新增
    */
    @RequestMapping("/cll_insetupdate")
    public boolean cll_insetupdate(@RequestBody SpCommoditylabel cll){
        return cllser.insertupdate(cll);
    }
}

