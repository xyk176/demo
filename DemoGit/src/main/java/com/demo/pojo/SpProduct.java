package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sp_product", schema = "jindun", catalog = "")
public class SpProduct {
    private int lid;
    private String lname;
    private String lguige;
    private String ldanwei;
    private Integer ltiaoma;
    private Integer lchengben;
    private List<SpProductsort> productsorts;
    private List<SpPicture> pictures;
    private List<Output> outputs;
    private List<SpCommoditytopro> commoditytopro;
    private List<Checkxq> checkxqs;
    private List<Beputxq> beputxqs;
    private List<Outandinput> outandinputs;
    private Integer cid2;
    private Integer cid;
    private List<Inventory> inventorys;
    private List<SpPicturetopro> picturetopro;

    @Id
    @Column(name = "lid")
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "lguige")
    public String getLguige() {
        return lguige;
    }

    public void setLguige(String lguige) {
        this.lguige = lguige;
    }

    @Basic
    @Column(name = "ldanwei")
    public String getLdanwei() {
        return ldanwei;
    }

    public void setLdanwei(String ldanwei) {
        this.ldanwei = ldanwei;
    }

    @Basic
    @Column(name = "ltiaoma")
    public Integer getLtiaoma() {
        return ltiaoma;
    }

    public void setLtiaoma(Integer ltiaoma) {
        this.ltiaoma = ltiaoma;
    }

    @Basic
    @Column(name = "lchengben")
    public Integer getLchengben() {
        return lchengben;
    }

    public void setLchengben(Integer lchengben) {
        this.lchengben = lchengben;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpProduct spProduct = (SpProduct) o;
        return lid == spProduct.lid &&
                Objects.equals(lname, spProduct.lname) &&
                Objects.equals(lguige, spProduct.lguige) &&
                Objects.equals(ldanwei, spProduct.ldanwei) &&
                Objects.equals(ltiaoma, spProduct.ltiaoma) &&
                Objects.equals(lchengben, spProduct.lchengben);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, lname, lguige, ldanwei, ltiaoma, lchengben);
    }

    @OneToMany(mappedBy = "product")
    public List<SpProductsort> getProductsorts() {
        return productsorts;
    }

    public void setProductsorts(List<SpProductsort> productsorts) {
        this.productsorts = productsorts;
    }

    @ManyToMany(mappedBy = "products")
    public List<SpPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<SpPicture> pictures) {
        this.pictures = pictures;
    }

    @OneToMany(mappedBy = "product")
    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    @OneToMany(mappedBy = "products")
    public List<SpCommoditytopro> getCommoditytopro() {
        return commoditytopro;
    }

    public void setCommoditytopro(List<SpCommoditytopro> commoditytopro) {
        this.commoditytopro = commoditytopro;
    }

    @OneToMany(mappedBy = "product")
    public List<Checkxq> getCheckxqs() {
        return checkxqs;
    }

    public void setCheckxqs(List<Checkxq> checkxqs) {
        this.checkxqs = checkxqs;
    }

    @OneToMany(mappedBy = "product")
    public List<Beputxq> getBeputxqs() {
        return beputxqs;
    }

    public void setBeputxqs(List<Beputxq> beputxqs) {
        this.beputxqs = beputxqs;
    }

    @OneToMany(mappedBy = "product")
    public List<Outandinput> getOutandinputs() {
        return outandinputs;
    }

    public void setOutandinputs(List<Outandinput> outandinputs) {
        this.outandinputs = outandinputs;
    }

    @Basic
    @Column(name = "cid2")
    public Integer getCid2() {
        return cid2;
    }

    public void setCid2(Integer cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cid")
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @OneToMany(mappedBy = "product")
    public List<Inventory> getInventorys() {
        return inventorys;
    }

    public void setInventorys(List<Inventory> inventorys) {
        this.inventorys = inventorys;
    }

    @OneToMany(mappedBy = "product")
    public List<SpPicturetopro> getPicturetopro() {
        return picturetopro;
    }

    public void setPicturetopro(List<SpPicturetopro> picturetopro) {
        this.picturetopro = picturetopro;
    }
}
