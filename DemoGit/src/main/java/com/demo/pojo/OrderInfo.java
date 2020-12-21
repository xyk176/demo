package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author: hujingjing
 * @description: TODO
 * @Classname OrderInfo
 * @Date 2020-12-21 14:06
 */
@Entity
@Table(name = "order_info", schema = "jindun", catalog = "")
public class OrderInfo {
    private int oiId;
    private int coms;
    private BigDecimal comprice;
    private SpCommodity com;
    private Orders order;

    @Id
    @Column(name = "oi_id")
    public int getOiId() {
        return oiId;
    }

    public void setOiId(int oiId) {
        this.oiId = oiId;
    }

    @Basic
    @Id
    @Column(name = "coms")
    public int getComs() {
        return coms;
    }

    public void setComs(Integer coms) {
        this.coms = coms;
    }

    public void setComs(int coms) {
        this.coms = coms;
    }

    @Basic
    @Id
    @Column(name = "comprice")
    public BigDecimal getComprice() {
        return comprice;
    }

    public void setComprice(BigDecimal comprice) {
        this.comprice = comprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return oiId == orderInfo.oiId &&
                coms == orderInfo.coms &&
                Objects.equals(comprice, orderInfo.comprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oiId, coms, comprice);
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
    @JoinColumn(name = "o_id", referencedColumnName = "o_id")
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
