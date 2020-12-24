package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Shopping
 * @Date 2020-12-21 14:04
 */
@Entity
public class Shopping {
    private Integer shid;
    private Integer stype;
    private SpCommodity com;
    private Customer customer;
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Id
    @Column(name = "shid")
    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    @Basic
    @Column(name = "stype")
    public Integer getStype() {
        return stype;
    }

    public void setStype(Integer stype) {
        this.stype = stype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopping shopping = (Shopping) o;
        return shid == shopping.shid &&
                Objects.equals(stype, shopping.stype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shid, stype);
    }

    @ManyToOne
    @JoinColumn(name = "comid", referencedColumnName = "comid")
    public SpCommodity getCom() {
        return com;
    }

    public void setCom(SpCommodity com) {
        this.com = com;
    }

    @ManyToOne
    @JoinColumn(name = "cid3", referencedColumnName = "cid3")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
