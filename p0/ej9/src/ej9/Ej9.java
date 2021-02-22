/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce hasta que número calcular la suma de los N primeros pares");
        int suma = 0;
        for (int a = scan.nextInt(); a > 0; a--) {
            if (a % 2 == 0) {
                suma += a;
            }
        }
        System.out.println("Suma: " + suma);
    }

}
