/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej12;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej12 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float num1;
        float num2;
        char opcion, seguir;
        System.out.print("Introduce primer valor: ");
        num1 = entrada.nextFloat();

        do {
            System.out.println("Operaciones: suma (+), resta (-), mutliplicación (*) y división (/)");
            entrada = new Scanner(System.in);
            opcion = entrada.nextLine().charAt(0);
            if (opcion != '+' && opcion != '-' && opcion != '*' && opcion != '/') {
                return;
            }

            System.out.print("Introduce segundo valor: ");
            num2 = entrada.nextFloat();
            switch (opcion) {
                case '+':
                    num1 = suma(num1, num2);
                    break;
                case '-':
                    num1 = suma(num1, num2 * -1);
                    break;
                case '*':
                    num1 = multiplicacion(num1, num2);
                    break;
                case '/':
                    if (num2 != 0) {
                        num1 = multiplicacion(num1, 1 / num2);
                    } else {
                        System.out.println("La división no puede realizarse porque el divisor es cero");
                    }
                    break;
            }
            System.out.println(String.valueOf(num1) + opcion + String.valueOf(num2) + " = " + num1);
            do {
                System.out.println("Introduce 's' para seguir o 'n' para salir");
                entrada = new Scanner(System.in);
                seguir = entrada.nextLine().charAt(0);
            } while (seguir != 's' && seguir != 'n');
        } while (seguir != 'n');

    }

    public static float suma(float n1, float n2) {
        return n1 + n2;
    }

    public static float multiplicacion(float n1, float n2) {
        return n1 * n2;
    }

}
