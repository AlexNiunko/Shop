package com.clevertec.shop.reader;

import java.util.Scanner;

public class ConsoleReader {
    public String readFromConsole(){
        String str;
        try(Scanner scanner=new Scanner(System.in)){
            str=scanner.nextLine();
        }
        return str;
    }
}
