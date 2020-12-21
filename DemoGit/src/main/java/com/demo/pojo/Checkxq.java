package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Checkxq {
    private Integer chexqid;
    private Integer chexqcount;
    private Integer cheblcount;
    private SpProduct product;
    private Checks checks;

    @Id
    @Column(name = "chexqid")
    public Integer getChexqid() {
        return chexqid;
    }

    public void setChexqid(Integer chexqid) {
        this.chexqid = chexqid;
    }

    @Basic
    @Column(name = "chexqcount")
    public Integer getChexqcount() {
        return chexqcount;
    }

    public void setChexqcount(Integer chexqcount) {
        this.chexqcount = chexqcount;
    }

    @Basic
    @Column(name = "cheblcount")
    public Integer getCheblcount() {
        return cheblcount;
    }

    public void setCheblcount(Integer cheblcount) {
        this.cheblcount = cheblcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkxq checkxq = (Checkxq) o;
        return chexqid == checkxq.chexqid &&
                Objects.equals(chexqcount, checkxq.chexqcount) &&
                Objects.equals(cheblcount, checkxq.cheblcount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chexqid, chexqcount, cheblcount);
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    public SpProduct getProduct() {
        return product;
    }

    public void setProduct(SpProduct product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "cheid", referencedColumnName = "cheid")
    public Checks getChecks() {
        return checks;
    }

    public void setChecks(Checks checks) {
        this.checks = checks;
    }
}
