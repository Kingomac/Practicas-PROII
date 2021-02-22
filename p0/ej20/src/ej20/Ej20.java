/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej20;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a[] = leerVector(10), b[] = leerVector(10);
        for (int i = 0; i < b.length; i++) {
            System.out.println(a[i] + " + " + b[b.length - i - 1] + " = " + (a[i] + b[b.length - 1 - i]));

        }
    }

    public static float[] leerVector(int n) {
        System.out.println("Introduce un vector de " + n + " elementos");
        Scanner scan = new Scanner(System.in);
        float a[] = new float[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            a[i] = scan.nextFloat();
        }
        return a;
    }
}
