package com.demo.model.mdao;

import com.demo.pojo.Cprandcom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CprandcomMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 14:57 2020/12/24
     * @param [cproid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer cproid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 14:58 2020/12/24
     * @param [record]
     * @return int
     * 新增
    */
    int insert(Cprandcom record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 14:58 2020/12/24
     * @param [cproid]
     * @return com.demo.pojo.Cprandcom
     * 根据主键查询
    */
    Cprandcom selectByPrimaryKey(Integer cproid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:58 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.Cprandcom>
     * 查询全部
    */
    List<Cprandcom> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 14:58 2020/12/24
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(Cprandcom record);
}