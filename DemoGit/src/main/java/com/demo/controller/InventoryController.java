package com.demo.controller;

import com.demo.pojo.Inventory;
import com.demo.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname InventoryController
 * @Date 2020/12/21 21:06
 */

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryServices is;
    @RequestMapping("selectAndproductAll")
    public List<Inventory> selectAndproductAll(){
        return is.selectAndproductAll();
    }
}
