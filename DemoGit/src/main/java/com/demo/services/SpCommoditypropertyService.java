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

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:31 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodityproperty>
     * 查询全部商品属性
    */
    public List<SpCommodityproperty> selectAll(){
        return mapper.selectAll();
    }

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 14:31 2020/12/24
     * @param [spCommoditypropertys]
     * @return boolean
     * 新增商品属性
    */
    public boolean insert(List<SpCommodityproperty> spCommoditypropertys){
        try {
            SpCommodityproperty fucpy = spCommoditypropertys.get(0);
            mapper.insert(fucpy);
            spCommoditypropertys.remove(0);
            for (SpCommodityproperty spCommodityproperty : spCommoditypropertys) {
                spCommodityproperty.setCpytopid(fucpy.getCpyid());
                mapper.insert(spCommodityproperty);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
