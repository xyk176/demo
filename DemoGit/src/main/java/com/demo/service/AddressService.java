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

    /*
     * @Author 周子豪
     * @Description 9:21
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 设置默认地址
    */
    public Integer updateAdisdefault(Integer adid){
        return addressMapper.updateAdisdefault(adid);
    }
    public Integer updateAdisdefault1(Integer cid){
        return addressMapper.updateAdisdefault1(cid);
    }


    /*
     * @Author 周子豪
     * @Description 9:25
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 修改收货地址信息
    */
    public Integer updateAddress(String adprovince,String adcity,String adarea,String addetailed,Integer adid){
        return addressMapper.updateAddress(adprovince,adcity,adarea,addetailed,adid);
    }

    /*
     * @Author 周子豪
     * @Description 9:30
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 删除收货地址（逻辑删除）
    */
    public Integer updateAdisdelete(Integer adid){
        return addressMapper.updateAdisdelete(adid);
    }
}
