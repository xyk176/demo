package com.demo.services;

import com.demo.model.mdao.CustomerMapper;
import com.demo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname CustomerService
 * @Date 2020/12/23 21:05
 */
@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    /*
     * @Author 周子豪
     * @Description 21:07
     * @Date  2020/12/23
     * @param [cname, password]
     * @return com.demo.pojo.Customer
     * 登录
    */
    public Customer dengLu(String cname){
        return customerMapper.dengLu(cname);
    }

    /*
     * @Author 周子豪
     * @Description 11:07
     * @Date  2020/12/24
     * @param [cid]
     * @return com.demo.pojo.Customer
     * 根据客户id查询
    */
    public Customer selectByCid(Integer cid){
        return customerMapper.selectByCid(cid);
    }

    /*
     * @Author 周子豪
     * @Description 17:22
     * @Date  2020/12/24
     * @param [cname, password, cphone, cid]
     * @return java.lang.Integer
     * 修改个人信息
    */
    public Integer updateCustomer(String cname,String password,String cphone,Integer cid){
        return customerMapper.updateCustomer(cname,password,cphone,cid);
    }
}
