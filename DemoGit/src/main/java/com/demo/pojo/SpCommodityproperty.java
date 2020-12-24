package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpCommodityproperty
 * @Date 2020-12-21 12:00
 */
@Entity
@Table(name = "sp_commodityproperty", schema = "jindun")
public class SpCommodityproperty {
    private Integer cpyid;
    private Integer cpytopid;
    private String cpyname;
    private List<Cpyandcom> coms;
    private List<SpCommodityproperty> cpyss;

    @Transient
    public List<SpCommodityproperty> getCpyss() {
        return cpyss;
    }

    public void setCpys(List<SpCommodityproperty> cpys) {
        this.cpyss = cpys;
    }

    @Id
    @Column(name = "cpyid")
    public Integer getCpyid() {
        return cpyid;
    }

    public void setCpyid(Integer cpyid) {
        this.cpyid = cpyid;
    }

    @Basic
    @Column(name = "cpytopid")
    public Integer getCpytopid() {
        return cpytopid;
    }

    public void setCpytopid(Integer cpytopid) {
        this.cpytopid = cpytopid;
    }

    @Basic
    @Column(name = "cpyname")
    public String getCpyname() {
        return cpyname;
    }

    public void setCpyname(String cpyname) {
        this.cpyname = cpyname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommodityproperty that = (SpCommodityproperty) o;
        return cpyid == that.cpyid &&
                Objects.equals(cpytopid, that.cpytopid) &&
                Objects.equals(cpyname, that.cpyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpyid, cpytopid, cpyname);
    }

    @OneToMany(mappedBy = "cpr")
    public List<Cpyandcom> getComs() {
        return coms;
    }

    public void setComs(List<Cpyandcom> coms) {
        this.coms = coms;
    }
}
