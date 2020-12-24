package com.demo.model.mdao;

import com.demo.pojo.Outputxq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname OutputxqMapper
 * @Date 2020/12/24 10:12
 */

@Mapper
@Repository
public interface OutputxqMapper {
    Integer insert(Outputxq x);
}
