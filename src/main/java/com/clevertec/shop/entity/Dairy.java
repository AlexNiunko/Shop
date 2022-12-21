package com.clevertec.shop.entity;

import java.util.StringJoiner;

public class Dairy extends ShopItem {

    public Dairy( String id,String name, String price, String ifDiscount,String amount) {
        this.setId(Integer.parseInt(id));
        this.setName(name);
        this.setPrice(price);
        this.setIfDiscount(Boolean.valueOf(ifDiscount));
        this.setAmount(Integer.parseInt(amount));
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Dairy.class.getSimpleName() + "[", "]" +"\n")
                .add("ID="+this.getId())
                .add("name="+this.getName())
                .add("price="+this.getPrice())
                .add("ifDiscount="+this.getIfDiscount())
                .add("amount="+this.getAmount())
                .toString();
    }

}
