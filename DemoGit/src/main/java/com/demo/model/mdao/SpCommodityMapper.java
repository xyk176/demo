package com.demo.model.mdao;

import com.demo.pojo.SpCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommodityMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 9:12 2020/12/22
     * @param [comid]
     * @return int
     * 根据主键id删除
    */
    int deleteByPrimaryKey(Integer comid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 9:11 2020/12/22
     * @param [record]
     * @return int
     * 商品新增
    */
    int insert(SpCommodity record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 9:12 2020/12/22
     * @param [comid]
     * @return com.demo.pojo.SpCommodity
     * 根据主键id查询
    */
    SpCommodity selectByPrimaryKey(Integer comid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 9:12 2020/12/22
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodity>
     * 查询全部商品
    */
    List<SpCommodity> selectAll();

    /*
     * @Author xiahaifeng
     * @Description selectAllByPt
     * @Date 9:15 2020/12/22
     * @param [tiaojian, canshu]
     * @return java.util.List<com.demo.pojo.SpCommodity>
     * 带普通条件查询全部商品
    */
    List<SpCommodity> selectAllByPt(@Param("tiaojian") String tiaojian,@Param("canshu") String canshu);

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 9:12 2020/12/22
     * @param [record]
     * @return int
     * 根据主键修改
    */
    int updateByPrimaryKey(SpCommodity record);
}