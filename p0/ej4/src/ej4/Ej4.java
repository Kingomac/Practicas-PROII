/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int a = scan.nextInt();
        if (a % 2 == 0) {
            System.out.println("Número par");
        } else {
            System.out.println("Número impar");
        }
        System.out.println("Número " + ((a == 0) ? "cero" : "distinto de 0"));
        System.out.println("Número " + ((a > 100) ? "elevado" : "bajo"));
    }

}
