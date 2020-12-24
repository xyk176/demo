package com.demo.model.mdao;

import com.demo.pojo.SpPicture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpPictureMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 16:01 2020/12/23
     * @param [picid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer picid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 16:01 2020/12/23
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpPicture record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 16:01 2020/12/23
     * @param [picid]
     * @return com.demo.pojo.SpPicture
     * 根据主键查询图片
    */
    SpPicture selectByPrimaryKey(Integer picid);

    /*
     * @Author xiahaifeng
     * @Description selectByPisid
     * @Date 17:05 2020/12/23
     * @param [pisid]
     * @return com.demo.pojo.SpPicture
     * 根据图片分组查询图片
    */
    SpPicture selectByPisid(Integer pisid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 16:02 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicture>
     * 查询全部图片
    */
    List<SpPicture> selectAll();


    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 16:02 2020/12/23
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpPicture record);
}