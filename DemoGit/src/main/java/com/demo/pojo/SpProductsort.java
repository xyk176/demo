package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sp_productsort", schema = "jindun", catalog = "")
public class SpProductsort {
    private Integer cid2;
    private String cname;
    private Integer cfid;
    private List<SpProduct> pros;

    @Id
    @Column(name = "cid2", nullable = false)
    public Integer getCid2() {
        return cid2;
    }

    public void setCid2(Integer cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cname", nullable = true, length = 20)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpProductsort that = (SpProductsort) o;
        return cid2 == that.cid2 &&
                Objects.equals(cname, that.cname);
    }

    @Basic
    @Column(name = "cfid", nullable = true)
    public Integer getCfid() {
        return cfid;
    }

    public void setCfid(Integer cfid) {
        this.cfid = cfid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid2, cname, cfid);
    }

    @OneToMany(mappedBy = "prs")
    public List<SpProduct> getPros() {
        return pros;
    }

    public void setPros(List<SpProduct> pros) {
        this.pros = pros;
    }
}
