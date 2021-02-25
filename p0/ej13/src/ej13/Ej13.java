/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej13;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mario
 */
public class Ej13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        double nota;
        do {
            System.out.print("Introduce una nota: ");
            nota = r.nextDouble() * 10;
        } while (nota > 10 || nota < 0);
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println("Nota válida: " + df.format(nota));
    }

}
