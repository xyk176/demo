package com.demo.config;

import com.demo.pojo.SpCommodityproperty;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommoditypropertyVO
 * @Date 2020/12/23 23:33
 */

public class SpCommoditypropertyVO {
    private SpCommodityproperty cpy;
    private List<SpCommodityproperty> cpylist;

    public SpCommodityproperty getCpy() {
        return cpy;
    }

    public void setCpy(SpCommodityproperty cpy) {
        this.cpy = cpy;
    }

    public List<SpCommodityproperty> getCpylist() {
        return cpylist;
    }

    public void setCpylist(List<SpCommodityproperty> cpylist) {
        this.cpylist = cpylist;
    }

    public SpCommoditypropertyVO(SpCommodityproperty cpy, List<SpCommodityproperty> cpylist) {
        this.cpy = cpy;
        this.cpylist = cpylist;
    }

    public SpCommoditypropertyVO() {
    }
}
