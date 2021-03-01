package ej4;

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
        Alumno n = Alumno.leerAlumno();
        System.out.println(n);
    }

}
