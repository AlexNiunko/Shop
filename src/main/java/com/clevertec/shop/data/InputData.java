package com.clevertec.shop.data;

import com.clevertec.shop.parser.Parser;
import com.clevertec.shop.parser.impl.DataParser;
import com.clevertec.shop.reader.DiscountFileReader;
import com.clevertec.shop.reader.ProductFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class InputData {
    List <List<String>> ProductFeatures=new ArrayList<>();
    List <List<String>> DiscountFeatures=new ArrayList<>();

    public InputData() {
        Parser dataParser=new DataParser();
        List<String> dataProduct=ProductFileReader.reader();
        List<String> dataDiscount= DiscountFileReader.reader();
        for (String str:dataProduct) {
            ProductFeatures.add(dataParser.parse(str));
        }
        for (String str:dataDiscount) {
            DiscountFeatures.add(dataParser.parse(str));
        }
    }


    public List<List<String>> getProductFeatures() {
        return ProductFeatures;
    }

    public List<List<String>> getDiscountFeatures() {
        return DiscountFeatures;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InputData.class.getSimpleName() + "[", "]")
                .add("ProductFeatures=" + ProductFeatures)
                .add("DiscountFeatures=" + DiscountFeatures)
                .toString();
    }
}
