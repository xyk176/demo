package com.demo.model.mdao;

import com.demo.pojo.SpPicturetocom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpPicturetocomMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 21:12 2020/12/23
     * @param [ptcid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer ptcid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 21:12 2020/12/23
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpPicturetocom record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 21:12 2020/12/23
     * @param [ptcid]
     * @return com.demo.pojo.SpPicturetocom
     * 根据主键查询
    */
    SpPicturetocom selectByPrimaryKey(Integer ptcid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 21:12 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpPicturetocom>
     * 查询全部
    */
    List<SpPicturetocom> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 21:12 2020/12/23
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpPicturetocom record);
}