package com.demo.model.mdao;

import com.demo.pojo.SpCommodityparameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommodityparameterMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 14:06 2020/12/24
     * @param [cprid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer cprid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 14:06 2020/12/24
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpCommodityparameter record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 14:06 2020/12/24
     * @param [cprid]
     * @return com.demo.pojo.SpCommodityparameter
     * 根据主键查询
    */
    SpCommodityparameter selectByPrimaryKey(Integer cprid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:06 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodityparameter>
     * 查询全部
    */
    List<SpCommodityparameter> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 14:07 2020/12/24
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpCommodityparameter record);
}