package com.clevertec.shop.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidator {
    private static final String REQUEST_WITH_DISCOUNT_REGEX = "(java CheckRunner)(\\s{1}(\\d{1,}-\\d{1,})).+(card-\\d{4})";
    private static final String REQUEST_WITHOUT_DISCOUNT_REGEX = "(java CheckRunner)(\\s{1}(\\d{1,}-\\d{1,}))+\\Z";

    public boolean validate(String request) {
        boolean match=false;
        Pattern patternDiscount = Pattern.compile(REQUEST_WITH_DISCOUNT_REGEX);
        Pattern patternWithoutDiscount = Pattern.compile(REQUEST_WITHOUT_DISCOUNT_REGEX);
        Matcher matcherDiscount=patternDiscount.matcher(request);
        Matcher matcherWithoutDiscount=patternWithoutDiscount.matcher(request);
        if  (matcherDiscount.matches() || matcherWithoutDiscount.matches() ){
            match=true;
        }
        return match;
    }
}
