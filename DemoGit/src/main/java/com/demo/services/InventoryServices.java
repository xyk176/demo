package com.demo.services;

import com.demo.model.mdao.InventoryMapper;
import com.demo.pojo.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname InvertoryServices
 * @Date 2020/12/21 21:02
 */
@Service
public class InventoryServices {
    @Autowired
    InventoryMapper mapper;
    public List<Inventory> selectAndproductAll(){
        return mapper.selectAndproductAll();
    }
}
