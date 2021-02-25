/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej15;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        Scanner scan = new Scanner(System.in);
        int dni;
        do {
            System.out.print("Introduce el DNI sin letra:");
            dni = scan.nextInt();
        } while (dni <= 10000000 || dni > 100000000);

        System.out.println("Letra: " + LETRAS_DNI.charAt((int) (dni % 23)));
    }

}
