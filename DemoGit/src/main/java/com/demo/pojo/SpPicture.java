package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sp_picture", schema = "jindun", catalog = "")
public class SpPicture {
    private int picid;
    private Integer picsort;
    private String picpath;
    private List<SpProduct> products;
    private List<SpPicturetocom> picturetocoms;
    private SpPicturesort pis;
    private List<SpPicturetocom> coms;

    @Id
    @Column(name = "picid")
    public int getPicid() {
        return picid;
    }

    public void setPicid(int picid) {
        this.picid = picid;
    }

    @Basic
    @Column(name = "picsort")
    public Integer getPicsort() {
        return picsort;
    }

    public void setPicsort(Integer picsort) {
        this.picsort = picsort;
    }

    @Basic
    @Column(name = "picpath")
    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpPicture spPicture = (SpPicture) o;
        return picid == spPicture.picid &&
                Objects.equals(picsort, spPicture.picsort) &&
                Objects.equals(picpath, spPicture.picpath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picid, picsort, picpath);
    }

    @ManyToMany
    @JoinTable(name = "sp_picturetopro",  schema = "jindun", joinColumns = @JoinColumn(name = "picid", referencedColumnName = "picid"), inverseJoinColumns = @JoinColumn(name = "lid", referencedColumnName = "lid"))
    public List<SpProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SpProduct> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "picture")
    public List<SpPicturetocom> getPicturetocoms() {
        return picturetocoms;
    }

    public void setPicturetocoms(List<SpPicturetocom> picturetocoms) {
        this.picturetocoms = picturetocoms;
    }

    @ManyToOne
    @JoinColumn(name = "pisid", referencedColumnName = "pisid")
    public SpPicturesort getPis() {
        return pis;
    }

    public void setPis(SpPicturesort pis) {
        this.pis = pis;
    }

    @OneToMany(mappedBy = "pic")
    public List<SpPicturetocom> getComs() {
        return coms;
    }

    public void setComs(List<SpPicturetocom> coms) {
        this.coms = coms;
    }
}
