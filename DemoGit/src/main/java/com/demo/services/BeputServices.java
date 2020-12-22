package com.demo.services;

import com.demo.model.mdao.BeputMapper;
import com.demo.pojo.Beput;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname BeputServices
 * @Date 2020/12/22 16:35
 */
@Service
public class BeputServices {
    @Autowired
    BeputMapper mapper;
    public PageInfo<Beput> selectAll(Integer pageNo, Integer pageSize,
                String beclass,Integer beid,Integer yewuid,String suname,String date1,String date2){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Beput> list = mapper.selectAll(  beclass, beid, yewuid, suname, date1, date2);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Beput> info= new PageInfo<>(list);
        return info;
    }
}
