package ej4;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 *
 * Este ejercicio tiene como objetivo crear la programación diaria de una
 * emisora de radio. Para ello, habrá una clase ProgramaRadio en la que se
 * almacena el título del programa, el nombre del locutor, la duración en
 * minutos y la hora a la que empieza dicho programa. La duración mínima de un
 * programa será de 60 minutos, por lo que no será posible crear programas con
 * una duración más corta. Por otra parte, existirá una clase ProgramacionDiaria
 * que es responsable de almacenar todos los programas de un día, así como de
 * crear un nuevo programa (a partir de un título, un nombre de locutor, y una
 * duración), asignándolo a la siguiente hora disponible. Esta clase es también
 * responsable de saber cuántos minutos disponibles y ocupados hay en la
 * programación diaria. Una vez que tengas las clases básicas creadas y hayas
 * comprobado su funcionamiento, crea un programa principal que se encargue de
 * pedir los datos de los programas por consola (título, nombre locutor y
 * duración) y los vaya añadiendo a la programación diaria. Se pedirán programas
 * mientras haya minutos disponibles y esta cantidad sea suficiente para crear
 * un nuevo programa con la duración mínima de 60 minutos. Cuando la
 * programación esté completa, muestra el listado de programas, con todos sus
 * datos y sus horas de comienzo y fin (Nota: se recomienda utilizar la clase
 * LocalTime)
 *
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        ProgramacionDiaria programacion = new ProgramacionDiaria();
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    try {
                    programacion.crearPrograma(leerPrograma());
                } catch (Exception exc) {
                    System.out.println("No se puedo crear el programa: " + exc.getMessage());
                }
                break;
                case 2:
                    System.out.println(programacion);
            }
        } while (opcion != 3);
    }

    /**
     * Método estático para leer los datos de un ProgramaRadio
     *
     * @return ProgramaRadio con los datos introducidos
     */
    private static ProgramaRadio leerPrograma() {
        Scanner scan = new Scanner(System.in);
        ProgramaRadio programa = new ProgramaRadio();
        boolean seguir;
        System.out.println("Introduce los datos de un programa:");
        do {
            System.out.print("\tTítulo: ");
            programa.setTitulo(scan.nextLine().trim());
        } while (programa.getTitulo().equals(""));
        do {
            System.out.print("\tLocutor: ");
            programa.setLocutor(scan.nextLine().trim());
        } while (programa.getLocutor().equals(""));
        do {
            System.out.print("\tDuración (minutos): ");
            try {
                programa.setDuracion(Integer.parseInt(scan.nextLine()));
                seguir = false;
            } catch (NumberFormatException exc) {
                System.out.println("Asegúrate de introducir un entero");
                seguir = true;
            } catch (Exception exc) {
                System.out.println("Error creando el programa: " + exc.getMessage());
                seguir = true;
            }
        } while (seguir);
        return programa;
    }

    private static int menu() {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        int toret = 0;
        System.out.println("Programación de radio:\n1- Añadir programa\n"
                + "2- Visualizar programas\n3- Salir");
        do {
            System.out.print("->");
            try {
                toret = Integer.parseInt(scan.nextLine());
                seguir = false;
            } catch (NumberFormatException exc) {
                toret = 0;
            }
            if (toret < 1 || toret > 3) {
                System.out.println("Introduce una opcion válida");
                seguir = true;
            }
        } while (seguir);
        return toret;
    }

}
