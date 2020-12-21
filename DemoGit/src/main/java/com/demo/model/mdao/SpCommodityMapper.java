package com.demo.model.mdao;

import com.demo.pojo.SpCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommodityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodity
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer comid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodity
     *
     * @mbg.generated
     */
    int insert(SpCommodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodity
     *
     * @mbg.generated
     */
    SpCommodity selectByPrimaryKey(Integer comid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodity
     *
     * @mbg.generated
     */
    List<SpCommodity> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commodity
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpCommodity record);
}