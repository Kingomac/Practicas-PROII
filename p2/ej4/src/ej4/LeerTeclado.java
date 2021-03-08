/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class LeerTeclado {

    public static Alumno leerAlumno() {
        int dni;
        String apellidos;
        String nombre;
        Alumno toret;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce los datos de un alumno: ");
        do {
            System.out.print("\tDNI: ");
            try {
                dni = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException exc) {
                dni = 0;
            }
        } while (dni > 100000000);
        apellidos = leerObligatorio("\tApellidos: ");
        nombre = leerObligatorio("\tNombre: ");
        toret = new Alumno(dni, apellidos, nombre);
        for (Alumno.Nota n : Alumno.Nota.values()) {
            toret.setNota(n, leerNota("\tNota " + n + ": "));
        }
        return toret;
    }

    public static String leerObligatorio(String mensaje) {
        String toret;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            toret = entrada.nextLine().trim();
        } while ("".equals(toret));
        return toret;
    }

    public static double leerNota(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        double toret;
        do {
            System.out.print(mensaje);
            try {
                toret = Double.parseDouble(entrada.nextLine());
            } catch (NumberFormatException exc) {
                toret = -1;
            }
        } while (toret >= 0 && toret <= 10);
        return toret;
    }
}
