/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce 'm' para convertir de metros a pies o 'p' para pies a metros");
        char o = scan.nextLine().charAt(0);
        if (o != 'm' && o != 'p') {
            System.out.println("Opción incorrecta");
        } else {
            System.out.println("Introduce el valor a convertir");
            float a = scan.nextFloat();
            System.out.println("Valor convertido: " + metrosPies(a, o));
        }

    }

    public static float metrosPies(float valor, char introducido) {
        if (introducido == 'm') {
            return (float) (valor * 3.28084);
        } else {
            return (float) (valor / 3.28084);
        }
    }

}
