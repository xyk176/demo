package com.demo.services;

import com.demo.model.mdao.OutputMapper;
import com.demo.pojo.Output;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname OutputServices
 * @Date 2020/12/22 20:14
 */
@Service
public class OutputServices {
    @Autowired
    OutputMapper mapper;
    public PageInfo<Output> selectAll(Integer pageNo, Integer pageSize,
                              String outclass,Integer outid,Integer yewuid,String date1,String date2){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Output> list = mapper.selectAll(  outclass, outid, yewuid, date1, date2);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Output> info= new PageInfo<>(list);
        return info;
    }
}
