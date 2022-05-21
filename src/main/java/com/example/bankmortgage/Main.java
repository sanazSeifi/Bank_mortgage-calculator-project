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

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principle: ");
            principle = scanner.nextInt();
            if (principle >= 1000 && principle < 1_000_000)
                break;
            System.out.println("Enter Value Between 1000 to 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter Value Between 1 to 30");

        }


        while (true) {
            System.out.print("Period (Years) :");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayment = years * MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a Value between 1 and 30");

        }

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
}