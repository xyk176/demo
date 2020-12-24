package com.demo.model.mdao;

import com.demo.pojo.SpCommoditytopro;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpCommoditytoproMapper {
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 21:11 2020/12/23
     * @param [ctpid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer ctpid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 21:11 2020/12/23
     * @param [record]
     * @return int
     * 新增
    */
    int insert(SpCommoditytopro record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 21:11 2020/12/23
     * @param [ctpid]
     * @return com.demo.pojo.SpCommoditytopro
     * 根据主键查询
    */
    SpCommoditytopro selectByPrimaryKey(Integer ctpid);

    /*
     * @Author xiahaifeng
     * @Description selectAll
     * @Date 21:11 2020/12/23
     * @param []
     * @return java.util.List<com.demo.pojo.SpCommoditytopro>
     * 查询全部
    */
    List<SpCommoditytopro> selectAll();

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 21:11 2020/12/23
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpCommoditytopro record);
}