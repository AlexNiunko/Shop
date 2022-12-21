package com.clevertec.shop.parser.impl;

import com.clevertec.shop.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RequestParser implements Parser {
    private static final String DELIMETER = "\\s+";
    @Override
    public List<String> parse(String request) {
        List<String> result;
        result = Arrays.stream(request.split(DELIMETER)).toList();
        return result;

    }
}
