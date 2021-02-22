/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej5 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        System.out.println("Operaciones: suma (+), resta (-), mutliplicación (*) y división (/)");
        char opcion = entrada.nextLine().charAt(0);
        if (opcion != '+' && opcion != '-' && opcion != '*' && opcion != '/') {
            return;
        }
        System.out.print("Introduce primer valor: ");
        num1 = entrada.nextInt();
        System.out.print("Introduce segundo valor: ");
        num2 = entrada.nextInt();
        float resultado = 0;
        switch (opcion) {
            case '+':
                System.out.println(String.valueOf(num1) + opcion + String.valueOf(num2) + " = " + suma(num1, num2));
                break;
            case '-':
                System.out.println(String.valueOf(num1) + opcion + String.valueOf(num2) + " = " + suma(num1, num2 * -1));
                break;
            case '*':
                System.out.println(String.valueOf(num1) + opcion + String.valueOf(num2) + " = " + multiplicacion(num1, num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println(String.valueOf(num1) + opcion + String.valueOf(num2) + " = " + multiplicacion(num1, 1 / num2));
                } else {
                    System.out.println("La división no puede realizarse porque el divisor es cero");
                }
                break;
        }

    }

    public static int suma(int n1, int n2) {
        return n1 + n2;
    }

    public static float multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

}
