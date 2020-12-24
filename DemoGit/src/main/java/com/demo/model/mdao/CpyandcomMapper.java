package com.demo.model.mdao;

import com.demo.pojo.Cpyandcom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CpyandcomMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 14:58 2020/12/24
     * @param [cpcoid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer cpcoid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 14:59 2020/12/24
     * @param [record]
     * @return int
     * 新增
    */
    int insert(Cpyandcom record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 14:59 2020/12/24
     * @param [cpcoid]
     * @return com.demo.pojo.Cpyandcom
     * 根据主键查询
    */
    Cpyandcom selectByPrimaryKey(Integer cpcoid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 14:59 2020/12/24
     * @param []
     * @return java.util.List<com.demo.pojo.Cpyandcom>
     * 查询全部
    */
    List<Cpyandcom> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 14:59 2020/12/24
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(Cpyandcom record);
}