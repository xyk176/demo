package com.demo.services;

import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpProductService
 * @Date 2020-12-21 21:32
 */
@Service
public class SpProductService {
    @Autowired
    SpProductMapper mapper;

    public void insert(SpProduct product) {
        mapper.insert(product);
    }
    // 查询单品表及其分类
    public List<vo> selectall(Integer id){
        return mapper.selectAll(id);
    }

    public PageInfo<SpProduct> selectAll(Integer pageNo, Integer pageSize,
                                     String lname){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<SpProduct> list = mapper.selectAllBylname(lname);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<SpProduct> info= new PageInfo<>(list);
        return info;
    }
}
