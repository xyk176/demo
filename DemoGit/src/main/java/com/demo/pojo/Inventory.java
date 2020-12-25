package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Inventory {
    private Integer inid;
    private Integer inentity;
    private Integer inoccupy;
    private Integer inusable;
    private Integer maxcount;
    private SpProduct product;

    @Id
    @Column(name = "inid")
    public Integer getInid() {
        return inid;
    }

    public void setInid(Integer inid) {
        this.inid = inid;
    }

    @Basic
    @Column(name = "inentity")
    public Integer getInentity() {
        return inentity;
    }

    public void setInentity(Integer inentity) {
        this.inentity = inentity;
    }


    @Basic
    @Column(name = "inoccupy")
    public Integer getInoccupy() {
        return inoccupy;
    }

    public void setInoccupy(Integer inoccupy) {
        this.inoccupy = inoccupy;
    }

    @Basic
    @Column(name = "inusable")
    public Integer getInusable() {
        return inusable;
    }

    public void setInusable(Integer inusable) {
        this.inusable = inusable;
    }

    @Basic
    @Column(name = "maxcount")
    public Integer getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(Integer maxcount) {
        this.maxcount = maxcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inid == inventory.inid &&
                Objects.equals(inentity, inventory.inentity) &&
                Objects.equals(inoccupy, inventory.inoccupy) &&
                Objects.equals(inusable, inventory.inusable) &&
                Objects.equals(maxcount, inventory.maxcount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inid, inentity, inoccupy, inusable, maxcount);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }
}
