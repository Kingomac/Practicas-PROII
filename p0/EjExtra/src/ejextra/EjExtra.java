/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejextra;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class EjExtra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leer edad, nombre y nota
        int edad;
        String nombre;
        float nota;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la edad:");
        edad = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce el nombre:");
        nombre = teclado.nextLine();
        System.out.println("Introduce la nota:");
        nota = Float.parseFloat(teclado.nextLine());
        System.out.println("Edad: " + edad);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota: " + nota);
    }

}
