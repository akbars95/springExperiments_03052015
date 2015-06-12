package com.mtsmda.myBlog;

import com.mtsmda.myBlog.utils.ConvertTextToUTF8;

/**
 * Created by c-DMITMINZ on 6/12/2015.
 */
public class F {

    public static void main(String[] args) {
        String text = "\\\\server\\apps\\file.txt";
        String s = "\\u041C\\\\u0430\\\\u0442\\\\u0435\\\\u0440\\\\u0438\\\\u0430\\\\u043B\\\\u044B";
        System.out.println(s);

        System.out.println("original : " + text);
        System.out.println("converted : " + text.replaceAll("\\\\","\\\\\\\\"));
        for(int i = 0; i < 128; i++){
            System.out.println(i + " - " + (char)i);
            char backslash = 92;
            System.out.println("\n\n" + backslash);
        }
    }

}
