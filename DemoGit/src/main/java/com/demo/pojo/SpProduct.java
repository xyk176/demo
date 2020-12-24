package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sp_product", schema = "jindun", catalog = "")
public class SpProduct {
    private Integer lid;
    private String lname;
    private String lguige;
    private String ldanwei;
    private Integer ltiaoma;
    private Integer lchengben;
    private Integer cid;
    private List<SpCommoditytopro> commoditytopro;
    private List<Checkxq> checkxqs;
    private List<Beputxq> beputxqs;
    private List<Outandinput> outandinputs;
    private List<Inventory> inventorys;
    private List<SpPicturetopro> picturetopro;
    private SpProductsort prs;
    private List<Outputxq> outputxqs;

    @Override
    public String toString() {
        return "SpProduct{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", lguige='" + lguige + '\'' +
                ", ldanwei='" + ldanwei + '\'' +
                ", ltiaoma=" + ltiaoma +
                ", lchengben=" + lchengben +
                ", cid=" + cid +
                ", commoditytopro=" + commoditytopro +
                ", checkxqs=" + checkxqs +
                ", beputxqs=" + beputxqs +
                ", outandinputs=" + outandinputs +
                ", inventorys=" + inventorys +
                ", picturetopro=" + picturetopro +
                ", prs=" + prs +
                ", outputxqs=" + outputxqs +
                '}';
    }

    @Id
    @Column(name = "lid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    @Basic
    @Column(name = "lname", nullable = true, length = 20)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "lguige", nullable = true, length = 20)
    public String getLguige() {
        return lguige;
    }

    public void setLguige(String lguige) {
        this.lguige = lguige;
    }

    @Basic
    @Column(name = "ldanwei", nullable = true, length = 10)
    public String getLdanwei() {
        return ldanwei;
    }

    public void setLdanwei(String ldanwei) {
        this.ldanwei = ldanwei;
    }

    @Basic
    @Column(name = "ltiaoma", nullable = true)
    public Integer getLtiaoma() {
        return ltiaoma;
    }

    public void setLtiaoma(Integer ltiaoma) {
        this.ltiaoma = ltiaoma;
    }

    @Basic
    @Column(name = "lchengben", nullable = true, precision = 0)
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
    @Column(name = "cid", nullable = true)
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

    @ManyToOne
    @JoinColumn(name = "cid2", referencedColumnName = "cid2")
    public SpProductsort getPrs() {
        return prs;
    }

    public void setPrs(SpProductsort prs) {
        this.prs = prs;
    }

    @OneToMany(mappedBy = "sproduct")
    public List<Outputxq> getOutputxqs() {
        return outputxqs;
    }

    public void setOutputxqs(List<Outputxq> outputxqs) {
        this.outputxqs = outputxqs;
    }
}
