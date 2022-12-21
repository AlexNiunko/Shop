package com.clevertec.shop.entity;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class DiscountCard extends ShopItem {

    public DiscountCard(String name, String discountPercentage) {
      this.setName(name);
      this.setDiscountPercentage(discountPercentage);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", DiscountCard.class.getSimpleName() + "[", "]"+ "\n")
                .add("name="+this.getName())
                .add("discountPercentage="+this.getDiscountPercentage())
                .toString();
    }
}
