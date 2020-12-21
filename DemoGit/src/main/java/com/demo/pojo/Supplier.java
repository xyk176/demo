package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Supplier
 * @Date 2020-12-21 14:34
 */
@Entity
public class Supplier {
    private int suid;
    private String suname;
    private String suphone;
    private String susheng;
    private String sushi;
    private String suqu;
    private String sulxr;
    private String sulxrphone;
    private String suqq;
    private String suwx;
    private String suemail;
    private String sufax;
    private List<Beput> beputs;

    @Id
    @Column(name = "suid")
    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    @Basic
    @Column(name = "suname")
    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    @Basic
    @Column(name = "suphone")
    public String getSuphone() {
        return suphone;
    }

    public void setSuphone(String suphone) {
        this.suphone = suphone;
    }

    @Basic
    @Column(name = "susheng")
    public String getSusheng() {
        return susheng;
    }

    public void setSusheng(String susheng) {
        this.susheng = susheng;
    }

    @Basic
    @Column(name = "sushi")
    public String getSushi() {
        return sushi;
    }

    public void setSushi(String sushi) {
        this.sushi = sushi;
    }

    @Basic
    @Column(name = "suqu")
    public String getSuqu() {
        return suqu;
    }

    public void setSuqu(String suqu) {
        this.suqu = suqu;
    }

    @Basic
    @Column(name = "sulxr")
    public String getSulxr() {
        return sulxr;
    }

    public void setSulxr(String sulxr) {
        this.sulxr = sulxr;
    }

    @Basic
    @Column(name = "sulxrphone")
    public String getSulxrphone() {
        return sulxrphone;
    }

    public void setSulxrphone(String sulxrphone) {
        this.sulxrphone = sulxrphone;
    }

    @Basic
    @Column(name = "suqq")
    public String getSuqq() {
        return suqq;
    }

    public void setSuqq(String suqq) {
        this.suqq = suqq;
    }

    @Basic
    @Column(name = "suwx")
    public String getSuwx() {
        return suwx;
    }

    public void setSuwx(String suwx) {
        this.suwx = suwx;
    }

    @Basic
    @Column(name = "suemail")
    public String getSuemail() {
        return suemail;
    }

    public void setSuemail(String suemail) {
        this.suemail = suemail;
    }

    @Basic
    @Column(name = "sufax")
    public String getSufax() {
        return sufax;
    }

    public void setSufax(String sufax) {
        this.sufax = sufax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return suid == supplier.suid &&
                Objects.equals(suname, supplier.suname) &&
                Objects.equals(suphone, supplier.suphone) &&
                Objects.equals(susheng, supplier.susheng) &&
                Objects.equals(sushi, supplier.sushi) &&
                Objects.equals(suqu, supplier.suqu) &&
                Objects.equals(sulxr, supplier.sulxr) &&
                Objects.equals(sulxrphone, supplier.sulxrphone) &&
                Objects.equals(suqq, supplier.suqq) &&
                Objects.equals(suwx, supplier.suwx) &&
                Objects.equals(suemail, supplier.suemail) &&
                Objects.equals(sufax, supplier.sufax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suid, suname, suphone, susheng, sushi, suqu, sulxr, sulxrphone, suqq, suwx, suemail, sufax);
    }

    @OneToMany(mappedBy = "supplier")
    public List<Beput> getBeputs() {
        return beputs;
    }

    public void setBeputs(List<Beput> beputs) {
        this.beputs = beputs;
    }
}
