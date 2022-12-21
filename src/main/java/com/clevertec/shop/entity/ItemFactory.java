package com.clevertec.shop.entity;

import java.util.List;

public class ItemFactory {

    public ItemFactory() {

    }

    public ShopItem produce(List<String> data){
        ShopItem shopItem=null;
        String type= data.get(0);
        switch (type){
            case "fruit" -> shopItem=new Fruit(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
            case "clothes" ->shopItem=new Clothes(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
            case "dairy"-> shopItem=new Dairy(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
            case "discount"-> shopItem=new DiscountCard(data.get(1), data.get(2));
            default -> System.out.println("wrong product type");
        }
        return shopItem;
    }
}
