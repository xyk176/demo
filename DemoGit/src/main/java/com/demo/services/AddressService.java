package com.demo.services;

import com.demo.model.jdao.AddressDAO;
import com.demo.model.mdao.AddressMapper;
import com.demo.model.mdao.CustomerMapper;
import com.demo.pojo.Address;
import com.demo.pojo.Customer;
import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    AddressDAO addressDAO;
    @Autowired
    CustomerMapper customerMapper;

    /*
     * @Author 周子豪
     * @Description 21:34
     * @Date  2020/12/21
     * @param [no, size, cid]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Address>
     */
    public PageInfo<Address> selectByCidAll(Integer no,Integer size,Integer cid){
        PageHelper.startPage(no,size);
        List<Address> list=addressMapper.selectByCidAll(cid);
        PageInfo<Address> info = new PageInfo<>(list);
        return info;
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

    /*
     * @Author 周子豪
     * @Description 9:44
     * @Date  2020/12/23
     * @param [address]
     * @return java.lang.Integer
     * 新增收货地址
     */
    public Integer insertAddress(Address address,Integer cid){
        try {
            Customer customer = customerMapper.selectByCid(cid);
            address.setCustomer(customer);
            address.setAdisdelete("否");
            address.setAdisdefault("否");
            addressDAO.save(address);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author 周子豪
     * @Description 11:11
     * @Date  2020/12/23
     * @param [no, size, cid]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Address>
     */
    public PageInfo<Address> selectByCidAll1(Integer no,Integer size,Integer cid){
        PageHelper.startPage(no,size);
        List<Address> list = addressMapper.selectByCidAll1(cid);
        PageInfo<Address> info = new PageInfo<>(list);
        return info;
    }

    /*
     * @Author 周子豪
     * @Description 14:02
     * @Date  2020/12/23
     * @param [adid]
     * @return java.lang.Integer
     * 恢复收货地址
     */
    public Integer updateAdisdelete1(Integer adid){
        return addressMapper.updateAdisdelete1(adid);
    }

    /*
     * @Author 周子豪
     * @Description 15:48
     * @Date  2020/12/23
     * @param [adid]
     * @return java.lang.Integer
     * 删除收货地址（物理删除）
     */
    public Integer deleteAddress(Integer adid){
        return addressMapper.deleteAddress(adid);
    }

    /*
     * @Author 周子豪
     * @Description 19:24
     * @Date  2020/12/23
     * @param [ortype, orsip, cid, no, size]
     * @return com.github.pagehelper.PageInfo<com.demo.pojo.Orders>
     * 根据客户id查询订单
     */
    public PageInfo<Orders> selectOrders(String ortype,String orsip,Integer cid,Integer no,Integer size){
        PageHelper.startPage(no,size);
        List<Orders> list = addressMapper.selectOrders(ortype,orsip,cid);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /*
     * @Author 周子豪
     * @Description 14:41
     * @Date  2020/12/24
     * @param [oId]
     * @return java.util.List<com.demo.pojo.OrderInfo>
     * 查看订单详情
     */
    public List<OrderInfo> selectComxq(Integer oId){
        List<OrderInfo> list = addressMapper.selectComxq(oId);
        return list;
    }

    /*
     * @Author 周子豪
     * @Description 16:22
     * @Date  2020/12/24
     * @param [oid]
     * @return com.demo.pojo.Orders
     * 查看订单详细信息
     */
    public Orders selectOrderxq(Integer oid){
        Orders orders = addressMapper.selectOrderxq(oid);
        return orders;
    }
}
