package com.demo.model.mdao;

import com.demo.pojo.Inventory;
import com.demo.pojo.SpProduct;
import com.demo.pojo.vo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SpProductMapper {
    List<SpProduct> selectAllBylname(String lname);
    /*
     * @Author xiahaifeng
     * @Description deleteByPrimaryKey
     * @Date 19:30 2020/12/22
     * @param [lid]
     * @return int
     * 根据主键删除
    */
    int deleteByPrimaryKey(Integer lid);

    /*
     * @Author xiahaifeng
     * @Description insert
     * @Date 19:30 2020/12/22
     * @param [record]
     * @return int
     * 新增
    */
    int insert(@Param("p") SpProduct record);

    /*
     * @Author xiahaifeng
     * @Description selectByPrimaryKey
     * @Date 19:30 2020/12/22
     * @param [lid]
     * @return com.demo.pojo.SpProduct
     * 根据主键查询单品
    */
    SpProduct selectByPrimaryKey(Integer lid);


    /**
     查询单品表及其分类，图片
     */
    List<vo> selectAll(@Param("id") Integer id);



    /*
     * @Author xiahaifeng
     * @Description selectAllByPt
     * @Date 19:31 2020/12/22
     * @param [tiaojian, canshu]
     * @return java.util.List<com.demo.pojo.SpCommodity>
     * 带基本条件的查询全部单品
    */
    List<SpProduct> selectAllBuPic(@Param("tiaojian") String tiaojian, @Param("canshu") String canshu);

    /*
     * @Author xiahaifeng
     * @Description updateByPrimaryKey
     * @Date 19:32 2020/12/22
     * @param [record]
     * @return int
     * 修改
    */
    int updateByPrimaryKey(SpProduct record);

    /*新增库存表*/
    void insertkucun(@Param("i") Inventory inventory);

    /*修改单品*/
    void updateproduct(@Param("p") SpProduct product,Integer lid);

}