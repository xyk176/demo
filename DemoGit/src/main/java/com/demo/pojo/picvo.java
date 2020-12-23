package com.demo.pojo;

import java.math.BigDecimal;

/**
 * @author: zouquanxing
 * @description: TODO
 * @Classname picvo
 * @Date 2020/12/23 9:41
 */
public class picvo {
    private Integer coms;
    private BigDecimal comprice;
    private String comname;
    private String picpath;
    private String cprname;
    private String cpyname;

    @Override
    public String toString() {
        return "picvo{" +
                "coms=" + coms +
                ", comprice=" + comprice +
                ", comname='" + comname + '\'' +
                ", picpath='" + picpath + '\'' +
                ", sprname='" + cprname + '\'' +
                ", spyname='" + cpyname + '\'' +
                '}';
    }

    public picvo() {
    }

    public picvo(Integer coms, BigDecimal comprice, String comname, String picpath, String cprname, String cpyname) {
        this.coms = coms;
        this.comprice = comprice;
        this.comname = comname;
        this.picpath = picpath;
        this.cprname = cprname;
        this.cpyname = cpyname;
    }

    public Integer getComs() {
        return coms;
    }

    public void setComs(Integer coms) {
        this.coms = coms;
    }

    public BigDecimal getComprice() {
        return comprice;
    }

    public void setComprice(BigDecimal comprice) {
        this.comprice = comprice;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getCprname() {
        return cprname;
    }

    public void setCprname(String cprname) {
        this.cprname = cprname;
    }

    public String getCpyname() {
        return cpyname;
    }

    public void setCpyname(String cpyname) {
        this.cpyname = cpyname;
    }
}
