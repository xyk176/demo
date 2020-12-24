package com.demo.model.mdao;

import com.demo.pojo.SpCommodityproperty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommoditypropertyMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 23:04 2020/12/23
     * @param [cpyid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer cpyid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 23:04 2020/12/23
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpCommodityproperty record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 23:04 2020/12/23
     * @param [cpyid]
     * @return com.demo.pojo.SpCommodityproperty
     * 根据主键查询
    */
    SpCommodityproperty selectByPrimaryKey(Integer cpyid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 23:04 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommodityproperty>
     * 查询全部
    */
    List<SpCommodityproperty> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 23:04 2020/12/23
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpCommodityproperty record);
}