package com.clevertec.shop.entity;

import java.math.BigDecimal;

public abstract class ShopItem {
    private String name;
    private BigDecimal price;
    private Boolean ifDiscount;
    private int id;
    private int amount;
    private int discountPercentage;

    public ShopItem() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price.toString();
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public Boolean getIfDiscount() {
        return ifDiscount;
    }

    public void setIfDiscount(Boolean ifDiscount) {
        this.ifDiscount = ifDiscount;
    }

    public int getId() {
        return id;
    }

    public String getDiscountPercentage() {
        return Integer.toString(discountPercentage);
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = Integer.parseInt(discountPercentage);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String print() {
        return this.toString();
    }
}
