/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej13;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        float nota;
        do {
            /*System.out.print("Introduce una nota:");
            nota = scan.nextFloat();*/

            nota = r.nextFloat() * 10;
        } while (nota > 10 || nota < 0);
        System.out.println("Nota válida: " + nota);
    }

}
