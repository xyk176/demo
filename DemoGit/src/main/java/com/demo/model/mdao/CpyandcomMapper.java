package com.demo.model.mdao;

import com.demo.pojo.Cpyandcom;
import java.util.List;

public interface CpyandcomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cpyandcom
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer cpcoid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cpyandcom
     *
     * @mbg.generated
     */
    int insert(Cpyandcom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cpyandcom
     *
     * @mbg.generated
     */
    Cpyandcom selectByPrimaryKey(Integer cpcoid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cpyandcom
     *
     * @mbg.generated
     */
    List<Cpyandcom> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cpyandcom
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Cpyandcom record);
}