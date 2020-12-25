package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sp_commoditytopro", schema = "jindun", catalog = "")
public class SpCommoditytopro {
    private Integer ctpid;
    private Integer ctpnum;
    private SpProduct products;
    private SpCommodity com;

    @Override
    public String toString() {
        return "SpCommoditytopro{" +
                "ctpid=" + ctpid +
                ", ctpnum=" + ctpnum +
                '}';
    }

    @Id
    @Column(name = "ctpid")
    public Integer getCtpid() {
        return ctpid;
    }

    public void setCtpid(Integer ctpid) {
        this.ctpid = ctpid;
    }

    @Basic
    @Column(name = "ctpnum")
    public Integer getCtpnum() {
        return ctpnum;
    }

    public void setCtpnum(Integer ctpnum) {
        this.ctpnum = ctpnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommoditytopro that = (SpCommoditytopro) o;
        return ctpid == that.ctpid &&
                Objects.equals(ctpnum, that.ctpnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctpid, ctpnum);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    public SpProduct getProducts() {
        return products;
    }

    public void setProducts(SpProduct products) {
        this.products = products;
    }

    @ManyToOne
    @JoinColumn(name = "comid", referencedColumnName = "comid")
    public SpCommodity getCom() {
        return com;
    }

    public void setCom(SpCommodity com) {
        this.com = com;
    }
}
