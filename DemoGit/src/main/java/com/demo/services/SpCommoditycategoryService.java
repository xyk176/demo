package com.demo.services;

import com.demo.model.mdao.SpCommoditycategoryMapper;
import com.demo.pojo.SpCommoditycategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommoditycategoryService
 * @Date 2020/12/22 15:34
 */
@Service
public class SpCommoditycategoryService {
    @Autowired
    SpCommoditycategoryMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:08 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditycategory>
     * 查询全部商品类目
    */
    public List<SpCommoditycategory> selectAll(){
        return mapper.selectAll();
    }
}
