package com.demo.services;

import com.demo.model.mdao.SpPicturetoproMapper;
import com.demo.model.mdao.SpProductMapper;
import com.demo.pojo.SpPicturetopro;
import com.demo.pojo.SpProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpPicturetoproServices
 * @Date 2020-12-24 14:24
 */
@Service
public class SpPicturetoproServices {
    @Autowired
    SpPicturetoproMapper mapper;
    @Autowired
    SpProductMapper pmapper;

    public void insert(SpProduct record){

        pmapper.insert(record);
        System.out.println("aaaaaaa"+record.getPicturetopro().get(0).getPtpiszhu());
        SpProduct p=pmapper.selectMaxId();
        for (SpPicturetopro d : record.getPicturetopro()){
            SpPicturetopro pro=new SpPicturetopro(null,d.getPtpiszhu(),p,d.getPicture());
            mapper.insertInfo(pro);
        }



    }

}
