package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
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
    private Integer suid;
    private List<Beputxq> beputxqs;

    @Id
    @Column(name = "beid", nullable = false)
    public int getBeid() {
        return beid;
    }

    public void setBeid(int beid) {
        this.beid = beid;
    }

    @Basic
    @Column(name = "beclass", nullable = false, length = 255)
    public String getBeclass() {
        return beclass;
    }

    public void setBeclass(String beclass) {
        this.beclass = beclass;
    }

    @Basic
    @Column(name = "bedate", nullable = false)
    public Timestamp getBedate() {
        return bedate;
    }

    public void setBedate(Timestamp bedate) {
        this.bedate = bedate;
    }

    @Basic
    @Column(name = "beremark", nullable = true, length = 255)
    public String getBeremark() {
        return beremark;
    }

    public void setBeremark(String beremark) {
        this.beremark = beremark;
    }

    @Basic
    @Column(name = "yewuid", nullable = true)
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

    @Basic
    @Column(name = "suid", nullable = true)
    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    @OneToMany(mappedBy = "beput")
    public List<Beputxq> getBeputxqs() {
        return beputxqs;
    }

    public void setBeputxqs(List<Beputxq> beputxqs) {
        this.beputxqs = beputxqs;
    }
}
