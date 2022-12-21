package com.clevertec.shop.parser.impl;

import com.clevertec.shop.parser.Parser;

import java.util.Arrays;
import java.util.List;

public class DataParser implements Parser {
    public static final String SPACE_DELIMETER = "\\s+";
    @Override
    public  List<String> parse(String productFeatures) {
        List<String> result ;
        result = Arrays.stream(productFeatures.split(SPACE_DELIMETER)).toList();
        return result;
    }
}
