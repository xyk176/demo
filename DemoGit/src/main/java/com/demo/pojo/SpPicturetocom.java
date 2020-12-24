package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sp_picturetocom", schema = "jindun", catalog = "")
public class SpPicturetocom {
    private Integer ptcid;
    private Integer ptciszhu;
    private SpCommodity com;
    private SpPicture pic;

    @Id
    @Column(name = "ptcid")
    public Integer getPtcid() {
        return ptcid;
    }

    public void setPtcid(Integer ptcid) {
        this.ptcid = ptcid;
    }

    @Basic
    @Column(name = "ptciszhu")
    public Integer getPtciszhu() {
        return ptciszhu;
    }

    public void setPtciszhu(Integer ptciszhu) {
        this.ptciszhu = ptciszhu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpPicturetocom that = (SpPicturetocom) o;
        return ptcid == that.ptcid &&
                ptciszhu == that.ptciszhu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ptcid, ptciszhu);
    }

    @ManyToOne
    @JoinColumn(name = "comid", referencedColumnName = "comid")
    public SpCommodity getCom() {
        return com;
    }

    public void setCom(SpCommodity com) {
        this.com = com;
    }

    @ManyToOne
    @JoinColumn(name = "picid", referencedColumnName = "picid")
    public SpPicture getPic() {
        return pic;
    }

    public void setPic(SpPicture pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "SpPicturetocom{" +
                "ptcid=" + ptcid +
                ", ptciszhu=" + ptciszhu +
                ", pic=" + pic +
                '}';
    }
}
