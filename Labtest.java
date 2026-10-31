package com.mycompany.labtest;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MAINFINAL {

    static final Scanner sc = new Scanner(System.in);
    static final Random rand = new Random();

    public static void main(String[] args) {
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        extra1();
        extra2();
        labQuest();
    }

    // Question 1: simple calculator
    static void question1() {
        System.out.print("Enter two integer number: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print("Enter the operand: ");
        char op = sc.next().charAt(0);

        if ((op == '/' || op == '%') && b == 0) {
            System.out.println("Cannot divide by zero");
            return;
        }
        int result;
        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
            case '%': result = a % b; break;
            default:
                System.out.println("Not in the list");
                return;
        }
        System.out.printf("%d %c %d = %d%n", a, op, b, result);
    }

    // Question 2: random number 0-5 as a word
    static void question2() {
        String[] words = {"zero", "one", "two", "three", "four", "five"};
        int n = rand.nextInt(0, 6);
        System.out.printf("%d is %s%n", n, words[n]);
    }

    // Question 3: sales commission
    static void question3() {
        System.out.print("Input your sales: ");
        int sales = sc.nextInt();
        double rate;
        if (sales <= 100) rate = 0.05;
        else if (sales <= 500) rate = 0.075;
        else if (sales <= 1000) rate = 0.1;
        else rate = 0.125;
        System.out.printf("Final commission is %.2f%n", sales * rate);
    }

    // Question 4: two players
    static void question4() {
        // Part A: random scores 2-12, higher score wins
        int p1 = (int) (Math.random() * 11 + 2);
        int p2 = (int) (Math.random() * 11 + 2);
        System.out.printf("Player 1: %d, Player 2: %d%n", p1, p2);
        if (p1 > p2) System.out.println("Player 1 wins");
        else if (p1 < p2) System.out.println("Player 2 wins");
        else System.out.println("Tie");

        // Part B: each player rolls two dice and keeps the larger one
        int max1 = Math.max(rand.nextInt(6) + 1, rand.nextInt(6) + 1);
        int max2 = Math.max(rand.nextInt(6) + 1, rand.nextInt(6) + 1);
        System.out.println("Player 1 result: " + max1);
        System.out.println("Player 2 result: " + max2);
        if (max1 > max2) System.out.println("Player 1 Wins");
        else if (max1 < max2) System.out.println("Player 2 Wins");
        else System.out.println("Tie");
    }

    // Question 5: solve ax + by = e, cx + dy = f (integer input)
    static void question5() {
        int[] v = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.printf("Enter %c: ", 'a' + i);
            v[i] = sc.nextInt();
        }
        int a = v[0], b = v[1], c = v[2], d = v[3], e = v[4], f = v[5];
        int den = a * d - b * c;
        if (den == 0) {
            System.out.println("The equation has no solution");
        } else {
            double x = (e * d - b * f) / (double) den;
            double y = (a * f - e * c) / (double) den;
            System.out.printf("x is %f, y is %f%n", x, y);
        }
    }

    // Question 6: is the point inside the circle centred at (0,0)?
    static void question6() {
        System.out.print("Enter radius: ");
        int radius = sc.nextInt();
        System.out.print("Enter coordX: ");
        int x = sc.nextInt();
        System.out.print("Enter coordY: ");
        int y = sc.nextInt();
        boolean inside = x * x + y * y <= radius * radius;
        System.out.println(inside
                ? "Yes, inside the circle centred at (0,0)"
                : "No, not inside the circle centred at (0,0)");
    }

    // Extra Question 1: calculator with doubles (switch expression)
    static void extra1() {
        System.out.print("Enter two number: ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        System.out.print("Enter the operator: ");
        char op = sc.next().charAt(0);
        double result = switch (op) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            case '%' -> n1 % n2;
            default -> 0;
        };
        System.out.printf("%f %c %f is %f%n", n1, op, n2, result);
    }

    // Extra Question 2: Cramer's rule with doubles
    static void extra2() {
        System.out.println("""
                Cramer's rule:
                    ax + by = e, cx + dy = f
                    x = (ed - bf) / (ad - bc)
                    y = (af - ec) / (ad - bc)
                """);
        double[] v = new double[6];
        for (int i = 0; i < 6; i++) {
            System.out.printf("Enter the value of %c : ", 'a' + i);
            v[i] = sc.nextDouble();
        }
        double a = v[0], b = v[1], c = v[2], d = v[3], e = v[4], f = v[5];
        double den = a * d - b * c;
        if (Math.abs(den) < 1e-10) {
            System.out.println("no solution");
        } else {
            System.out.printf("x = %f, y = %f%n",
                    (e * d - b * f) / den,
                    (a * f - e * c) / den);
        }
    }

    // Lab Quest: valid boomerang (3 distinct points, not on one line)
    static void labQuest() {
        int[][] p = new int[3][2];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 2; j++)
                p[i][j] = rand.nextInt(0, 101);

        System.out.println("points = " + Arrays.deepToString(p));
        boolean boomerang =
                (p[1][0] - p[0][0]) * (p[2][1] - p[0][1])
                != (p[2][0] - p[0][0]) * (p[1][1] - p[0][1]);
        System.out.println(boomerang);
    }
}