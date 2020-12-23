package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.Inventory;
import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
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
        try {
            mapper.insert(product);
            System.out.println("services"+product);
            /*新增库存*/
            Inventory i=new Inventory();
            i.setProduct(product);
            i.setInentity(0);
            i.setInoccupy(0);
            i.setInusable(0);
            i.setMaxcount(0);
            mapper.insertkucun(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
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


    // 查询单品表及其分类
    public PageInfo<vo> selectall(Integer id, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectAll(id));
    }

    /*修改单品*/
    public void updateproduct(SpProduct product,Integer lid){
        mapper.updateproduct(product,lid);
    }
}
