package com.clevertec.shop.entity;

import com.clevertec.shop.data.RequestData;
import com.clevertec.shop.exception.ShopException;
import com.clevertec.shop.warehouse.Warehouse;

import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Check {
    public static final String SPACE_DELIMETER = "-";
    private List<Purchase> purchases;
    private int countIfDiscount;
    private BigDecimal discountByCard;
    private BigDecimal checkPrice;
    private BigDecimal checkPriceWithDiscountCard;
    private BigDecimal discountAmount;

    public Check(RequestData requestData) {
        this.purchases= requestData.getItemsList().stream()
                .map(o-> {try {
                        return purchaseCreate(o);
                      } catch (ShopException e) {
                          throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        this.discountByCard=createDiscountByCard(requestData.getDiscountCard());
        this.countIfDiscount=countDiscountPurchases(purchases);
        if (countIfDiscount>=5){
          this.setPurchases(makeDiscount(this.purchases));
        }
        checkPrice=purchases.stream()
                .map(o->o.getTotal())
                .reduce(BigDecimal.valueOf(0),(x, y)->x.add(y));
        checkPriceWithDiscountCard=checkPrice.multiply(discountByCard).setScale(2,RoundingMode.HALF_UP);
        discountAmount=checkPrice.subtract(checkPriceWithDiscountCard);
    }

    public Check() {

    }

    public int countDiscountPurchases(List<Purchase> list){
        int count=0;
        List<Purchase>itemExist=list.stream()
                .filter(o-> o.getIfDiscount()==true)
                .collect(Collectors.toList());
        for (Purchase  items:itemExist) {
            count+= items.getAmount();
        }
        return count;
    }
     public List<Purchase> makeDiscount(List<Purchase>list){
        for (Purchase item:list) {
            if (item.getIfDiscount()==true) {
                item.setTotal(String.valueOf(item.getTotal().multiply(new BigDecimal("0.9")).setScale(1, RoundingMode.HALF_UP)));
            }
        }
        return list;
    }
     public Purchase purchaseCreate(String str) throws ShopException {
        List<String> result;
        result = Arrays.stream(str.split(SPACE_DELIMETER)).toList();
        int id=Integer.parseInt(result.get(0));
        int amount=Integer.parseInt(result.get(1));
        Purchase purchase=new Purchase(id,amount);
        return purchase;
    }
     public BigDecimal createDiscountByCard(String str){
        BigDecimal purchase;
        if ( (Warehouse.getInstance().getDiscountCardByName(str)).isEmpty() ){
            purchase=new BigDecimal("1.00");
        } else {
            BigDecimal temp=new BigDecimal(Warehouse.getInstance().getDiscountCardByName(str).get().getDiscountPercentage());
            BigDecimal item=new BigDecimal("100");
            purchase=item.subtract(temp).divide(new BigDecimal("100")).setScale(1);
        }
       return purchase.setScale(1);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        String str="";
        for (Purchase item:purchases) {
            str+= item.toString()+"\n";
        }
        return new StringJoiner("",  ""+ "\n", "")
                .add(Check.class.getSimpleName()+"\n")
                .add(str)
                .add("Number of discounted purchases=" +countIfDiscount+"\n")
                .add("Total price="+checkPrice+"\n")
                .add("Total price with discountCard="+checkPriceWithDiscountCard+"\n")
                .add("Discount amount="+discountAmount)
                .toString();
    }
}
