package com.demo.services;

import com.demo.model.mdao.SpCommodityMapper;
import com.demo.pojo.SpCommodity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SpCommodityService {
    @Autowired
    SpCommodityMapper mapper;

    /*
     * @Author xiahaifeng
     * @Description selectAllByPt
     * @Date 10:30 2020/12/22
     * @param [tiaojian, canshu, pageNum, pageSize]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.SpCommodity>
     * 带分页的简单条件查询
    */
    public PageInfo<SpCommodity> selectAllByPt(String tiaojian,String canshu,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectAllByPt(tiaojian,canshu));
    }
}
