/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej19;

/**
 *
 * @author Mario
 */
public class Ej19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {2, 3, 0, -1, 66, -34};
        int indice = 3;
        if (indice > array.length || indice < 0) {
            System.out.println("Índice fuera de los límites de la array");
        } else {
            for (int i = indice; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("");
        }
    }

}
