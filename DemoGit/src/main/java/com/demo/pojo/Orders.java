package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Orders
 * @Date 2020-12-21 14:16
 */
@Entity
public class Orders {
    private Integer oId;
    private Date oDate;
    private String pay;
    private BigDecimal price;
    private String orsip;
    private String remarks;
    private String ortype;
    private List<OrderInfo> orderinfos;
    private Customer customer;
    private Address address;
    private List<Output> outputs;

    @Id
    @Column(name = "o_id")
    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "o_date")
    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    @Basic
    @Column(name = "pay")
    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "orsip")
    public String getOrsip() {
        return orsip;
    }

    public void setOrsip(String orsip) {
        this.orsip = orsip;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "ortype")
    public String getOrtype() {
        return ortype;
    }

    public void setOrtype(String ortype) {
        this.ortype = ortype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return oId == orders.oId &&
                Objects.equals(oDate, orders.oDate) &&
                Objects.equals(pay, orders.pay) &&
                Objects.equals(price, orders.price) &&
                Objects.equals(orsip, orders.orsip) &&
                Objects.equals(remarks, orders.remarks) &&
                Objects.equals(ortype, orders.ortype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, oDate, pay, price, orsip, remarks, ortype);
    }

    @OneToMany(mappedBy = "order")
    public List<OrderInfo> getOrderinfos() {
        return orderinfos;
    }

    public void setOrderinfos(List<OrderInfo> orderinfos) {
        this.orderinfos = orderinfos;
    }

    @ManyToOne
    @JoinColumn(name = "cid3", referencedColumnName = "cid3")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    @JoinColumn(name = "adid", referencedColumnName = "adid")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "orderss")
    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }
}
