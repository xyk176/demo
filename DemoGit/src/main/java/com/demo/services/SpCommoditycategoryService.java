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

    public List<SpCommoditycategory> selectAll(){
        return mapper.selectAll();
    }
}
