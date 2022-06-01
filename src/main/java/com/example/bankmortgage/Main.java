package com.example.bankmortgage;

public class Main{

    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        int principle = (int) console.readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) console.readNumber("Annual Interest Rate: ", 1 , 30);
        byte years = (byte) console.readNumber("Period (Years) :" ,1,30);


        MortgageReport.PrintMortgage(principle, annualInterest, years);

        MortgageReport.PrintPaymentSchedule(principle, annualInterest, years);
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

    public static double calculateBalance(int principle, float annualInterest, byte years, short numberOfPaymentsMade){

        float  numberOfPayment = years * MONTH_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        double balance = principle * (Math.pow((1+ monthlyInterest), numberOfPayment)- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                /(Math.pow(1 + monthlyInterest, numberOfPayment)-1);

        return  balance;
    }
}