package com.demo.services;

import com.demo.model.mdao.SpProductsortMapper;
import com.demo.pojo.SpProductsort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductServices
 * @Date 2020-12-22 10:45
 */
@Service
public class SpProductsortServices {
    @Autowired
    SpProductsortMapper ps;

    public List<SpProductsort> selectFu(){
        return ps.selectFu();
    }

    public List<SpProductsort> selectByid(Integer id){
        return ps.selectByid(id);
    }

    public void insert(SpProductsort r){
        ps.insert(r);
    }
}
