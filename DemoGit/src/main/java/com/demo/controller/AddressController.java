package com.demo.controller;

import com.demo.pojo.Address;
import com.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/selectByCidAll")
    public List<Address> selectByCidAll(Integer cid){
        List<Address> list = addressService.selectByCidAll(cid);
        return list;
    }

}
