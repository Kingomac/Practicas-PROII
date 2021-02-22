/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg2;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        char temp[] = new char[1];
        System.out.println("Operaciones: suma (+), resta (-), mutliplicación (*) y división (/)");
        entrada.nextLine().getChars(0, 1, temp, 0);
        System.out.print("Introduce primer valor: ");
        num1 = entrada.nextInt();
        System.out.print("Introduce segundo valor: ");
        num2 = entrada.nextInt();
        float resultado = 0;
        switch (temp[0]) {
            case '+':
                resultado = suma(num1, num2);
                break;
            case '-':
                resultado = suma(num1, num2 * -1);
                break;
            case '*':
                resultado = multiplicacion(num1, num2);
                break;
            case '/':
                if (num2 != 0) {
                    resultado = multiplicacion(num1, 1 / num2);
                } else {
                    resultado = 0;
                }
                break;
            default:
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa tengo mieeeeeeeedoooooooooooooooo");
        }
        System.out.println(String.valueOf(num1) + temp[0] + String.valueOf(num2) + " = " + resultado);
    }

    public static int suma(int n1, int n2) {
        return n1 + n2;
    }

    public static float multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

}
