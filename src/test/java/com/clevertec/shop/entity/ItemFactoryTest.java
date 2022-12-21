package com.clevertec.shop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    List<String> strings=new ArrayList<>();
    ItemFactory factory=new ItemFactory();
      String str0="fruit";
      String str="1";
      String str1="apple";
      String str2="2.3";
      String str3="true";
      String str4="3";
    {
        strings.add(str0);
        strings.add(str);
        strings.add(str1);
        strings.add(str2);
        strings.add(str3);
        strings.add(str4);
    }

    @Test
    void produce() {
        ShopItem expected=new Fruit("1","apple","2.3","true","3");
        ShopItem actual=factory.produce(strings);
        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.getIfDiscount(),actual.getIfDiscount());
        Assertions.assertEquals(expected.getAmount(),actual.getAmount());
    }
}