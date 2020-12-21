package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Beput
 * @Date 2020-12-21 14:34
 */
@Entity
public class Beput {
    private int beid;
    private String beclass;
    private Timestamp bedate;
    private String beremark;
    private Integer yewuid;
    private Supplier supplier;

    @Id
    @Column(name = "beid")
    public int getBeid() {
        return beid;
    }

    public void setBeid(int beid) {
        this.beid = beid;
    }

    @Basic
    @Column(name = "beclass")
    public String getBeclass() {
        return beclass;
    }

    public void setBeclass(String beclass) {
        this.beclass = beclass;
    }

    @Basic
    @Column(name = "bedate")
    public Timestamp getBedate() {
        return bedate;
    }

    public void setBedate(Timestamp bedate) {
        this.bedate = bedate;
    }

    @Basic
    @Column(name = "beremark")
    public String getBeremark() {
        return beremark;
    }

    public void setBeremark(String beremark) {
        this.beremark = beremark;
    }

    @Basic
    @Column(name = "yewuid")
    public Integer getYewuid() {
        return yewuid;
    }

    public void setYewuid(Integer yewuid) {
        this.yewuid = yewuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beput beput = (Beput) o;
        return beid == beput.beid &&
                Objects.equals(beclass, beput.beclass) &&
                Objects.equals(bedate, beput.bedate) &&
                Objects.equals(beremark, beput.beremark) &&
                Objects.equals(yewuid, beput.yewuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beid, beclass, bedate, beremark, yewuid);
    }

    @ManyToOne
    @JoinColumn(name = "suid", referencedColumnName = "suid")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
