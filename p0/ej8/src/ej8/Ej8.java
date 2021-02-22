/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej8;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un número para mostrar su tabla de multiplicar");
        int a = scan.nextInt();
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " x " + a + " = " + i * a);
        }
    }

}
