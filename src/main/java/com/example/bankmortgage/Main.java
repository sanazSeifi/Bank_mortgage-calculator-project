package com.example.bankmortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principle;
        float annualInterest = 0;
        byte years=0;
        float  numberOfPayment = years * MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;


        principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        annualInterest = (float) readNumber("Annual Interest Rate: ", 1 , 30);
        years = (byte) readNumber("Period (Years) :" ,1,30);



        double mortgage= calculateMortgage(principle,annualInterest,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage :" + mortgageFormatted);

    }

    public static double calculateMortgage(int principle, float annualInterest, byte years){

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        float  numberOfPayment = years * MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        double mortgage = principle * (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayment))/
                (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return mortgage;

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter Value Between" + min + "and" + max);

        }
    }
}