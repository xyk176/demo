package com.demo.services;

import com.demo.model.mdao.ChecksMapper;
import com.demo.pojo.Checks;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname ChecksServices
 * @Date 2020/12/23 9:11
 */
@Service
public class ChecksServices {
    @Autowired
    ChecksMapper mapper;
    /*
     * @Author xieyukun
     * @Description selectAndproduct
     * @Date 10:10 2020/12/23
     * @param [pageNo, pageSize, cheid, lname, ltiaoma, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Checks>
    */
    public PageInfo<Checks> selectAndproduct(Integer pageNo, Integer pageSize,
                   Integer cheid,String lname,String ltiaoma,String date1, String date2){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Checks> list = mapper.selectAndproduct(  cheid, lname, ltiaoma, date1,  date2);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Checks> info= new PageInfo<>(list);
        return info;
    }
}
