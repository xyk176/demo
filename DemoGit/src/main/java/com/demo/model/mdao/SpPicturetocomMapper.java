package com.demo.model.mdao;

import com.demo.pojo.SpPicturetocom;
import java.util.List;

public interface SpPicturetocomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picturetocom
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer ptcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picturetocom
     *
     * @mbg.generated
     */
    int insert(SpPicturetocom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picturetocom
     *
     * @mbg.generated
     */
    SpPicturetocom selectByPrimaryKey(Integer ptcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picturetocom
     *
     * @mbg.generated
     */
    List<SpPicturetocom> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picturetocom
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpPicturetocom record);
}