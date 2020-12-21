package com.demo.service;

import com.demo.model.mdao.AddressMapper;
import com.demo.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname AddressService
 * @Date 2020/12/21 21:30
 * 收货地址业务类
 */
@Service
public class AddressService {
    @Autowired
    AddressMapper addressMapper;

    /*
     * @Author 周子豪
     * @Description 21:34
     * @Date  2020/12/21
     * @param [cid]
     * @return java.util.List<com.demo.pojo.Address>
     * 根据客户id查询收货地址
    */
    public List<Address> selectByCidAll(Integer cid){
        return addressMapper.selectByCidAll(cid);
    }

}
