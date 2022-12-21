package com.clevertec.shop.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiscountFileReader {
    private static final String PATH="data\\discount.txt";

    public static List<String> reader(){
        String stringLines="";
        List<String>stringList=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(PATH))) {
            while ( (stringLines=reader.readLine())!=null){
                stringList.add(stringLines+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }


}
