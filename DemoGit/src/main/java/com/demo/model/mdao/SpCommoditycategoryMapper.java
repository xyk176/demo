package com.demo.model.mdao;

import com.demo.pojo.SpCommoditycategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommoditycategoryMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 15:31 2020/12/22
     * @param [ccyid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer ccyid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 15:31 2020/12/22
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpCommoditycategory record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 15:31 2020/12/22
     * @param [ccyid]
     * @return com.demo.pojo.SpCommoditycategory
     * 根据主键查询
    */
    SpCommoditycategory selectByPrimaryKey(Integer ccyid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 15:32 2020/12/22
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditycategory>
     * 查询全部
    */
    List<SpCommoditycategory> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 15:32 2020/12/22
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpCommoditycategory record);
}