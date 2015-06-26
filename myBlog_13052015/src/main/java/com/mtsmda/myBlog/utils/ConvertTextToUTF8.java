package com.mtsmda.myBlog.utils;

import org.springframework.util.StringUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by c-DMITMINZ on 5/22/2015.
 */
public class ConvertTextToUTF8 {

    private static final String ENTER = "\n";

    public static String native2Ascii(String s) {
        StringBuffer sb = new StringBuffer();
        char backslash = 92;
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if ((aChar < 0x0020) || (aChar > 0x007e)) {
                sb.append(backslash);
                sb.append('u');
                sb.append(toHex((aChar >> 12) & 0xF));
                sb.append(toHex((aChar >> 8) & 0xF));
                sb.append(toHex((aChar >> 4) & 0xF));
                sb.append(toHex(aChar & 0xF));
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

    private static char toHex(int nibble) {
        final char[] hexDigit =
                {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
                };
        return hexDigit[nibble & 0xF];
    }

    private static BufferedReader readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF8"));
        /*int l = 0;
        while((l = reader.read()) != -1){
            System.out.print((char) l);
        }*/
       /* String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }*/
        return reader;
    }

    private static Properties replaceInProperties(File file) throws IOException {
        Properties properties = new Properties();
        properties.load(readFile(file));

        if (properties.size() < 0) {
            return null;
        }

        Set<Object> objectSet = properties.keySet();
        for (Object o : objectSet) {
            if (o instanceof String) {
                Object objectValue = properties.get(o);
                String value = (String) objectValue;
                if (!StringUtils.isEmpty(value)) {
                    properties.put(o, native2Ascii(value));
                }
            }
        }
        return properties;
    }

    private static boolean writeToPropertiesFile(File file) throws IOException {
        try {
            Properties properties = replaceInProperties(file);
            Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), "UTF8"));
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
            properties.store(writer, "convert " + dateFormat.format(new Date()));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    private static boolean replaceStringErrorEscape(File file){
        StringBuilder replaceTextFromFile = new StringBuilder();
        /*try {
            BufferedReader bufferedReader = readFile(file);
            String currentLine = "";
            while ((currentLine = bufferedReader.readLine()) != null){
                replaceTextFromFile.append(currentLine).append(ENTER);
            }

            String temp = replaceTextFromFile.toString();
            temp = temp.replace("\\u", "\\\\u");
            replaceTextFromFile.delete(0, replaceTextFromFile.length() - 1);
            replaceTextFromFile.append(temp);


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }

    public static boolean convertPropertiesFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }
        boolean result = writeToPropertiesFile(file);
        if(!result){
            return !result;
        }

        return replaceStringErrorEscape(file);
    }

    public static void main(String[] args) {
        /*try {
            System.out.println(convertPropertiesFile("E:\\simple\\j06052015\\springExperiments_03052015\\myBlog_13052015\\src\\main\\resources\\message_ru.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        dateFormatE();

        /*System.out.println((10 > 10));*/

        /*System.out.println(new String("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C"));*/

       /* String text = "C:\\A\\B\\C";
        String newString = text.replace("\\", "/");
        System.out.println(newString);*/

    }

    private static void dateFormatE(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss.S");
        System.out.println(dateFormat.format(gregorianCalendar.getTime()));
    }
}