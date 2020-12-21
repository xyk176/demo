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
@Table(name = "sp_picturetopro", schema = "jindun")
public class SpPicturetopro {
    private Integer ptpid;
    private Integer ptpiszhu;
    private SpProduct product;
    private SpPicture picture;

    @Id
    @Column(name = "ptpid")
    public Integer getPtpid() {
        return ptpid;
    }

    public void setPtpid(Integer ptpid) {
        this.ptpid = ptpid;
    }

    @Basic
    @Column(name = "ptpiszhu")
    public Integer getPtpiszhu() {
        return ptpiszhu;
    }

    public void setPtpiszhu(Integer ptpiszhu) {
        this.ptpiszhu = ptpiszhu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpPicturetopro that = (SpPicturetopro) o;
        return ptpid == that.ptpid &&
                ptpiszhu == that.ptpiszhu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ptpid, ptpiszhu);
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
