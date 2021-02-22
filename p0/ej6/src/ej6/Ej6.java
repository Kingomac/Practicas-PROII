/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("Calcula el área de:");
        System.out.println("    a: círuclo");
        System.out.println("    b: cuadrado");
        System.out.println("    c: rectángulo");
        char opcion = scan.nextLine().charAt(0);
        String r = "El área es: ";
        float a, b;
        switch (opcion) {
            case 'a':
                System.out.print("Introduce el radio: ");
                a = scan.nextFloat();
                System.out.println(r + circulo(a));
                break;
            case 'b':
                System.out.print("Introduce el lado: ");
                a = scan.nextFloat();
                System.out.println(r + cuadrado(a));
                break;
            case 'c':
                System.out.print("Introduce la base: ");
                b = scan.nextFloat();
                System.out.print("Introduce la altura: ");
                a = scan.nextFloat();
                System.out.println(r + triangulo(b, a));
                break;
            default:
                System.out.println("Opción incorrecta");
        }

    }
    public static final double PI = 3.14159265358979323846;

    public static float circulo(float radio) {
        return (float) PI * radio * radio;
    }

    public static float cuadrado(float lado) {
        return lado * lado;
    }

    public static float triangulo(float base, float altura) {
        return base * altura / 2;
    }

}
