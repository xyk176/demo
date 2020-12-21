package com.demo.model.mdao;

import com.demo.pojo.SpPicture;
import java.util.List;

public interface SpPictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picture
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer picid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picture
     *
     * @mbg.generated
     */
    int insert(SpPicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picture
     *
     * @mbg.generated
     */
    SpPicture selectByPrimaryKey(Integer picid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picture
     *
     * @mbg.generated
     */
    List<SpPicture> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_picture
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpPicture record);
}