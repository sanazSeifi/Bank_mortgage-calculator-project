package com.example.bankmortgage;

import java.text.NumberFormat;

public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void PrintMortgage(int principle, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principle, annualInterest, years);
       double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("-------");
        System.out.println("Monthly Payments " + mortgageFormatted);
        System.out.print("Mortgage :" + mortgageFormatted);
    }

    public static void PrintPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("-------");

        for(short month = 1; month< years * Main.MONTH_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
