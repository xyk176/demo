package com.demo.service;

import com.demo.model.mdao.SpCommodityMapper;
import com.demo.pojo.SpCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpCommodityService {
    @Autowired
    SpCommodityMapper mapper;

    public List<SpCommodity> selectAll(){
        return mapper.selectAll();
    }
}
