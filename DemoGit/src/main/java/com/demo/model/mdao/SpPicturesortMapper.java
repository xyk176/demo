package com.demo.model.mdao;

import com.demo.pojo.SpPicturesort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpPicturesortMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 15:59 2020/12/23
     * @param [pisid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer pisid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 15:59 2020/12/23
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpPicturesort record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 15:59 2020/12/23
     * @param [pisid]
     * @return com.demo.pojo.SpPicturesort
     * 根据主键查询图片分组
    */
    SpPicturesort selectByPrimaryKey(Integer pisid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 16:00 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicturesort>
     * 查询全部分组
    */
    List<SpPicturesort> selectAll();

    /*
     * @Author xiahaifeng
     * @Description selectAllByPic
     * @Date 16:00 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicturesort>
     * 关联图片查询全部图片分组
    */
    List<SpPicturesort> selectAllByPic();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 16:00 2020/12/23
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpPicturesort record);
}