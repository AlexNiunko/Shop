package com.clevertec.shop.entity;

import com.clevertec.shop.exception.ShopException;
import com.clevertec.shop.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    Purchase purchase=new Purchase();


    @BeforeAll
    static void beforeAll() throws ShopException {
        ShopItem item=new Clothes("1","dress","2.34","true","10");
        ShopItem item1=new Dairy("2","milk","1.12","false","23");
        ShopItem item2=new Fruit("3","orange","10.00","true","58");
        ShopItem card=new DiscountCard("card-2134","20");
        Warehouse.getInstance().addProduct(item);
        Warehouse.getInstance().addProduct(item1);
        Warehouse.getInstance().addProduct(item2);
        Warehouse.getInstance().addProduct(card);

    }
    @Test
    void isExist() {
        int id=1;
        int amonut=2;
        boolean expected=true;
        boolean actual= purchase.isExist(id,amonut);
        Assertions.assertEquals(expected,actual);
    }


}