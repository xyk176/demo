package com.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zouquanxing
 * @description: TODO
 * @Classname ordervo
 * @Date 2020/12/23 15:26
 */
public class ordervo {
    private Integer oId;
    private Date oDate;
    private String pay;
    private BigDecimal price;
    private String orsip;
    private String remarks;
    private String ortype;
    private String cname;
    private String adprovince;
    private String adcity;
    private String adarea;
    private String addetailed;

    @Override
    public String toString() {
        return "ordervo{" +
                "oId=" + oId +
                ", oDate=" + oDate +
                ", pay='" + pay + '\'' +
                ", price=" + price +
                ", orsip='" + orsip + '\'' +
                ", remarks='" + remarks + '\'' +
                ", ortype='" + ortype + '\'' +
                ", cname='" + cname + '\'' +
                ", adprovince='" + adprovince + '\'' +
                ", adcity='" + adcity + '\'' +
                ", adarea='" + adarea + '\'' +
                ", addetailed='" + addetailed + '\'' +
                '}';
    }

    public ordervo() {
    }

    public ordervo(Integer oId, Date oDate, String pay, BigDecimal price, String orsip, String remarks, String ortype, String cname, String adprovince, String adcity, String adarea, String addetailed) {
        this.oId = oId;
        this.oDate = oDate;
        this.pay = pay;
        this.price = price;
        this.orsip = orsip;
        this.remarks = remarks;
        this.ortype = ortype;
        this.cname = cname;
        this.adprovince = adprovince;
        this.adcity = adcity;
        this.adarea = adarea;
        this.addetailed = addetailed;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrsip() {
        return orsip;
    }

    public void setOrsip(String orsip) {
        this.orsip = orsip;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrtype() {
        return ortype;
    }

    public void setOrtype(String ortype) {
        this.ortype = ortype;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAdprovince() {
        return adprovince;
    }

    public void setAdprovince(String adprovince) {
        this.adprovince = adprovince;
    }

    public String getAdcity() {
        return adcity;
    }

    public void setAdcity(String adcity) {
        this.adcity = adcity;
    }

    public String getAdarea() {
        return adarea;
    }

    public void setAdarea(String adarea) {
        this.adarea = adarea;
    }

    public String getAddetailed() {
        return addetailed;
    }

    public void setAddetailed(String addetailed) {
        this.addetailed = addetailed;
    }
}
