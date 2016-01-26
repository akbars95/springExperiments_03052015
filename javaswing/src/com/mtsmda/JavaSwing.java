package com.mtsmda;

import javax.swing.*;

/**
 * Created by MTSMDA on 16.07.2015.
 */
public class JavaSwing {

    public JavaSwing() {
        JFrame frame = new JFrame("Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaSwing();
            }
        });
    }

}