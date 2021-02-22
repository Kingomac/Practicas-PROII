/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej21;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Número de notas: ");
        int numNotas = scan.nextInt();
        System.out.print("Número de alumnos: ");
        int numAlumnos = scan.nextInt();
        float notas[][] = new float[numAlumnos][numNotas];
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Notas del alumno " + (i + 1));
            for (int j = 0; j < numNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[i][j] = scan.nextFloat();
            }
        }
        for (int i = 0; i < numAlumnos; i++) {
            System.out.print("Notas del alumno " + (i + 1) + ": ");
            for (int j = 0; j < numNotas; j++) {
                System.out.print(notas[i][j]);
                if (j < numNotas - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }

}
