package com.demo.model.mdao;

import com.demo.pojo.SpCommodityparameter;
import java.util.List;

public interface SpCommodityparameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodityparameter
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer cprid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodityparameter
     *
     * @mbg.generated
     */
    int insert(SpCommodityparameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodityparameter
     *
     * @mbg.generated
     */
    SpCommodityparameter selectByPrimaryKey(Integer cprid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodityparameter
     *
     * @mbg.generated
     */
    List<SpCommodityparameter> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodityparameter
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpCommodityparameter record);
}