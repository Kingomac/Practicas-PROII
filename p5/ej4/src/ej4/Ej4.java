package ej4;

import java.util.Scanner;

/**
 *
 * Implementa la clase Persona, que contenga al menos un atributo DNI y disponga
 * de un constructor parametrizado. A partir de ella, define la clase Alumno,
 * conteniendo al menos un atributo planEstudios y un constructor parametrizado,
 * y la clase Profesor, conteniendo al menos un atributo despacho, y otro
 * asignatura, además de su constructor parametrizado. Crea el método toString()
 * para cada clase.
 *
 * RETO: crear una clase Universidad que contenga personas que puedan ser alumno
 * y profesor. Persona[] personas; --> Max solicitado por teclado --> UVigo 1000
 * personas; String nombre;
 *
 * @author Mario
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        int maxPersonas = leerEntero("Número máximo de personas: ");
        String nombreUni = leerCadena("Nombre de la universidad: ");
        Universidad uni = new Universidad(maxPersonas, nombreUni);

        do {
            System.out.println("Universidad:");
            System.out.println("\t1. Insertar");
            System.out.println("\t2. Borrar");
            System.out.println("\t3. Mostrar");
            System.out.println("\t4. Listar");
            System.out.println("\t5. Salir");

            opcion = leerEntero("-> ");
            try {
                switch (opcion) {
                    case 1:
                        uni.insertar(leerPersona());
                        break;
                    case 2:
                        uni.borrar(leerEntero("Posición: "));
                        break;
                    case 3:
                        System.out.println(uni);
                        break;
                    case 4:
                        listar(uni);
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        } while (opcion != 5);
    }

    private static void listar(Universidad uni) {
        int opc;
        do {
            System.out.println("1. Alumno\n2. Eramus\n3. Profesor");
            opc = leerEntero("-> ");
        } while (opc < 1 || opc > 3);
        System.out.println(uni.listar(opc));
    }

    private static Persona leerPersona() {
        int opcion;
        Persona toret = new Alumno("", "", "", "", new Fecha(0, 0, 0));
        String nombre = leerCadena("Nombre: ");
        String apellidos = leerCadena("Apellidos: ");
        String dni = leerCadena("DNI: ");
        Fecha fechaNacimiento = leerFecha("Fecha de nacimiento: ");

        String planEstudios;
        String universidadProcedencia;

        int despacho;
        String asignatura;

        do {
            System.out.println("1. Alumno\n2. Profesor");
            opcion = leerEntero("-> ");
        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                planEstudios = leerCadena("Plan de estudios: ");
                universidadProcedencia = leerCadenaNoObligatoria("Universidad de procedencia (solo Erasmus): ");
                if ("".equals(universidadProcedencia)) {
                    toret = new Alumno(planEstudios, dni, nombre, apellidos, fechaNacimiento);
                } else {
                    toret = new Erasmus(universidadProcedencia, planEstudios, dni, nombre, apellidos, fechaNacimiento);
                }
                break;
            case 2:
                despacho = leerEntero("Despacho: ");
                asignatura = leerCadena("Asignatura: ");
                toret = new Profesor(despacho, asignatura, dni, nombre, apellidos, fechaNacimiento);
                break;
        }
        return toret;

    }

    private static Fecha leerFecha(String mensaje) {
        int dia, mes, anho;
        boolean seguir;
        do {
            System.out.println(mensaje);
            dia = leerEntero("\tDía: ");
            mes = leerEntero("\tMes: ");
            anho = leerEntero("\tAño: ");
            seguir = true;
//            if (dia > 31 || mes > 12 || anho < 1900) {
//                seguir = false;
//            } else if (mes == 2 && dia > 28 && (anho % 4 != 0 || anho % 100 == 0 || anho % 400 != 0)) {
//                seguir = false;
//            } else if (mes == 2 && dia > 29 && anho % 4 == 0 && anho % 100 != 0 && anho % 400 == 0) {
//                seguir = false;
//            } else if (mes % 2 != 0 && dia != 31) {
//                seguir = false;
//            } else if (mes % 2 == 0 && dia != 30) {
//                seguir = false;
//            }
//            if (!seguir) {
//                System.err.println("Introduce una fecha válida");
//            }
        } while (seguir);
        return new Fecha(dia, mes, anho);
    }

    private static int leerEntero(String mensaje) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Formato de número no valido");
            }
        }
    }

    private static String leerCadena(String mensaje) {
        Scanner scan = new Scanner(System.in);
        String toret;
        do {
            System.out.print(mensaje);
            toret = scan.nextLine().trim();
        } while ("".equals(toret));
        return toret;
    }

    private static String leerCadenaNoObligatoria(String mensaje) {
        Scanner scan = new Scanner(System.in);
        String toret;
        System.out.print(mensaje);
        toret = scan.nextLine().trim();
        return toret;
    }

}
