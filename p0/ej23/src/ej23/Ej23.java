/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej23;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la longitud de las matrices a usar: ");
        int n = scan.nextInt();
        int[][] a = generar(n);
        int[][] b = generar(n);
        System.out.println("Matriz A:");
        visualizar(a);
        System.out.println("Matriz B:");
        visualizar(b);
        System.out.println("A+B");
        visualizar(suma(a, b));
    }

    public static int[][] generar(int n) {
        int[][] m = new int[n][n];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = j = r.nextInt(10);
            }
        }
        return m;
    }

    public static int[][] suma(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[0].length; j++) {
                r[i][j] = a[i][j] + b[i][j];
            }
        }
        return r;
    }

    public static void visualizar(int[][] m) {
        for (int[] i : m) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

}
