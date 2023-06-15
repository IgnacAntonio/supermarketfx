package com.example.supermarketfx.Classes;

import java.util.Random;

public class Barcode {
    private int barcode;

    public Barcode() {

    }

    public Barcode(int barcode) {
        this.barcode = barcode;
    }

    public void generateBarcode() {
        Random random = new Random();
        int eanCode = random.nextInt(9999999);
        barcode = calcCheckSum(eanCode);
    }

    public int calcCheckSum(int code) {
        int length = String.valueOf(code).length();
        if (length != 7) {
            code += 1000000;
        }
        int sum = 0;
        String codeInString = Integer.toString(code);
        char[] codeInChars = codeInString.toCharArray();
        for (int i = 0; i <= 6; i++) {
            int number = codeInChars[i] - '0';
            sum += (number * (i + 1));
        }
        int checkSum = sum % 11;
        codeInString += Integer.toString(checkSum);
        barcode = Integer.parseInt(codeInString);
        return barcode;
    }

    public boolean checkBarcode() {
        return Integer.toString(this.barcode).length() == 8;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Barcode: " + barcode;
    }
}
