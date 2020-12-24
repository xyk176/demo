package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Address
 * @Date 2020-12-21 14:16
 */
@Entity
public class Address {
    private Orders order;
    private Integer adid;
    private String adprovince;
    private String adcity;
    private String adarea;
    private String addetailed;
    private String adisdelete;
    private String adisdefault;
    private Customer customer;

    @Override
    public String toString() {
        return "Address{" +
                "adid=" + adid +
                ", adprovince='" + adprovince + '\'' +
                ", adcity='" + adcity + '\'' +
                ", adarea='" + adarea + '\'' +
                ", addetailed='" + addetailed + '\'' +
                ", adisdelete='" + adisdelete + '\'' +
                ", adisdefault='" + adisdefault + '\'' +
                '}';
    }

    @OneToOne(mappedBy = "address")
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Id
    @Column(name = "adid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    @Basic
    @Column(name = "adprovince")
    public String getAdprovince() {
        return adprovince;
    }

    public void setAdprovince(String adprovince) {
        this.adprovince = adprovince;
    }

    @Basic
    @Column(name = "adcity")
    public String getAdcity() {
        return adcity;
    }

    public void setAdcity(String adcity) {
        this.adcity = adcity;
    }

    @Basic
    @Column(name = "adarea")
    public String getAdarea() {
        return adarea;
    }

    public void setAdarea(String adarea) {
        this.adarea = adarea;
    }

    @Basic
    @Column(name = "addetailed")
    public String getAddetailed() {
        return addetailed;
    }

    public void setAddetailed(String addetailed) {
        this.addetailed = addetailed;
    }

    @Basic
    @Column(name = "adisdelete")
    public String getAdisdelete() {
        return adisdelete;
    }

    public void setAdisdelete(String adisdelete) {
        this.adisdelete = adisdelete;
    }

    @Basic
    @Column(name = "adisdefault")
    public String getAdisdefault() {
        return adisdefault;
    }

    public void setAdisdefault(String adisdefault) {
        this.adisdefault = adisdefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return adid == address.adid &&
                Objects.equals(adprovince, address.adprovince) &&
                Objects.equals(adcity, address.adcity) &&
                Objects.equals(adarea, address.adarea) &&
                Objects.equals(addetailed, address.addetailed) &&
                Objects.equals(adisdelete, address.adisdelete) &&
                Objects.equals(adisdefault, address.adisdefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adid, adprovince, adcity, adarea, addetailed, adisdelete, adisdefault);
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
