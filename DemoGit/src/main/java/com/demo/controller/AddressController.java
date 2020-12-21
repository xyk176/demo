package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname AddressController
 * @Date 2020/12/21 17:29
 */
@RestController
@RequestMapping("/address")
public class AddressController {
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
}
