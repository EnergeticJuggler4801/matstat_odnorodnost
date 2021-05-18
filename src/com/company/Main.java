package com.company;


import java.util.Scanner;
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.*;

public class Main {

    public static void fill(double[] a) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 25; i++) {
            a[i] = in.nextDouble();
        }
    }
    public static void print(double[] a) {
        for (int i = 0; i < 25; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println("\n");
            }
            System.out.print(a[i] + " ");
        }
    }
    public static double sum(double[] a) {
        double sum=0;
        for (int i = 0; i < 25; i++) {
            sum = sum + a[i];
        }
        return sum;
    }
    public static double sumSquare(double[] a) {
        double sumSquare=0;
        for (int i = 0; i < 25; i++) {
            sumSquare = sumSquare + a[i] * a[i];
        }
        return sumSquare;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] numbers1 = new double[25];
        double[] numbers2 = new double[25];

        System.out.println("Enter numbers 1:");
        fill(numbers1);
        System.out.println("Enter numbers 2:");
        fill(numbers2);
        System.out.println("Numbers 1: ");
        print(numbers1);
        System.out.println("\nNumbers 2: ");
        print(numbers2);

        double sum = sum(numbers1);
        double sumSquare = sumSquare(numbers1);

        double average1 = sum / 25;
        double unfixed1 = (sumSquare / 25) - (average1 * average1);
        double fixed1 = 25 * unfixed1 / 24;

        System.out.println("\n\naverage 1: " + average1);
        System.out.println("unfixed dispersion 1: " + unfixed1);
        System.out.println("fixed dispersion 1: " + fixed1);

        sum = sum(numbers2);
        sumSquare = sumSquare(numbers2);

        double average2 = sum / 25;
        double unfixed2 = (sumSquare / 25) - (average2 * average2);
        double fixed2 = 25 * unfixed2 / 24;

        System.out.println("\naverage 2: " + average2);
        System.out.println("unfixed dispersion 2: " + unfixed2);
        System.out.println("fixed dispersion 2: " + fixed2);

        double ro;
        double alpha;
        System.out.println("Enter alpha: ");
        alpha = in.nextDouble();
        if (fixed1 > fixed2) {
            ro = fixed1 / fixed2;
        } else {
            ro = fixed2 / fixed1;
        }
        System.out.println("ro_f = " + ro);
        if (ro < alpha) {
            System.out.println("H0!");
        } else {
            System.out.println("H1!");
        }
        if (average1 > average2) {
            ro = ((average1 - average2) / Math.sqrt(24 * fixed1 + 24 * fixed2)) * Math.sqrt(25 * 25 * 48 / 50);
        } else {
            ro = ((average2 - average1) / Math.sqrt(24 * fixed1 + 24 * fixed2)) * Math.sqrt(25 * 25 * 48 / 50);
        }
        System.out.println("Enter alpha: ");
        alpha = in.nextDouble();
        System.out.println("ro_t = " + ro);
        if (ro < alpha) {
            System.out.println("H0!");
        } else {
            System.out.println("H1!");
        }
    }
}

