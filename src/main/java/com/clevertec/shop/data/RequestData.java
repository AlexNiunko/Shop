package com.clevertec.shop.data;

import com.clevertec.shop.entity.ShopItem;
import com.clevertec.shop.warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class RequestData {
    private static final String ORDER = "(\\d{1,}-\\d{1,})";
    private static final String DISCOUNT_CARD = "(card-\\d{4})";
    private List<String> itemsList;
    private String discountCard;

    public RequestData(List<String> shopItemsList) {
        this.itemsList = shopItemsList.stream()
                .filter(o -> o.matches(ORDER))
                .toList();
        String res="";
        for (int i = 0; i < shopItemsList.size(); i++) {
            if (shopItemsList.get(i).matches(DISCOUNT_CARD)){
                res+=shopItemsList.get(i);
            }
        }
        discountCard=res;
    }

    public List<String> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<String> itemsList) {
        this.itemsList = itemsList;
    }

    public String getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(String discountCard) {
        this.discountCard = discountCard;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RequestData.class.getSimpleName() + "[", "]")
                .add("itemsList=" + itemsList)
                .add("discountCard=" + discountCard)
                .toString();
    }
}
