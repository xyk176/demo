package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpProduct;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductServicts
 * @Date 2020-12-21 19:27
 */
@Service
public class SpProductServicts {
    @Autowired
    SpProductMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 19:34 2020/12/22
     * @param [product]
     * @return void
     * 商家动态添加自家的新产品
    */
    public void insert(SpProduct product) {
        mapper.insert(product);
    }

    /*
     * @Author xiahaifeng
     * @Description selectAllByPt
     * @Date 19:37 2020/12/22
     * @param [tiaojian, canshu, pageNum, pageSize]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.SpProduct>
     * 带分页和基本条件的查询全部单品
    */
    public PageInfo<SpProduct> selectAllByPt(String tiaojian, String canshu, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectAllBuPic(tiaojian,canshu));
    }
}
