package com.example.bankmortgage;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principle: ");
        int principle = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest/PERCENT/MONTH_IN_YEAR;
        System.out.println(monthlyInterest);

        System.out.print("Period (Years) :");
        int years = scanner.nextInt();
        int numberOfPayment = years * MONTH_IN_YEAR;

        double mortgage = principle * (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayment))/
                (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage :" + mortgageFormatted);

    }
}