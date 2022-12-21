package com.clevertec.shop.entity;

import com.clevertec.shop.exception.ShopException;
import com.clevertec.shop.warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.StringJoiner;

public class Purchase extends ShopItem {

    private BigDecimal total;

    public Purchase(int id, int amount) throws ShopException {
        if (!(isExist(id, amount))) {
            throw new ShopException("Please change your request");
        } else {
            Optional<ShopItem> item = Warehouse.getInstance().getItemById(id);
            this.setId(id);
            this.setName(item.get().getName());
            this.setPrice(item.get().getPrice());
            this.setAmount(amount);
            this.setIfDiscount(item.get().getIfDiscount());
            BigDecimal price = new BigDecimal(item.get().getPrice());
            total = price.multiply(BigDecimal.valueOf(amount));
        }
    }

    public Purchase( ) {
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = new BigDecimal(total);
    }

    boolean isExist(int id, int amount) {
        boolean match = true;
        String msg = "";
        Optional<ShopItem> item = Warehouse.getInstance().getItemById(id);
        int itemAmount = Warehouse.getInstance().getItemAmountById(id);
        if (item.isEmpty()) {
            msg += "This item is not available";
            match = false;
        } else if (amount > itemAmount) {
            msg += "Unable to supply specified quantity of this product";
            match = false;
        } else {
            match = true;
        }
        System.out.println(msg);
        return match;
    }

    @Override
    public String toString() {
        return new StringJoiner("  ", "", "")
                .add("ID-" + this.getId())
                .add("Name-" + this.getName())
                .add("Price-" + this.getPrice())
                .add("Discount=" + this.getIfDiscount())
                .add("Total=" + this.total.toString())

                .toString();
    }

}
