/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej17;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int entrada[] = new int[10];
        for (int i = 0; i < entrada.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            entrada[i] = scan.nextInt();
        }
        System.out.println("Máximo: " + maximo(entrada));
        System.out.println("Mínimo: " + minimo(entrada));
        System.out.println("Promedio: " + promedio(entrada));
    }

    public static int maximo(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int minimo(int a[]) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static float promedio(int a[]) {
        int suma = 0;
        for (int i : a) {
            suma += i;
        }
        return suma / a.length;
    }

}
