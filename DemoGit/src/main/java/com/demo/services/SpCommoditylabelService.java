package com.demo.services;

import com.demo.model.jdao.SpCommoditylabelDAO;
import com.demo.model.mdao.SpCommoditylabelMapper;
import com.demo.pojo.SpCommoditylabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommoditylabelService
 * @Date 2020/12/24 15:26
 */

@Service
public class SpCommoditylabelService {
    @Autowired
    SpCommoditylabelMapper mapper;
    @Autowired
    SpCommoditylabelDAO dao;

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 15:27 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 查询全部商品标签
    */
    public List<SpCommoditylabel> selectAll(){
        return mapper.selectAll();
    }

    /*
     * @Author xiahaifeng
     * @Description selectAllAndCom
     * @Date 17:20 2020/12/24
     * @param [canshu]
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 带条件的联合商品查询全部标签
    */
    public List<SpCommoditylabel> selectAllAndCom(String canshu){
        return mapper.selectAllAndCom(canshu);
    }


    /*
     * @Author xiahaifeng
     * @Description insertupdate
     * @Date 17:44 2020/12/24
     * @param [spCommoditylabel]
     * @return boolean
     * 商品标签修改和新增
    */
    public boolean insertupdate(SpCommoditylabel spCommoditylabel){
        try {
            dao.save(spCommoditylabel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
