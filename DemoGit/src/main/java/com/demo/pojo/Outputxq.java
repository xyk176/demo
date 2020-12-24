package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname Outputxq
 * @Date 2020/12/22 19:32
 */
@Entity
public class Outputxq {
    private int outxqid;
    private int outxqcount;
    private Output output;
    private SpProduct sproduct;

    @Id
    @Column(name = "outxqid", nullable = false)
    public int getOutxqid() {
        return outxqid;
    }

    public void setOutxqid(int outxqid) {
        this.outxqid = outxqid;
    }

    @Basic
    @Column(name = "outxqcount", nullable = false)
    public int getOutxqcount() {
        return outxqcount;
    }

    public void setOutxqcount(int outxqcount) {
        this.outxqcount = outxqcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outputxq outputxq = (Outputxq) o;
        return outxqid == outputxq.outxqid &&
                outxqcount == outputxq.outxqcount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(outxqid, outxqcount);
    }

    @ManyToOne
    @JoinColumn(name = "outid", referencedColumnName = "outid")
    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @ManyToOne
    @JoinColumn(name = "lid", referencedColumnName = "lid", nullable = false)
    public SpProduct getSproduct() {
        return sproduct;
    }

    public void setSproduct(SpProduct sproduct) {
        this.sproduct = sproduct;
    }
}
