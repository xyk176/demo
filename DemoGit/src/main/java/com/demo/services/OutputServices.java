package com.demo.services;

import com.demo.model.mdao.OutputMapper;
import com.demo.model.mdao.OutputxqMapper;
import com.demo.pojo.Output;
import com.demo.pojo.Outputxq;
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
    @Autowired
    OutputxqMapper xqmapper;
    /*
     * @Author xieyukun
     * @Description insertoutput
     * @Date 10:15 2020/12/24
     * @param [o]
     * @return java.lang.Integer
    */
    public Output insertoutput(Output o){
         mapper.insert(o);
         return o;
    }
    /*
     * @Author xieyukun
     * @Description insertoutputxq
     * @Date 10:15 2020/12/24
     * @param [oxq]
     * @return java.lang.Integer
    */
    public Integer insertoutputxq(Outputxq oxq){
        return xqmapper.insert(oxq);
    }
    /*
     * @Author xieyukun
     * @Description selectAll
     * @Date 10:15 2020/12/24
     * @param [pageNo, pageSize, outclass, outid, yewuid, date1, date2]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Output>
    */
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
    /*
     * @Author xieyukun
     * @Description selectoutxq
     * @Date 10:15 2020/12/24
     * @param [output]
     * @return java.util.List<com.demo.pojo.Output>
    */
    public List<Output> selectoutxq(Integer output){
        return mapper.selectoutxq(output);
    }
}
