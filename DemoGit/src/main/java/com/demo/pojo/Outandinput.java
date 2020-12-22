package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Outandinput {
    private Integer outinid;
    private String outinclass;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp outindate;
    private Integer outincount;
    private SpProduct product;
    private Integer yewuid;

    @Id
    @Column(name = "outinid")
    public Integer getOutinid() {
        return outinid;
    }

    public void setOutinid(Integer outinid) {
        this.outinid = outinid;
    }

    @Basic
    @Column(name = "outinclass")
    public String getOutinclass() {
        return outinclass;
    }

    public void setOutinclass(String outinclass) {
        this.outinclass = outinclass;
    }

    @Basic
    @Column(name = "outindate")
    public Timestamp getOutindate() {
        return outindate;
    }

    public void setOutindate(Timestamp outindate) {
        this.outindate = outindate;
    }

    @Basic
    @Column(name = "outincount")
    public int getOutincount() {
        return outincount;
    }

    public void setOutincount(int outincount) {
        this.outincount = outincount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outandinput that = (Outandinput) o;
        return outinid == that.outinid &&
                outincount == that.outincount &&
                Objects.equals(outinclass, that.outinclass) &&
                Objects.equals(outindate, that.outindate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outinid, outinclass, outindate, outincount);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }

    @Basic
    @Column(name = "yewuid", nullable = true)
    public Integer getYewuid() {
        return yewuid;
    }

    public void setYewuid(Integer yewuid) {
        this.yewuid = yewuid;
    }
}
