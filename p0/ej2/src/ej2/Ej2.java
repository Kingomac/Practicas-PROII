/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        System.out.print("Introduce primer valor: ");
        num1 = entrada.nextInt();
        System.out.print("Introduce segundo valor: ");
        num2 = entrada.nextInt();
        System.out.println("Suma de " + num1 + " y " + num2 + " es: " + division(num1, num2));
    }

    public static int suma(int n1, int n2) {
        return n1 + n2;
    }

    public static float division(int n1, int n2) {
        if (n2 != 0) {
            return (float) n1 / n2;
        } else {
            return 0;
        }
    }

}
