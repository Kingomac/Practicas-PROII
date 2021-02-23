package ej4;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 *
 * Un alumno de PROII se define por un dni (sin letra), unos apellidos y un
 * nombre. Además, tiene cinco notas asociadas, una para el Bloque I, otra para
 * el Bloque II, la correspondiente al Bloque III, otra para Programación y
 * finalmente la de Practicas. Además de un constructor (que aceptará DNI,
 * apellidos y nombre), y miembros getter, será necesario también un miembro o
 * miembros setter para poder cambiar las cinco notas (se recomienda utilizar un
 * vector para almacenar las notas, y un enumerado para los valores a evaluar:
 * BLOQUE_I, BLOQUE__I, BLOQUE_III, PROGRAMACION, PRACTICAS). La nota final se
 * calcula sabiendo que la nota de cada bloque tiene un peso del 15%, la nota de
 * programación tiene un peso del 30%, y la de prácticas el 25% restante. Los
 * alumnos se visualizan de la siguiente forma: "dni - apellidos, nombre: nota
 * final". La nota final de un alumno se visualiza como un mensaje de texto
 * indicando la calificación (suspenso, aprobado, notable o sobresaliente), y
 * entre paréntesis la nota numérica, por ejemplo: aprobado(5.6).
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno n = leerAlumno();
        System.out.println(n);
    }

    public static Alumno leerAlumno() {
        Alumno toret;
        int dni;
        String apellidos;
        String nombre;
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce los datos de un alumno:");
        System.out.print("\tDNI: ");
        dni = Integer.parseInt(scan.nextLine());
        System.out.print("\tApellidos: ");
        apellidos = scan.nextLine();
        System.out.print("\tNombre: ");
        nombre = scan.nextLine();
        toret = new Alumno(dni, apellidos, nombre);

        System.out.println("Introduce las notas:");
        for (Alumno.Nota tipo : Alumno.Nota.values()) {
            System.out.print("\t" + tipo + ": ");
            toret.setNota(tipo, Double.parseDouble(scan.nextLine()));
        }
        return toret;
    }

}
