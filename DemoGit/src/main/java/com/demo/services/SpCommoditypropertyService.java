package com.demo.services;

import com.demo.model.mdao.SpCommoditypropertyMapper;
import com.demo.pojo.SpCommodityproperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommoditypropertyService
 * @Date 2020/12/23 23:05
 */

@Service
public class SpCommoditypropertyService {
    @Autowired
    SpCommoditypropertyMapper mapper;

    public List<SpCommodityproperty> selectAll(){
        return mapper.selectAll();
    }
}
