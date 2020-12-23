package com.demo.services;

import com.demo.model.mdao.SupplierMapper;
import com.demo.pojo.Supplier;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname SupplierServices
 * @Date 2020/12/23 10:10
 */
@Service
public class SupplierServices {
    @Autowired
    SupplierMapper mapper;
    /*
     * @Author xieyukun
     * @Description selectAll
     * @Date 10:15 2020/12/23
     * @param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Supplier>
    */
    public PageInfo<Supplier> selectAll(Integer pageNo, Integer pageSize,
            String suname,String sulxr,String sulxrphone,Integer suid){
        System.out.println("进入分页查询：当前页码："+pageNo);
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Supplier> list = mapper.selectAll( suname, sulxr, sulxrphone, suid);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Supplier> info= new PageInfo<>(list);
        return info;
    }
    /*
     * @Author xieyukun
     * @Description selectNewBeput
     * @Date 19:38 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.Supplier>
    */
    public List<Supplier> selectNewBeput(){
        return mapper.selectNewBeput();
    }
    public Integer insert(Supplier s){
        return mapper.insert(s);
    }
}
