package com.takeout.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String ordernum;

    private String user;

    private String shop;

    private Integer foodid;

    private Integer num;

    private Integer voucher;

    private BigDecimal pay;

    private String total;

    private Boolean state;

    private Integer addressid;

    private Date finishtime;

    private String uaddition;

    private String saddition;

    private String toking;

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop == null ? null : shop.trim();
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getVoucher() {
        return voucher;
    }

    public void setVoucher(Integer voucher) {
        this.voucher = voucher;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public String getUaddition() {
        return uaddition;
    }

    public void setUaddition(String uaddition) {
        this.uaddition = uaddition == null ? null : uaddition.trim();
    }

    public String getSaddition() {
        return saddition;
    }

    public void setSaddition(String saddition) {
        this.saddition = saddition == null ? null : saddition.trim();
    }

    public String getToking() {
        return toking;
    }

    public void setToking(String toking) {
        this.toking = toking == null ? null : toking.trim();
    }
}