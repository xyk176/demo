package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname Checks
 * @Date 2020-12-21 14:35
 */
@Entity
public class Checks {
    private int cheid;
    private Timestamp chedate;
    private int chestate;
    private int chebecount;
    private int chelosecoubt;
    private String cheremark;
    private List<Checkxq> checkxqs;

    @Id
    @Column(name = "cheid")
    public int getCheid() {
        return cheid;
    }

    public void setCheid(int cheid) {
        this.cheid = cheid;
    }

    @Basic
    @Column(name = "chedate")
    public Timestamp getChedate() {
        return chedate;
    }

    public void setChedate(Timestamp chedate) {
        this.chedate = chedate;
    }

    @Basic
    @Column(name = "chestate")
    public int getChestate() {
        return chestate;
    }

    public void setChestate(int chestate) {
        this.chestate = chestate;
    }

    @Basic
    @Column(name = "chebecount")
    public int getChebecount() {
        return chebecount;
    }

    public void setChebecount(int chebecount) {
        this.chebecount = chebecount;
    }

    @Basic
    @Column(name = "chelosecoubt")
    public int getChelosecoubt() {
        return chelosecoubt;
    }

    public void setChelosecoubt(int chelosecoubt) {
        this.chelosecoubt = chelosecoubt;
    }

    @Basic
    @Column(name = "cheremark")
    public String getCheremark() {
        return cheremark;
    }

    public void setCheremark(String cheremark) {
        this.cheremark = cheremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checks checks = (Checks) o;
        return cheid == checks.cheid &&
                chestate == checks.chestate &&
                chebecount == checks.chebecount &&
                chelosecoubt == checks.chelosecoubt &&
                Objects.equals(chedate, checks.chedate) &&
                Objects.equals(cheremark, checks.cheremark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cheid, chedate, chestate, chebecount, chelosecoubt, cheremark);
    }

    @OneToMany(mappedBy = "checks")
    public List<Checkxq> getCheckxqs() {
        return checkxqs;
    }

    public void setCheckxqs(List<Checkxq> checkxqs) {
        this.checkxqs = checkxqs;
    }
}
