package com.example.bankmortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main{

    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        int principle = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1 , 30);
        byte years = (byte) readNumber("Period (Years) :" ,1,30);


        PrintMortgage(principle, annualInterest, years);

        PrintPaymentSchedule(principle, annualInterest, years);
    }

    private static void PrintMortgage(int principle, float annualInterest, byte years) {
        double mortgage= calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("-------");
        System.out.println("Monthly Payments " + mortgageFormatted);
        System.out.print("Mortgage :" + mortgageFormatted);
    }

    private static void PrintPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("-------");

        for(short month = 1; month< years * MONTH_IN_YEAR; month++) {
            double balance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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
            System.out.println("Enter Value Between " + min + " and " + max);

        }
        return value;
    }

    public static double calculateBalance(int principle, float annualInterest, byte years, short numberOfPaymentsMade){

        float  numberOfPayment = years * MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        double balance = principle * (Math.pow((1+ monthlyInterest), numberOfPayment)- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                /(Math.pow(1 + monthlyInterest, numberOfPayment)-1);

        return  balance;
    }
}