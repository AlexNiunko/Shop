package com.clevertec.shop.warehouse;

import com.clevertec.shop.entity.DiscountCard;
import com.clevertec.shop.entity.ShopItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Warehouse {

    private List<ShopItem>productList;
    private List<ShopItem>discountCardList;
    private static Warehouse instance;

    private Warehouse() {
        productList=new ArrayList<>();
        discountCardList=new ArrayList<>();
    }

    public static Warehouse getInstance() {
        if (instance==null){
            instance=new Warehouse();
        }
        return instance;
    }

    public boolean addProduct(ShopItem product) {
        return productList.add(product);
    }

    public boolean remove(ShopItem product) {
        return productList.remove(product);
    }

    public boolean addDiscountCard(DiscountCard discountCard) {
        return discountCardList.add(discountCard);
    }

    public boolean remove(Object o) {
        return discountCardList.remove(o);
    }

    public Optional<ShopItem> getItemById(int id) {
        Optional<ShopItem> item;
        item=productList.stream()
                .filter(o->o.getId()==id)
                .findFirst();
        return item;
    }

    public Optional<ShopItem> getDiscountCardByName(String nameDisc) {
        Optional<ShopItem> item;
        item=discountCardList.stream()
                .filter(o->o.getName().equals(nameDisc))
                .findFirst();
        return item;
    }

    public int getItemAmountById(int id) {
        int amount=0;
        Optional<ShopItem> item;
        item=productList.stream()
                .filter(o->o.getId()==id)
                .findFirst();
        if (item.isEmpty()){
            return amount;
        }
        amount=item.get().getAmount();
        return amount;
    }


    public List<ShopItem> getDiscountCardList() {
        return discountCardList;
    }

    public List<ShopItem> getProductList() {
        return productList;
    }

    public boolean contains(ShopItem item) {
        return productList.contains(item);
    }
}
