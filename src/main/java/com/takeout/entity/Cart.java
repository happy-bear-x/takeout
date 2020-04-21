package com.takeout.entity;

public class Cart {
    private String user;

    private String shop;

    private Integer foodid;

    private Integer num;

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
}