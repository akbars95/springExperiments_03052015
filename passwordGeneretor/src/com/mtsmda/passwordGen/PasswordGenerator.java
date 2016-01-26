package com.mtsmda.passwordGen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MTSMDA on 12.09.2015.
 */
public class PasswordGenerator {

    private static final int DELETE = 0;
    private static final int ADD = 1;

    private boolean isEnglishLettersLower;
    private boolean isEnglishLettersUpper;
    private boolean isNumbers;
    private boolean isRussianLettersLower;
    private boolean isRussianLettersUpper;
    private boolean isSpecialCharacters;

    private int lengthPassword;

    private static List<Character> specialCharacters = new ArrayList<>();

    private List<Character> characters = new ArrayList<>();

    static {
        specialCharacters.add(new Character('#'));
        specialCharacters.add(new Character('$'));
        specialCharacters.add(new Character('%'));
        specialCharacters.add(new Character('&'));
        specialCharacters.add(new Character('*'));
        specialCharacters.add(new Character('+'));
        specialCharacters.add(new Character('-'));
        specialCharacters.add(new Character('/'));
        specialCharacters.add(new Character('.'));
        specialCharacters.add(new Character('!'));
        specialCharacters.add(new Character('?'));
        specialCharacters.add(new Character('@'));
        specialCharacters.add(new Character('^'));
        specialCharacters.add(new Character('~'));
        specialCharacters.add(new Character('|'));
    }

    public PasswordGenerator(int lengthPassword) {
        this.lengthPassword = lengthPassword;
    }

    public String passwordGenerate() throws Exception {
        settings();
        if (characters.isEmpty()) {
            throw new Exception("Error! Not found characters!");
        }
        StringBuilder password = new StringBuilder();
        double limit = characters.size() - 1;
        for(int i = 0; i < lengthPassword; i++){
            int current = (int)(Math.random() * limit);
            if(current <= limit){
                password.append(characters.get(current));
            }
        }
        return password.toString();
    }

    private void settings() throws Exception {
        if(!characters.isEmpty()){
            characters.clear();
        }

        if (isEnglishLettersLower) {
            operationToList(97, 122, ADD);
        } else {
            operationToList(97, 122, DELETE);
        }

        if (isEnglishLettersUpper) {
            operationToList(65, 90, ADD);
        } else {
            operationToList(65, 90, DELETE);
        }

    }
    /*ENGLISH_WORDS_LOWER(97, 122),
    ENGLISH_WORDS_UPPER(65, 90),
    NUMBER(48, 57),
    RUSSIAN_WORDS_LOWER(1072, 1103),
    RUSSIAN_WORDS_UPPER(1040, 1071),
    SPECIAL_CHARACTERS*/;

    private void operationToList(int begin, int end, int operation) {
        if (operation == 0) {
            for (int i = begin; i <= end; i++) {
                characters.remove(new Character((char) i));
            }
        } else if (operation == 1) {
            for (int i = begin; i <= end; i++) {
                characters.add(new Character((char) i));
            }
        }
    }

    public boolean isEnglishLettersLower() {
        return isEnglishLettersLower;
    }

    public void setIsEnglishLettersLower(boolean isEnglishLettersLower) {
        this.isEnglishLettersLower = isEnglishLettersLower;
    }

    public boolean isEnglishLettersUpper() {
        return isEnglishLettersUpper;
    }

    public void setIsEnglishLettersUpper(boolean isEnglishLettersUpper) {
        this.isEnglishLettersUpper = isEnglishLettersUpper;
    }

    public boolean isNumbers() {
        return isNumbers;
    }

    public void setIsNumbers(boolean isNumbers) {
        this.isNumbers = isNumbers;
    }

    public boolean isRussianLettersLower() {
        return isRussianLettersLower;
    }

    public void setIsRussianLettersLower(boolean isRussianLettersLower) {
        this.isRussianLettersLower = isRussianLettersLower;
    }

    public boolean isRussianLettersUpper() {
        return isRussianLettersUpper;
    }

    public void setIsRussianLettersUpper(boolean isRussianLettersUpper) {
        this.isRussianLettersUpper = isRussianLettersUpper;
    }

    public boolean isSpecialCharacters() {
        return isSpecialCharacters;
    }

    public void setIsSpecialCharacters(boolean isSpecialCharacters) {
        this.isSpecialCharacters = isSpecialCharacters;
    }

    public int getLengthPassword() {
        return lengthPassword;
    }

    public void setLengthPassword(int lengthPassword) {
        this.lengthPassword = lengthPassword;
    }

    public static void main(String[] args) {
        /*for(int i = 0; i < 257; i++){
            System.out.println(" i = " + (char)i + "    " + i);
        }*/
        PasswordGenerator passwordGenerator = new PasswordGenerator(25);
        passwordGenerator.setIsEnglishLettersLower(true);
        try {
            System.out.println(passwordGenerator.passwordGenerate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}