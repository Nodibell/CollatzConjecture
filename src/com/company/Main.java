package com.company;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void collatzConjecture(BigDecimal number, int odd, int even) {
        if ((number.remainder(BigDecimal.valueOf(2))).equals(BigDecimal.valueOf(0))) {
            ++even;
            number = number.divide(BigDecimal.valueOf(2));
            System.out.println(number);
            collatzConjecture(number, odd, even);
        } else if (number.equals(BigDecimal.valueOf(1))) {
            System.out.print("You are into a loop >4->2->1-\n");
            System.out.println("Odd: " + odd + "; Even: " + even);
        } else {
            ++odd;
            number = number.multiply(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(1));
            System.out.println(number);
            collatzConjecture(number, odd, even);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int even = 0;
        int odd = 0;
        long timeStart;
        while (true) {
            try {
                System.out.print("Type in number from 1+ : ");
                BigDecimal number = scanner.nextBigDecimal();
                if (number.intValue() <= 0) {
                    throw new InputMismatchException();
                }
                timeStart = System.currentTimeMillis();
                collatzConjecture(number, odd, even);
                break;
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.print("Incorrect input!\n");
            } catch (IllegalArgumentException e){
                System.out.println("Too big!");
            }
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println("Time: " + (timeFinish - timeStart) + " мілісекунд.");
    }
}
