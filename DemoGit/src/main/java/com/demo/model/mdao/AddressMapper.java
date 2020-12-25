package com.demo.model.mdao;

import com.demo.pojo.Address;
import com.demo.pojo.OrderInfo;
import com.demo.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    /*
     * @Author xieyukun
     * @Description ceshi
     * @Date 17:02 2020/12/21
     * @param [c]
     * @return java.lang.String
     */
    String ceshi(String c);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer adid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbg.generated
     */
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbg.generated
     */
    Address selectByPrimaryKey(Integer adid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbg.generated
     */
    List<Address> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Address record);

    /*
     * @Author 周子豪
     * @Description 21:28
     * @Date  2020/12/21
     * @param [cid]
     * @return java.util.List<com.demo.pojo.Address>
     * 根据客户id查询收货地址
     */
    List<Address> selectByCidAll(Integer cid);

    /*
     * @Author 周子豪
     * @Description 9:15
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 设置默认地址
     */
    Integer updateAdisdefault(Integer adid);
    Integer updateAdisdefault1(Integer cid);


    /*
     * @Author 周子豪
     * @Description 9:12
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 修改收货地址信息
     */
    Integer updateAddress(@Param("adprovince") String adprovince,@Param("adcity") String adcity,@Param("adarea") String adarea,@Param("addetailed") String addetailed,@Param("adid") Integer adid);

    /*
     * @Author 周子豪
     * @Description 9:13
     * @Date  2020/12/22
     * @param [adid]
     * @return java.lang.Integer
     * 删除收货地址（逻辑删除）
     */
    Integer updateAdisdelete(Integer adid);

    /*
     * @Author 周子豪
     * @Description 11:10
     * @Date  2020/12/23
     * @param [cid]
     * @return java.util.List<com.demo.pojo.Address>
     * 查询已删除的收货地址
     */
    List<Address> selectByCidAll1(Integer cid);

    /*
     * @Author 周子豪
     * @Description 14:01
     * @Date  2020/12/23
     * @param [adid]
     * @return java.lang.Integer
     * 恢复收货地址
     */
    Integer updateAdisdelete1(Integer adid);

    /*
     * @Author 周子豪
     * @Description 15:46
     * @Date  2020/12/23
     * @param [adid]
     * @return java.lang.Integer
     * 删除收货地址（物理删除）
     */
    Integer deleteAddress(Integer adid);

    /*
     * @Author 周子豪
     * @Description 19:21
     * @Date  2020/12/23
     * @param [ortype, cid]
     * @return java.util.List<com.demo.pojo.Orders>
     * 根据客户id查询订单
     */
    List<Orders> selectOrders(String ortype,String orsip,Integer cid);

    /*
     * @Author 周子豪
     * @Description 14:40
     * @Date  2020/12/24
     * @param [oId]
     * @return java.util.List<com.demo.pojo.OrderInfo>
     * 查看订单详情
     */
    List<OrderInfo> selectComxq(Integer oId);
    Orders selectOrderxq(Integer oid);
}