package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpPicturetopro
 * @Date 2020-12-21 16:15
 */
@Entity
@Table(name = "sp_picturetopro", schema = "jindun", catalog = "")
public class SpPicturetopro {
    private int ptpid;
    private Integer lid;
    private Integer picid;
    private int ptpiszhu;
    private SpProduct product;
    private SpPicture picture;

    @Id
    @Column(name = "ptpid")
    public int getPtpid() {
        return ptpid;
    }

    public void setPtpid(int ptpid) {
        this.ptpid = ptpid;
    }

    @Basic
    @Column(name = "lid")
    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "picid")
    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    @Basic
    @Column(name = "ptpiszhu")
    public int getPtpiszhu() {
        return ptpiszhu;
    }

    public void setPtpiszhu(int ptpiszhu) {
        this.ptpiszhu = ptpiszhu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpPicturetopro that = (SpPicturetopro) o;
        return ptpid == that.ptpid &&
                ptpiszhu == that.ptpiszhu &&
                Objects.equals(lid, that.lid) &&
                Objects.equals(picid, that.picid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ptpid, lid, picid, ptpiszhu);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "picid", referencedColumnName = "picid")
    public SpPicture getPicture() {
        return picture;
    }

    public void setPicture(SpPicture picture) {
        this.picture = picture;
    }
}
