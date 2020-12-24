package com.demo.services;

import com.demo.model.mdao.OutandinputMapper;
import com.demo.pojo.Inventory;
import com.demo.pojo.Outandinput;
import com.demo.pojo.Output;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname OutandinputServices
 * @Date 2020/12/22 10:37
 */
@Service
public class OutandinputServices {
    @Autowired
    OutandinputMapper mapper;
    public Integer insert(Outandinput o){
        return mapper.insert(o);
    }
    /*
     * @Author xieyukun
     * @Description selectAll
     * @Date 15:25 2020/12/22
     * @param [pageNo, pageSize, lname, ltiaoma, yewuid, outinid, outinclass, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Outandinput>
    */
    public PageInfo<Outandinput> selectAll(Integer pageNo, Integer pageSize,
                      String lname,String ltiaoma,Integer yewuid,Integer outinid,String outinclass,String date1,String date2){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Outandinput> list = mapper.selectAll(  lname, ltiaoma, yewuid, outinid, outinclass, date1, date2);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Outandinput> info= new PageInfo<>(list);
        return info;
    }
}
