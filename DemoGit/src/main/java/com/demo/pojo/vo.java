package com.demo.pojo;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname vo
 * @Date 2020-12-22 8:54
 */
public class vo {
    private Integer lid;
    private String lname;
    private String lguige;
    private String ldanwei;
    private Integer ltiaoma;
    private Integer lchengben;
    private Integer cid;
    private Integer cid2;
    private String cname;
    private String cfid;
    private String picpath;

    @Override
    public String toString() {
        return "vo{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", lguige='" + lguige + '\'' +
                ", ldanwei='" + ldanwei + '\'' +
                ", ltiaoma=" + ltiaoma +
                ", lchengben=" + lchengben +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cfid='" + cfid + '\'' +
                ", picpath='" + picpath + '\'' +
                '}';
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public Integer getCid2() {
        return cid2;
    }

    public void setCid2(Integer cid2) {
        this.cid2 = cid2;
    }



    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLguige() {
        return lguige;
    }

    public void setLguige(String lguige) {
        this.lguige = lguige;
    }

    public String getLdanwei() {
        return ldanwei;
    }

    public void setLdanwei(String ldanwei) {
        this.ldanwei = ldanwei;
    }

    public Integer getLtiaoma() {
        return ltiaoma;
    }

    public void setLtiaoma(Integer ltiaoma) {
        this.ltiaoma = ltiaoma;
    }

    public Integer getLchengben() {
        return lchengben;
    }

    public void setLchengben(Integer lchengben) {
        this.lchengben = lchengben;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCfid() {
        return cfid;
    }

    public void setCfid(String cfid) {
        this.cfid = cfid;
    }
}
