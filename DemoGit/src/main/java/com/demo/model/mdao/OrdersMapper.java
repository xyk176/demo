package com.demo.model.mdao;

import com.demo.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
@Mapper
public interface OrdersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated
     */
    Orders selectByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *查询所有订单
     * @mbg.generated
     */
    List<Orders> selectAll(@Param("ortype") String ortype, @Param("orsip") String orsip, @Param("pay") String pay);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Orders record);

    /*
    * 查询订单详情商品和图片
    * */
    List<picvo> selectcompic(Integer oId);

    /*根据编号查询订单*/
    ordervo seorder(Integer oId);

    /*根据订单编号修改订单状态*/
    Integer uporder(@Param("or")Orders o);
    /*新增出库单*/
    Output insertoutput(@Param("op")Output output);
    /*新增出库详情*/
    Outputxq insertoutputxq(@Param("opxq")Outputxq outputxq);
    /*修改库存*/
    Integer updateinventory(@Param("in")Inventory inventory);
    /*根据订单编号查询订单详情*/
    List<OrderInfo> selectorderinfo(Integer oId);
    /*根据订单详情编号查询商品*/
    List<SpCommodity> selectspcom(Integer oiId);
    /*根据商品编号查询单品*/
    List<SpProduct> selectproduct(Integer comid);

    /*查询未发货订单*/
    List<Orders> orderstwo( @Param("orsip") String orsip, @Param("pay") String pay);

    void updatekucunjian(int outxqcount, int outxqcount1, Integer inid);
}