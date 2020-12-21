package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Beputxq {
    private int bexqid;
    private int libecount;
    private SpProduct product;
    private Beput beput;

    @Id
    @Column(name = "bexqid", nullable = false)
    public int getBexqid() {
        return bexqid;
    }

    public void setBexqid(int bexqid) {
        this.bexqid = bexqid;
    }

    @Basic
    @Column(name = "libecount", nullable = false)
    public int getLibecount() {
        return libecount;
    }

    public void setLibecount(int libecount) {
        this.libecount = libecount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beputxq beputxq = (Beputxq) o;
        return bexqid == beputxq.bexqid &&
                libecount == beputxq.libecount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bexqid, libecount);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid", nullable = false)
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }


    @ManyToOne
    @JoinColumn(name = "beid", referencedColumnName = "beid")
    public Beput getBeput() {
        return beput;
    }

    public void setBeput(Beput beput) {
        this.beput = beput;
    }
}
