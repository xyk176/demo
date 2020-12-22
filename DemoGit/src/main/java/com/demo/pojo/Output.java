package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Output {
    private Integer outid;
    private String outclass;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp outdate;
    private String outremark;
    private Orders orderss;
    private Integer yewuid;
    private List<Outputxq> outputxqs;
    @Id
    @Column(name = "outid", nullable = false)
    public Integer getOutid() {
        return outid;
    }

    public void setOutid(Integer outid) {
        this.outid = outid;
    }

    @Basic
    @Column(name = "outclass", nullable = false, length = 255)
    public String getOutclass() {
        return outclass;
    }

    public void setOutclass(String outclass) {
        this.outclass = outclass;
    }

    @Basic
    @Column(name = "outdate", nullable = false)
    public Timestamp getOutdate() {
        return outdate;
    }

    public void setOutdate(Timestamp outdate) {
        this.outdate = outdate;
    }

    @Basic
    @Column(name = "outremark", nullable = true, length = 255)
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
    @JoinColumn(name = "o_id", referencedColumnName = "o_id")
    public Orders getOrderss() {
        return orderss;
    }

    public void setOrderss(Orders orderss) {
        this.orderss = orderss;
    }

    @OneToMany(mappedBy = "output")
    public List<Outputxq> getOutputxqs() {
        return outputxqs;
    }

    public void setOutputxqs(List<Outputxq> outputxqs) {
        this.outputxqs = outputxqs;
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
