package com.demo.model.jdao;

import com.demo.pojo.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: 周子豪
 * @description: TODO
 * @Classname AddressDAO
 * @Date 2020/12/23 10:06
 */
@Repository
public interface AddressDAO extends CrudRepository<Address,Integer> {
}
