/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej16;

/**
 *
 * @author Mario
 */
public class Ej16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entrada[] = {2, 3, 45, 65, 76, 2, 8, 56, 39, 0, 4};
        for (int i : entrada) {
            if (i % 2 != 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("");
    }

}
