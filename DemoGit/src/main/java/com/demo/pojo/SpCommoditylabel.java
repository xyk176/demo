package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname SpCommoditylabel
 * @Date 2020-12-21 14:00
 */
@Entity
@Table(name = "sp_commoditylabel", schema = "jindun", catalog = "")
public class SpCommoditylabel {
    private int cllid;
    private String cllname;
    private List<SpCommodity> coms;

    @Id
    @Column(name = "cllid")
    public int getCllid() {
        return cllid;
    }

    public void setCllid(int cllid) {
        this.cllid = cllid;
    }

    @Basic
    @Column(name = "cllname")
    public String getCllname() {
        return cllname;
    }

    public void setCllname(String cllname) {
        this.cllname = cllname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpCommoditylabel that = (SpCommoditylabel) o;
        return cllid == that.cllid &&
                Objects.equals(cllname, that.cllname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cllid, cllname);
    }

    @OneToMany(mappedBy = "cll")
    public List<SpCommodity> getComs() {
        return coms;
    }

    public void setComs(List<SpCommodity> coms) {
        this.coms = coms;
    }
}
