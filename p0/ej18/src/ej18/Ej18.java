/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej18;

/**
 *
 * @author Mario
 */
public class Ej18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entrada[] = {2, 3, 7, -2, 0, 99};
        int busqueda = 1, i = 0;
        for (i = 0; i < entrada.length; i++) {
            if (entrada[i] == busqueda) {
                System.out.println("Su primera aparición está en la posición: " + i);
                break;
            }
        }
        if (i == entrada.length) {
            System.out.println("No se repite");
        }
    }

}
