package com.demo.config;

import com.demo.pojo.SpCommoditycategory;
import com.demo.pojo.SpCommodityparameter;

import java.util.List;

/**
 * @author: xiahaifeng
 * @description: TODO
 * @Classname SpCommoditycategoryVO
 * @Date 2020/12/24 14:09
 */

public class SpCommodityparameterVO {
    private SpCommodityparameter cpr;
    private List<SpCommodityparameter> cprlist;

    public SpCommodityparameter getCpr() {
        return cpr;
    }

    public void setCpr(SpCommodityparameter cpr) {
        this.cpr = cpr;
    }

    public List<SpCommodityparameter> getCprlist() {
        return cprlist;
    }

    public void setCprlist(List<SpCommodityparameter> cprlist) {
        this.cprlist = cprlist;
    }

    public SpCommodityparameterVO(SpCommodityparameter cpr, List<SpCommodityparameter> cprlist) {
        this.cpr = cpr;
        this.cprlist = cprlist;
    }

    public SpCommodityparameterVO() {
    }
}
