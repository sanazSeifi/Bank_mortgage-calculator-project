package com.example.bankmortgage;

import java.util.Scanner;

public class console {
    private static Scanner scanner = new Scanner(System.in);
    public static double readNumber(String prompt, double min, double max) {
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
    public static double readNumber(String prompt){
        return scanner.nextDouble();
    }
}
