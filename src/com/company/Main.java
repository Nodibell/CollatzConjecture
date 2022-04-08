package com.company;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void collatzConjecture(BigInteger number, int odd, int even) {
        if ((number.remainder(BigInteger.valueOf(2))).equals(BigInteger.valueOf(0))) {
            ++even;
            number = number.divide(BigInteger.valueOf(2));
            System.out.println(number);
            collatzConjecture(number, odd, even);
        } else if (number.equals(BigInteger.valueOf(1))) {
            System.out.print("You are into a loop >4->2->1-\n");
            System.out.println("Odd: " + odd + "; Even: " + even);
        } else {
            ++odd;
            number = number.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
            System.out.println(number);
            collatzConjecture(number, odd, even);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int even = 0;
        int odd = 0;

        while (true) {
            try {
                System.out.print("Type in number from 1+ : ");
                BigInteger number = scanner.nextBigInteger();
                if (number.intValue() <= 0) {
                    throw new IllegalArgumentException();
                }
                collatzConjecture(number, odd, even);
                break;
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.print("Incorrect input!\n");
            }
        }
    }
}
