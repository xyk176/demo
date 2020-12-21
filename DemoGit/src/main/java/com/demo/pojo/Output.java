package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Output {
    private Integer outid;
    private String outclass;
    private Date outdate;
    private String outremark;
    private SpProduct product;
    private Orders orderss;

    @Id
    @Column(name = "outid")
    public Integer getOutid() {
        return outid;
    }

    public void setOutid(Integer outid) {
        this.outid = outid;
    }

    @Basic
    @Column(name = "outclass")
    public String getOutclass() {
        return outclass;
    }

    public void setOutclass(String outclass) {
        this.outclass = outclass;
    }

    @Basic
    @Column(name = "outdate")
    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    @Basic
    @Column(name = "outremark")
    public String getOutremark() {
        return outremark;
    }

    public void setOutremark(String outremark) {
        this.outremark = outremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Output output = (Output) o;
        return outid == output.outid &&
                Objects.equals(outclass, output.outclass) &&
                Objects.equals(outdate, output.outdate) &&
                Objects.equals(outremark, output.outremark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outid, outclass, outdate, outremark);
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
    @JoinColumn(name = "o_id", referencedColumnName = "o_id")
    public Orders getOrderss() {
        return orderss;
    }

    public void setOrderss(Orders orderss) {
        this.orderss = orderss;
    }
}
