package com.demo.model.mdao;

import com.demo.pojo.SpCommoditylabel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommoditylabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commoditylabel
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer cllid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commoditylabel
     *
     * @mbg.generated
     */
    int insert(SpCommoditylabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commoditylabel
     *
     * @mbg.generated
     */
    SpCommoditylabel selectByPrimaryKey(Integer cllid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commoditylabel
     *
     * @mbg.generated
     */
    List<SpCommoditylabel> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_commoditylabel
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpCommoditylabel record);
}