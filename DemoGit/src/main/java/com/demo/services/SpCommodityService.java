package com.demo.services;

import com.demo.model.mdao.SpCommodityMapper;
import com.demo.model.mdao.SpCommoditytoproMapper;
import com.demo.model.mdao.SpPicturetocomMapper;
import com.demo.pojo.SpCommodity;
import com.demo.pojo.SpCommoditytopro;
import com.demo.pojo.SpPicturetocom;
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
    @Autowired
    SpCommoditytoproMapper promapper;
    @Autowired
    SpPicturetocomMapper picmapper;

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

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 21:18 2020/12/23
     * @param [record]
     * @return boolean
     * 新增商品
    */
    public boolean insert(SpCommodity record){
        try {
            mapper.insert(record);
            for (SpCommoditytopro copr : record.getCoprs()) {
                copr.setCom(record);
                promapper.insert(copr);
            }
            for (SpPicturetocom pic : record.getPics()) {
                pic.setCom(record);
                System.out.println(pic);
                picmapper.insert(pic);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
