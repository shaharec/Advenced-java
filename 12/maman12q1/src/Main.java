package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Polynom p1,p2;
        System.out.println("-------Enter first polynom------");
        p1 = inputPolynom();
        System.out.println("-------Enter second polynom------");
        p2 = inputPolynom();
        // Show polynom
        System.out.println("p1:\n"+p1);
        System.out.println("p2:\n"+p2);
        // Show polynom derivative
        System.out.println("P1 derivative:");
        printDerivative(p1);
        // Show polynom derivative
        System.out.println("P2 derivative:");
        printDerivative(p2);
        // Show polynom sum
        printSum(p1,p2);
        // Show polynom sum
        printMinus(p1,p2);
        // Check if equals
        printEquals(p1,p2);
    }

    // print if p1 is equal to p2
    private static void printEquals(Polynom p1, Polynom p2) {
        if(p1.equals(p2))
            System.out.println("The polynoms are equals!");
        else
            System.out.println("The polynoms are NOT equals!");
    }

    // Preform minus operation between two polinoms and print the result.
    private static void printMinus(Polynom p1, Polynom p2) throws Exception {
        System.out.println("Minus operation p1-p2:");
        System.out.println(p1.minus(p2));
    }
    // Preform plus operation between two polinoms and print the result.
    private static void printSum(Polynom p1, Polynom p2) throws Exception {
        System.out.println("Plus operation p1+p2:");
        System.out.println(p1.plus(p2));
    }

    // Print polynom derivative.
    private static void printDerivative(Polynom p1) {

        System.out.println(p1.derivative());
    }

    // input polynom from user.
    private static Polynom inputPolynom() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of element in the polynom");
        int num_elem = sc.nextInt();
        double [] coef = new double[num_elem];
        int [] power = new int[num_elem];
        System.out.println("Enter polynom in the form of coeficent and the power each time.");
        for(int i=0;i<num_elem;i++){
            coef[i] = sc.nextDouble();
            power[i] = sc.nextInt();
        }
        return new Polynom(coef,power);

    }
}
