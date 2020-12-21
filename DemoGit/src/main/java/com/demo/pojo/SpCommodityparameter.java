package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpCommodityparameter
 * @Date 2020-12-21 11:58
 */
@Entity
@Table(name = "sp_commodityparameter", schema = "jindun", catalog = "")
public class SpCommodityparameter {
    private int cprid;
    private Integer cprtopid;
    private String cprname;
    private List<Cprandcom> coms;

    @Id
    @Column(name = "cprid")
    public int getCprid() {
        return cprid;
    }

    public void setCprid(int cprid) {
        this.cprid = cprid;
    }

    @Basic
    @Column(name = "cprtopid")
    public Integer getCprtopid() {
        return cprtopid;
    }

    public void setCprtopid(Integer cprtopid) {
        this.cprtopid = cprtopid;
    }

    @Basic
    @Column(name = "cprname")
    public String getCprname() {
        return cprname;
    }

    public void setCprname(String cprname) {
        this.cprname = cprname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommodityparameter that = (SpCommodityparameter) o;
        return cprid == that.cprid &&
                Objects.equals(cprtopid, that.cprtopid) &&
                Objects.equals(cprname, that.cprname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cprid, cprtopid, cprname);
    }

    @OneToMany(mappedBy = "cpr")
    public List<Cprandcom> getComs() {
        return coms;
    }

    public void setComs(List<Cprandcom> coms) {
        this.coms = coms;
    }
}
