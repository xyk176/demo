package com.demo.model.mdao;

import com.demo.pojo.Beput;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BeputMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table beput
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer beid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table beput
     *
     * @mbg.generated
     */
    int insert(Beput record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table beput
     *
     * @mbg.generated
     */
    Beput selectByPrimaryKey(Integer beid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table beput
     *
     * @mbg.generated
     */
    List<Beput> selectAll(String beclass,Integer beid,Integer yewuid,String suname,String date1,String date2);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table beput
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Beput record);
}