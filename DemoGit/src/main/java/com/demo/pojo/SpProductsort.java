package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sp_productsort", schema = "jindun")
public class SpProductsort {
    private int cid2;
    private String cname;
    private SpProduct product;

    @Id
    @Column(name = "cid2")
    public int getCid2() {
        return cid2;
    }

    public void setCid2(int cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpProductsort that = (SpProductsort) o;
        return cid2 == that.cid2 &&
                Objects.equals(cname, that.cname);
    }

    @ManyToOne
    @JoinColumn(name = "cid2", referencedColumnName = "cid2", nullable = false)
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }
}
