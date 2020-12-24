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
    private String ccyname;
    private String ccytopid;
    private List<SpCommodity> coms;

    public String getCcytopid() {
        return ccytopid;
    }

    public void setCcytopid(String ccytopid) {
        this.ccytopid = ccytopid;
    }

    @Id
    @Column(name = "ccyid", nullable = false)
    public Integer getCcyid() {
        return ccyid;
    }

    public void setCcyid(Integer ccyid) {
        this.ccyid = ccyid;
    }

    @Basic
    @Column(name = "ccyname", nullable = false, length = 255)
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
                Objects.equals(ccyname, that.ccyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccyid, ccyname);
    }

    @OneToMany(mappedBy = "ccy")
    public List<SpCommodity> getComs() {
        return coms;
    }

    public void setComs(List<SpCommodity> coms) {
        this.coms = coms;
    }

    @Basic
    @Column(name = "ccytopid", nullable = false, length = 255)
    public String getCcytopid() {
        return ccytopid;
    }

    public void setCcytopid(String ccytopid) {
        this.ccytopid = ccytopid;
    }
}
