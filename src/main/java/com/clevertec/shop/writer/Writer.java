package com.clevertec.shop.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    public void write(String str) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("data\\result.txt")))) {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
