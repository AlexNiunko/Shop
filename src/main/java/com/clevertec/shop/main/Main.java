package com.clevertec.shop.main;

import com.clevertec.shop.creator.Creator;
import com.clevertec.shop.creator.impl.ShopCreator;
import com.clevertec.shop.data.InputData;
import com.clevertec.shop.data.RequestData;
import com.clevertec.shop.entity.Check;
import com.clevertec.shop.entity.Purchase;
import com.clevertec.shop.exception.ShopException;
import com.clevertec.shop.parser.impl.RequestParser;
import com.clevertec.shop.reader.ConsoleReader;
import com.clevertec.shop.validator.RequestValidator;
import com.clevertec.shop.warehouse.Warehouse;
import com.clevertec.shop.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ShopException {
        InputData data = new InputData();
        Creator shopCreator = new ShopCreator();
        shopCreator.create(data);
        ConsoleReader reader = new ConsoleReader();
        RequestParser parser = new RequestParser();
        RequestValidator validator = new RequestValidator();
        String res = reader.readFromConsole();
        if (validator.validate(res)) {
            List<String>request=parser.parse(res);
            RequestData requestData=new RequestData(request);
            Check check=new Check(requestData);
            Writer writer=new Writer();
            writer.write(check.toString());
        } else {
            throw new ShopException("Incorrect input");
        }
    }
}



