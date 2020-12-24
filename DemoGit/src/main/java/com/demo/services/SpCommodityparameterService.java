package com.demo.services;

import com.demo.model.mdao.SpCommodityparameterMapper;
import com.demo.pojo.SpCommodityparameter;
import com.demo.pojo.SpCommodityproperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommodityparameterService
 * @Date 2020/12/24 14:11
 */

@Service
public class SpCommodityparameterService {
    @Autowired
    SpCommodityparameterMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:12 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodityparameter>
     * 查询全部商品参数
    */
    public List<SpCommodityparameter> selectAll(){
        return mapper.selectAll();
    }

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 14:33 2020/12/24
     * @param [SpCommodityparameters]
     * @return boolean
     * 新增商品参数
    */
    public boolean insert(List<SpCommodityparameter> SpCommodityparameters){
        try {
            SpCommodityparameter fucpr = SpCommodityparameters.get(0);
            mapper.insert(fucpr);
            SpCommodityparameters.remove(0);
            for (SpCommodityparameter spCommodityparameter : SpCommodityparameters) {
                spCommodityparameter.setCprtopid(fucpr.getCprid());
                mapper.insert(spCommodityparameter);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
