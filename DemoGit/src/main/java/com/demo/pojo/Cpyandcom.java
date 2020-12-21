package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Cpyandcom
 * @Date 2020-12-21 12:00
 */
@Entity
public class Cpyandcom {
    private int cpcoid;
    private SpCommodityproperty cpr;
    private SpCommodity com;

    @Id
    @Column(name = "cpcoid")
    public int getCpcoid() {
        return cpcoid;
    }

    public void setCpcoid(int cpcoid) {
        this.cpcoid = cpcoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpyandcom cpyandcom = (Cpyandcom) o;
        return cpcoid == cpyandcom.cpcoid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpcoid);
    }

    @ManyToOne
    @JoinColumn(name = "cpyid", referencedColumnName = "cpyid")
    public SpCommodityproperty getCpr() {
        return cpr;
    }

    public void setCpr(SpCommodityproperty cpr) {
        this.cpr = cpr;
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
