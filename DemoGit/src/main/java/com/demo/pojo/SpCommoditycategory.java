package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpCommoditycategory
 * @Date 2020-12-21 14:01
 */
@Entity
@Table(name = "sp_commoditycategory", schema = "jindun", catalog = "")
public class SpCommoditycategory {
    private Integer ccyid;
    private String ccytopid;
    private String ccyname;
    private List<SpCommodity> coms;

    @Id
    @Column(name = "ccyid")
    public Integer getCcyid() {
        return ccyid;
    }

    public void setCcyid(Integer ccyid) {
        this.ccyid = ccyid;
    }

    @Basic
    @Column(name = "ccytopid")
    public String getCcytopid() {
        return ccytopid;
    }

    public void setCcytopid(String ccytopid) {
        this.ccytopid = ccytopid;
    }

    @Basic
    @Column(name = "ccyname")
    public String getCcyname() {
        return ccyname;
    }

    public void setCcyname(String ccyname) {
        this.ccyname = ccyname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommoditycategory that = (SpCommoditycategory) o;
        return ccyid == that.ccyid &&
                Objects.equals(ccytopid, that.ccytopid) &&
                Objects.equals(ccyname, that.ccyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccyid, ccytopid, ccyname);
    }

    @OneToMany(mappedBy = "ccy")
    public List<SpCommodity> getComs() {
        return coms;
    }

    public void setComs(List<SpCommodity> coms) {
        this.coms = coms;
    }
}
