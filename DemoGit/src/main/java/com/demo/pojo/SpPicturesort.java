package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpPicturesort
 * @Date 2020-12-21 11:48
 */
@Entity
@Table(name = "sp_picturesort", schema = "jindun", catalog = "")
public class SpPicturesort {
    private int pisid;
    private String prcost;
    private List<SpPicture> pics;

    @Id
    @Column(name = "pisid")
    public int getPisid() {
        return pisid;
    }

    public void setPisid(int pisid) {
        this.pisid = pisid;
    }

    @Basic
    @Column(name = "prcost")
    public String getPrcost() {
        return prcost;
    }

    public void setPrcost(String prcost) {
        this.prcost = prcost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpPicturesort that = (SpPicturesort) o;
        return pisid == that.pisid &&
                Objects.equals(prcost, that.prcost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pisid, prcost);
    }

    @OneToMany(mappedBy = "pis")
    public List<SpPicture> getPics() {
        return pics;
    }

    public void setPics(List<SpPicture> pics) {
        this.pics = pics;
    }
}
