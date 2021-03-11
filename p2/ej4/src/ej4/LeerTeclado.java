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
        } while (Integer.toString(dni).length() != 8);
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

    public static int leerEntero(String mensaje) {
        boolean seguir;
        int toret = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            try {
                toret = Integer.parseInt(scan.nextLine());
                seguir = false;
            } catch (NumberFormatException ex) {
                seguir = true;
                System.err.println("Introduce un entero: " + ex.getMessage());
            }
        } while (seguir);
        return toret;
    }

    public static double leerNota(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        double toret;
        boolean seguir;
        do {
            System.out.print(mensaje);
            try {
                toret = Double.parseDouble(entrada.nextLine());
                seguir = false;
            } catch (NumberFormatException exc) {
                toret = -1;
                seguir = true;
                System.err.println("Error: " + exc.getMessage());
            }
        } while (toret < 0 || toret > 10 || seguir);
        return toret;
    }
}
