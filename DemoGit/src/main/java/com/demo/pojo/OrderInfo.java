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
@Table(name = "order_info", schema = "jindun")
public class OrderInfo {
    private Integer oiId;
    private Integer coms;
    private BigDecimal comprice;
    private Orders order;
    private SpCommodity com;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oiId=" + oiId +
                ", coms=" + coms +
                ", comprice=" + comprice +
                ", order=" + order +
                ", com=" + com +
                '}';
    }

    @Id
    @Column(name = "oi_id", nullable = false)
    public Integer getOiId() {
        return oiId;
    }

    public void setOiId(Integer oiId) {
        this.oiId = oiId;
    }

    @Basic
    @Column(name = "coms", nullable = true)
    public Integer getComs() {
        return coms;
    }

    public void setComs(Integer coms) {
        this.coms = coms;
    }

    @Basic
    @Column(name = "comprice", nullable = true, precision = 2)
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
    @JoinColumn(name = "o_id", referencedColumnName = "o_id")
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "comid", referencedColumnName = "comid")
    public SpCommodity getCom() {
        return com;
    }

    public void setCom(SpCommodity com) {
        this.com = com;
    }
}
