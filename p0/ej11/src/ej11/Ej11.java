/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej11;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("Introduce un número hasta el que mostrar la sucesión de Fibonacci");
        Scanner scan = new Scanner(System.in);
        int n = 50;
        //int n = scan.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.print(fibonacci(i) + ", ");
//        }
        efficientFibonacci(n);
        long finishTime = System.nanoTime();
        double elapsed = (finishTime - startTime);
        System.out.println("############################");
        System.out.println("Tiempo de ejecución: " + elapsed);
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // No recursivo es mejor
    public static void efficientFibonacci(int n) {
        long a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + ", ");
        }
    }

}
