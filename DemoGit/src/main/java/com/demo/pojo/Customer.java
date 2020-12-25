package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Customer
 * @Date 2020-12-21 14:16
 */
@Entity
public class Customer {
    private List<Orders> orderss;
    private Integer cid3;
    private String cname;
    private String cphone;
    private String password;
    private String chead;
    private List<Shopping> shoppings;
    private List<Address> address;

    @OneToMany(mappedBy = "customer")
    public List<Orders> getOrderss() {
        return orderss;
    }

    public void setOrderss(List<Orders> orderss) {
        this.orderss = orderss;
    }

    @Id
    @Column(name = "cid3")
    public Integer getCid3() {
        return cid3;
    }

    public void setCid3(Integer cid3) {
        this.cid3 = cid3;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "cphone")
    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "chead")
    public String getChead() {
        return chead;
    }

    public void setChead(String chead) {
        this.chead = chead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return cid3 == customer.cid3 &&
                Objects.equals(cname, customer.cname) &&
                Objects.equals(cphone, customer.cphone) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(chead, customer.chead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid3, cname, cphone, password, chead);
    }

    @OneToMany(mappedBy = "customer")
    public List<Shopping> getShoppings() {
        return shoppings;
    }

    public void setShoppings(List<Shopping> shoppings) {
        this.shoppings = shoppings;
    }

    @OneToMany(mappedBy = "customer")
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "orderss=" + orderss +
                ", cid3=" + cid3 +
                ", cname='" + cname + '\'' +
                ", cphone='" + cphone + '\'' +
                ", password='" + password + '\'' +
                ", chead='" + chead + '\'' +
                '}';
    }
}
