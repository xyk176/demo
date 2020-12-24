package com.demo.model.mdao;

import com.demo.pojo.SpCommoditylabel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommoditylabelMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 15:19 2020/12/24
     * @param [cllid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer cllid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 15:20 2020/12/24
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpCommoditylabel record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 15:20 2020/12/24
     * @param [cllid]
     * @return com.demo.pojo.SpCommoditylabel
     * 根据主键查询
    */
    SpCommoditylabel selectByPrimaryKey(Integer cllid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 15:20 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 查询全部
    */
    List<SpCommoditylabel> selectAll();

    /*
     * @Author xiahaifeng
     * @Description selectAllAndCom
     * @Date 17:16 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditylabel>
     * 带条件的联合商品查询全部标签
    */
    List<SpCommoditylabel> selectAllAndCom(String canshu);

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 15:20 2020/12/24
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpCommoditylabel record);
}