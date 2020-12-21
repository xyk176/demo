package com.demo.services;/**
 * com.demo.services
 *
 * @Date 2020-12-21 17:30
 * @Version 1.0
 */

import com.demo.model.mdao.ShoppingMapper;
import com.demo.pojo.SpCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ZhangWang
 * @description: TODO
 * @Classname ShoppingService
 * @Date 2020-12-21 17:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingService {
    @Autowired
    ShoppingMapper smapper;

    //查询所有商品分类
    public List<SpCommodity> s_GoodsType(){
        return smapper.s_GoodsType();
    }


}
