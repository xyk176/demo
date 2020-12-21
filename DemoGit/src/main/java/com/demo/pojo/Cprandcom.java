package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Cprandcom
 * @Date 2020-12-21 11:58
 */
@Entity
public class Cprandcom {
    private Integer cproid;
    private SpCommodityparameter cpr;
    private SpCommodity com;

    @Id
    @Column(name = "cproid")
    public Integer getCproid() {
        return cproid;
    }

    public void setCproid(Integer cproid) {
        this.cproid = cproid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cprandcom cprandcom = (Cprandcom) o;
        return cproid == cprandcom.cproid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cproid);
    }

    @ManyToOne
    @JoinColumn(name = "cprid", referencedColumnName = "cprid")
    public SpCommodityparameter getCpr() {
        return cpr;
    }

    public void setCpr(SpCommodityparameter cpr) {
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
