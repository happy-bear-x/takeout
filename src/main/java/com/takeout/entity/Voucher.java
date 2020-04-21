package com.takeout.entity;

import java.util.Date;

public class Voucher {
    private Integer id;

    private String user;

    private Integer worth;

    private Date gettime;

    private Date endtime;

    private Byte isused;

    private Integer condition;

    private String shop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Byte getIsused() {
        return isused;
    }

    public void setIsused(Byte isused) {
        this.isused = isused;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop == null ? null : shop.trim();
    }
}