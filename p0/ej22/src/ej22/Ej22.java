/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej22;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej22 {

    /**
     * @param args the command line arguments
     */
    public static final int len = 5;

    public static void main(String[] args) {
        Random random = new Random();
        int matriz[][] = new int[len][len];
        for (int[] i : matriz) {
            for (int j : i) {
                j = random.nextInt(5);
            }
        }
        System.out.println("Introduce un número entre 0 y 4 para buscarlo en la matriz");
        Scanner scan = new Scanner(System.in);
        int buscar = scan.nextInt();
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                if (matriz[i][j] == buscar) {
                    System.out.println("El valor buscado está en la posición: " + i + "," + j);
                    break;
                }
            }
        }
        if (i == len && j == len) {
            System.out.println("El valor buscado no está en la matriz");
        }
    }

}
