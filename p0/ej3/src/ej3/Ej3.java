/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Mario
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 5, b = 3, temp;
        System.out.println("a: " + a + " b: " + b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("a: " + a + " b: " + b);
        
    }
    
}
