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
        int opcion;
        Curso curso = new Curso(LeerTeclado.leerEntero("Número máximo de alumnos: "));

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                try {
                    curso.insertar(LeerTeclado.leerAlumno());
                } catch (Exception ex) {
                    System.err.println("No se pudo insertar el alumno: " + ex.getMessage());
                }
                break;

                case 2:
                    System.out.println(curso);
                    break;
                case 3:
                try {
                    System.out.println(curso.getAlumno(LeerTeclado.leerEntero("Posición 1..." + curso.getCont()) - 1));
                } catch (Exception ex) {
                    System.err.println("No se ha podido obtener el alumno: " + ex.getMessage());
                }
            }
        } while (opcion != 4);
    }

    private static int menu() {
        int opcion;
        do {
            System.out.println("Menú:\n1. Añadir alumno\n2. Listar alumnos\n3. Alumno dada posición\n4. Salir");
            opcion = LeerTeclado.leerEntero("-> ");
        } while (opcion > 4 || opcion < 1);
        return opcion;
    }

}
