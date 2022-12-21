package com.clevertec.shop.creator.impl;

import com.clevertec.shop.creator.Creator;
import com.clevertec.shop.data.InputData;
import com.clevertec.shop.entity.DiscountCard;
import com.clevertec.shop.entity.ShopItem;
import com.clevertec.shop.entity.ItemFactory;
import com.clevertec.shop.warehouse.Warehouse;

import java.util.List;

public class ShopCreator implements Creator {
    @Override
    public void create(InputData data) {
        ItemFactory factory=new ItemFactory();
        List<List<String>> discountProperties = data.getDiscountFeatures();
        List<List<String>> productProperties = data.getProductFeatures();
        for (List<String> dataList:discountProperties) {
            DiscountCard discount= (DiscountCard) factory.produce(dataList);
            Warehouse.getInstance().addDiscountCard(discount);
        }
        for (List<String> dataList:productProperties) {
            ShopItem product=factory.produce(dataList);
            Warehouse.getInstance().addProduct(product);
        }
    }
}
