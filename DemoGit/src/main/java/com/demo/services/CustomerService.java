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
    public Customer dengLu(String cname,String password){
        return customerMapper.dengLu(cname,password);
    }
}
