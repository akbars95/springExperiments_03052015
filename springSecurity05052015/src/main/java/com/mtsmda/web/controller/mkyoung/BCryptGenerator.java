package com.mtsmda.web.controller.mkyoung;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dmitriim on 5/7/2015.
 */
public class BCryptGenerator {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            String password = "123456";
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = bCryptPasswordEncoder.encode(password);
            System.out.println(hashedPassword);
        }
    }

}
