package com.example.bankmortgage;

public class MortgageCalculator {
    public static double calculateMortgage(int principle, float annualInterest, byte years){

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        float  numberOfPayment = years * MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        double mortgage = principle * (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayment))/
                (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return mortgage;

    }

    public static double calculateBalance(int principle, float annualInterest, byte years, short numberOfPaymentsMade){

        float  numberOfPayment = years * Main.MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTH_IN_YEAR;

        double balance = principle * (Math.pow((1+ monthlyInterest), numberOfPayment)- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                /(Math.pow(1 + monthlyInterest, numberOfPayment)-1);

        return  balance;
    }
}
