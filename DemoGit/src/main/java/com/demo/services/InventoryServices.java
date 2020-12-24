package com.demo.services;

import com.demo.model.mdao.InventoryMapper;
import com.demo.pojo.Inventory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname InvertoryServices
 * @Date 2020/12/21 21:02
 */
@Service
public class InventoryServices {
    @Autowired
    InventoryMapper mapper;
    /*
     * @Author xieyukun
     * @Description updateinentity
     * @Date 15:45 2020/12/24
     * @param [inentity, inusable, lid]
     * 库存盘点重置单品库存
     * @return java.lang.Integer
    */
    public Integer updateinentity(Integer inentity,Integer inusable ,Integer lid){
        return mapper.updateinentity( inentity, inusable , lid);
    }

    /*
     * @Author xieyukun
     * @Description updatekucunjian
     * @Date 10:21 2020/12/24
     * @param [inentity, inusable, lid]
     * @return java.lang.Integer
     * 减库存
    */
    public Integer updatekucunjian(Integer inentity,Integer inusable ,Integer lid){
        return mapper.updatekucunjian( inentity, inusable , lid);
    }
    /*
     * @Author xieyukun
     * @Description updatemaxcount
     * @Date 10:21 2020/12/24
     * @param [maxcount, inid]
     * @return java.lang.Integer
    */
    public Integer updatemaxcount(Integer maxcount,Integer inid){
        return mapper.updatemaxcount(maxcount,inid);
    }
    /*
     * 单品入库加库存
     * @Author xieyukun
     * @Description update
     * @Date 15:27 2020/12/23
     * @param [inentity, inusable, inid]
     * @return java.lang.Integer
    */
    public Integer update(Integer inentity,Integer inusable ,Integer lid){
        return mapper.updatekucun( inentity, inusable , lid);
    }
    /*
     * @Author xieyukun
     * @Description selectAndproductAll
     * @Date 16:37 2020/12/22
     * @param [pageNo, pageSize, lname, ltiaoma]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Inventory>
    */
    public PageInfo<Inventory> selectAndproductAll(Integer pageNo, Integer pageSize,
                                                   String lname,String ltiaoma){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Inventory> list = mapper.selectAndproductAll( lname, ltiaoma);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Inventory> info= new PageInfo<>(list);
        return info;
    }
}
