package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sp_picture", schema = "jindun")
public class SpPicture {
    private Integer picid;
    private Integer picsort;
    private String picpath;
    private List<SpProduct> products;
    private SpPicturesort pis;
    private List<SpPicturetocom> coms;
    private List<SpPicturetopro> picturetopros;

    @Override
    public String toString() {
        return "SpPicture{" +
                "picid=" + picid +
                ", picsort=" + picsort +
                ", picpath='" + picpath + '\'' +
                ", products=" + products +
                ", pis=" + pis +
                ", coms=" + coms +
                ", picturetopros=" + picturetopros +
                '}';
    }

    @Id
    @Column(name = "picid")
    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
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

    @OneToMany(mappedBy = "picture")
    public List<SpPicturetopro> getPicturetopros() {
        return picturetopros;
    }

    public void setPicturetopros(List<SpPicturetopro> picturetopros) {
        this.picturetopros = picturetopros;
    }
}
