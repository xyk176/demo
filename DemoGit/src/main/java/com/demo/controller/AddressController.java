package com.demo.controller;

import com.demo.config.MyResult;
import com.demo.pojo.Address;
import com.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname AddressController
 * @Date 2020/12/21 17:29
 */
@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    /*
     * @Author 周子豪
     * @Description 17:30
     * @Date  2020/12/21
     * @param []
     * @return java.lang.String
    */
    @RequestMapping("/demo")
    public String demo(){
        return "zzh";
    }

    /*
     * @Author 周子豪
     * @Description 16:28
     * @Date  2020/12/22
     * @param [cid]
     * @return com.demo.config.MyResult
     * 根据客户id查询收货地址
    */
    @RequestMapping("/selectByCidAll")
    public MyResult selectByCidAll(Integer cid){
        List<Address> list = addressService.selectByCidAll(cid);
        return MyResult.returnObjs(list);
    }

    /*
     * @Author 周子豪
     * @Description 9:53
     * @Date  2020/12/22
     * @param [adid]
     * @return com.demo.config.MyResult
     * 设置默认地址
    */
    @RequestMapping("/updateAdisdefault")
    public MyResult updateAdisdefault(Integer adid,Integer cid){
        int a = addressService.updateAdisdefault1(cid);
        int i = addressService.updateAdisdefault(adid);
        if(i>0){
            return MyResult.ERROR("已设置为默认地址！");
        }else {
            return MyResult.ERROR("设置失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 9:56
     * @Date  2020/12/22
     * @param [adprovince, adcity, adarea, addetailed, adid]
     * @return com.demo.config.MyResult
     * 修改收货地址信息
    */
    @RequestMapping("/updateAddress")
    public MyResult updateAddress(String adprovince,String adcity,String adarea,String addetailed,Integer adid){
        int i = addressService.updateAddress(adprovince,adcity,adarea,addetailed,adid);
        if(i>0){
            return MyResult.ERROR("修改成功！");
        }else {
            return MyResult.ERROR("修改失败！");
        }
    }

    /*
     * @Author 周子豪
     * @Description 9:58
     * @Date  2020/12/22
     * @param [adid]
     * @return com.demo.config.MyResult
     * 删除收货地址（逻辑删除）
    */
    @RequestMapping("/updateAdisdelete")
    public MyResult updateAdisdelete(Integer adid){
        int i = addressService.updateAdisdelete(adid);
        if(i>0){
            return MyResult.SUCCESS;
        }else {
            return MyResult.ERROR("删除失败！");
        }
    }
}
