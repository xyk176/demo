package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sp_picturetocom", schema = "jindun", catalog = "")
public class SpPicturetocom {
    private int ptcid;
    private int ptciszhu;
    private SpPicture picture;
    private SpCommodity com;
    private SpPicture pic;

    @Id
    @Column(name = "ptcid")
    public int getPtcid() {
        return ptcid;
    }

    public void setPtcid(int ptcid) {
        this.ptcid = ptcid;
    }

    @Basic
    @Column(name = "ptciszhu")
    public int getPtciszhu() {
        return ptciszhu;
    }

    public void setPtciszhu(int ptciszhu) {
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
    @JoinColumn(name = "picid", referencedColumnName = "picid")
    public SpPicture getPicture() {
        return picture;
    }

    public void setPicture(SpPicture picture) {
        this.picture = picture;
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
}
