package com.demo.pojo;

import java.util.List;

/**
 * @author: xieyukun
 * @description: TODO
 * @Classname Inventorylist
 * @Date 2020/12/23 21:04
 */
public class Inventorylist {
    private List<Inventory> inventory;
    private Integer maxcount;

    @Override
    public String toString() {
        return "Inventorylist{" +
                "inventory=" + inventory +
                ", maxcount=" + maxcount +
                '}';
    }

    public Inventorylist(List<Inventory> inventory, Integer maxcount) {
        this.inventory = inventory;
        this.maxcount = maxcount;
    }

    public Integer getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(Integer maxcount) {
        this.maxcount = maxcount;
    }

    public Inventorylist() {
    }

    public Inventorylist(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}
