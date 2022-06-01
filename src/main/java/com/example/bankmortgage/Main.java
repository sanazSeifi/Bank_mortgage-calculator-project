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

}