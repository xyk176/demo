package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpCommodity
 * @Date 2020-12-21 11:52
 */
@Entity
@Table(name = "sp_commodity", schema = "jindun")
public class SpCommodity {
    private int comid;
    private int comiszu;
    private String combarcode;
    private String comname;
    private BigDecimal comsameprice;
    private BigDecimal compricemin;
    private BigDecimal compricemax;
    private BigDecimal commarketprice;
    private BigDecimal comweight;
    private BigDecimal comvolume;
    private Integer comsalesvolume;
    private Integer comsalesstatus;
    private Timestamp comdata;
    private List<SpCommoditytopro> coprs;
    private List<SpPicturetocom> pics;
    private List<Cprandcom> cprs;
    private List<Cpyandcom> cpys;
    private SpCommoditylabel cll;
    private SpCommoditycategory ccy;
    private List<Shopping> shopings;
    private List<OrderInfo> oderinfos;

    @Id
    @Column(name = "comid")
    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    @Basic
    @Column(name = "comiszu")
    public int getComiszu() {
        return comiszu;
    }

    public void setComiszu(int comiszu) {
        this.comiszu = comiszu;
    }

    @Basic
    @Column(name = "combarcode")
    public String getCombarcode() {
        return combarcode;
    }

    public void setCombarcode(String combarcode) {
        this.combarcode = combarcode;
    }

    @Basic
    @Column(name = "comname")
    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    @Basic
    @Column(name = "comsameprice")
    public BigDecimal getComsameprice() {
        return comsameprice;
    }

    public void setComsameprice(BigDecimal comsameprice) {
        this.comsameprice = comsameprice;
    }

    @Basic
    @Column(name = "compricemin")
    public BigDecimal getCompricemin() {
        return compricemin;
    }

    public void setCompricemin(BigDecimal compricemin) {
        this.compricemin = compricemin;
    }

    @Basic
    @Column(name = "compricemax")
    public BigDecimal getCompricemax() {
        return compricemax;
    }

    public void setCompricemax(BigDecimal compricemax) {
        this.compricemax = compricemax;
    }

    @Basic
    @Column(name = "commarketprice")
    public BigDecimal getCommarketprice() {
        return commarketprice;
    }

    public void setCommarketprice(BigDecimal commarketprice) {
        this.commarketprice = commarketprice;
    }

    @Basic
    @Column(name = "comweight")
    public BigDecimal getComweight() {
        return comweight;
    }

    public void setComweight(BigDecimal comweight) {
        this.comweight = comweight;
    }

    @Basic
    @Column(name = "comvolume")
    public BigDecimal getComvolume() {
        return comvolume;
    }

    public void setComvolume(BigDecimal comvolume) {
        this.comvolume = comvolume;
    }

    @Basic
    @Column(name = "comsalesvolume")
    public Integer getComsalesvolume() {
        return comsalesvolume;
    }

    public void setComsalesvolume(Integer comsalesvolume) {
        this.comsalesvolume = comsalesvolume;
    }

    @Basic
    @Column(name = "comsalesstatus")
    public Integer getComsalesstatus() {
        return comsalesstatus;
    }

    public void setComsalesstatus(Integer comsalesstatus) {
        this.comsalesstatus = comsalesstatus;
    }

    @Basic
    @Column(name = "comdata")
    public Timestamp getComdata() {
        return comdata;
    }

    public void setComdata(Timestamp comdata) {
        this.comdata = comdata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommodity that = (SpCommodity) o;
        return comid == that.comid &&
                comiszu == that.comiszu &&
                Objects.equals(combarcode, that.combarcode) &&
                Objects.equals(comname, that.comname) &&
                Objects.equals(comsameprice, that.comsameprice) &&
                Objects.equals(compricemin, that.compricemin) &&
                Objects.equals(compricemax, that.compricemax) &&
                Objects.equals(commarketprice, that.commarketprice) &&
                Objects.equals(comweight, that.comweight) &&
                Objects.equals(comvolume, that.comvolume) &&
                Objects.equals(comsalesvolume, that.comsalesvolume) &&
                Objects.equals(comsalesstatus, that.comsalesstatus) &&
                Objects.equals(comdata, that.comdata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comid, comiszu, combarcode, comname, comsameprice, compricemin, compricemax, commarketprice, comweight, comvolume, comsalesvolume, comsalesstatus, comdata);
    }

    @OneToMany(mappedBy = "com")
    public List<SpCommoditytopro> getCoprs() {
        return coprs;
    }

    public void setCoprs(List<SpCommoditytopro> coprs) {
        this.coprs = coprs;
    }

    @OneToMany(mappedBy = "com")
    public List<SpPicturetocom> getPics() {
        return pics;
    }

    public void setPics(List<SpPicturetocom> pics) {
        this.pics = pics;
    }

    @OneToMany(mappedBy = "com")
    public List<Cprandcom> getCprs() {
        return cprs;
    }

    public void setCprs(List<Cprandcom> cprs) {
        this.cprs = cprs;
    }

    @OneToMany(mappedBy = "com")
    public List<Cpyandcom> getCpys() {
        return cpys;
    }

    public void setCpys(List<Cpyandcom> cpys) {
        this.cpys = cpys;
    }

    @ManyToOne
    @JoinColumn(name = "cllid", referencedColumnName = "cllid")
    public SpCommoditylabel getCll() {
        return cll;
    }

    public void setCll(SpCommoditylabel cll) {
        this.cll = cll;
    }

    @ManyToOne
    @JoinColumn(name = "ccyid", referencedColumnName = "ccyid")
    public SpCommoditycategory getCcy() {
        return ccy;
    }

    public void setCcy(SpCommoditycategory ccy) {
        this.ccy = ccy;
    }

    @OneToMany(mappedBy = "com")
    public List<Shopping> getShopings() {
        return shopings;
    }

    public void setShopings(List<Shopping> shopings) {
        this.shopings = shopings;
    }

    @OneToMany(mappedBy = "com")
    public List<OrderInfo> getOderinfos() {
        return oderinfos;
    }

    public void setOderinfos(List<OrderInfo> oderinfos) {
        this.oderinfos = oderinfos;
    }
}
