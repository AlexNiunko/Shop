package com.clevertec.shop.entity;

import com.clevertec.shop.creator.Creator;
import com.clevertec.shop.creator.impl.ShopCreator;
import com.clevertec.shop.data.InputData;
import com.clevertec.shop.exception.ShopException;
import com.clevertec.shop.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {
    Check check=new Check();
    List<Purchase> purchases=new ArrayList<>();

     {
        Purchase purchase1= null;
        Purchase purchase2= null;
        try {
            purchase1 = new Purchase(1,2);
            purchase2= new Purchase(2,3);
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }
        purchases.add(purchase1);
        purchases.add(purchase2);
    }


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
    void countDiscountPurchases() throws ShopException {
        int expected=2;
        int actual= check.countDiscountPurchases(purchases);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void makeDiscount() throws ShopException {
         Purchase pur=new Purchase(3,1);
         List<Purchase> puchs=new ArrayList<>();
         puchs.add(pur);
         List<Purchase>actual=check.makeDiscount(puchs);
         Purchase pur2=new Purchase(3,1);
         pur2.setTotal("9.0");
         List<Purchase>expected=new ArrayList<>();
         expected.add(pur2);
         Assertions.assertEquals(actual.get(0).getTotal(),expected.get(0).getTotal());

    }

    @Test
    void purchaseCreate() throws ShopException {
         String str="1-3";
         Purchase actual= check.purchaseCreate(str);
         Purchase expected=new Purchase(1,3);
         Assertions.assertEquals(actual.getId(),expected.getId());
         Assertions.assertEquals(actual.getAmount(),expected.getAmount());
    }

    @Test
    void createDiscountByCard() {
         String card="card-1234";
         BigDecimal actual=check.createDiscountByCard(card);
         BigDecimal expected=new BigDecimal("1.0");
         Assertions.assertEquals(actual,expected);
    }
}