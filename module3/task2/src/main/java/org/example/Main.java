package org.example;

import com.google.common.base.Strings;

public class Main {
    public static void main(String[] args) {
        String text1 = null;
        String text2 = "";
        String text3 = "Hello, Guava!";

        System.out.println(Strings.isNullOrEmpty(text1));
        System.out.println(Strings.isNullOrEmpty(text2));
        System.out.println(Strings.isNullOrEmpty(text3));
    }
}