package ej2;

import ej3.Publicacion;
import ej5.Autor;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * 2. En algunos congresos se utilizan también los pósteres para el intercambio
 * de conocimiento. Crea la clase Poster, subclase de la clase Comunicacion del
 * ejercicio anterior, donde se gestiona el nombre de la sesión en la que se
 * expone, sala, hora de inicio (hora y minuto) y número de horas que dura la
 * exposición del póster (no puede ser menor de 4 horas) .
 *
 * 3. Las publicaciones científicas normalmente citan a otras. Añade, al
 * ejercicio anterior, la posibilidad de guardar el número de citas que tiene
 * una publicación dada.
 *
 * @author Mario
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor autor1 = new Autor("Rodríguez Rodríguez", "Pepe", "dj893d23h7d782g");
        Autor autor2 = new Autor("García García", "José", "kjdhjksh34dk23sa");
        Comunicacion com = new Comunicacion("Congreso", "Ourense", "España", "Título", 2021, 0, autor1);
        Poster p1 = new Poster(com, "Sesión 1", 10, 0, 5 * 60, 0);
        Poster p2 = new Poster(com, "Sesión 2", LocalTime.of(19, 30), Duration.ofHours(4).plusMinutes(15), 0, autor1, autor2);
        Libro l1 = new Libro("Oxford", "Oxford", "Título", 2020, 4, autor2);
        Articulo a1 = new Articulo("Nature", 5, 250, 265, "Artículo interesante", 2021, autor1, autor2);

        System.out.println(p1);
        System.out.println(p2);
        /*
        RegistroPublicaciones registro1 = new RegistroPublicaciones(autor1, com, p1, p2, a1);
        RegistroPublicaciones registro2 = new RegistroPublicaciones(autor2, p2, l1, a1);

        System.out.println(registro1);
        System.out.println(registro2);

        System.out.println("Índice H del autor 1: " + registro1.calcularIndiceH());
        System.out.println("Índice H del autor 2: " + registro2.calcularIndiceH());

        System.out.println(leerPublicacion());*/
    }

    private static Publicacion leerPublicacion() {
        int opcion;
        String titulo;
        int anho;
        System.out.println("Tipo de publicación:");
        System.out.println("\t1. Artículo");
        System.out.println("\t2. Comunicación");
        System.out.println("\t3. Póster");
        System.out.println("\t4. Libro");

        do {
            opcion = leerEntero("-> ");
        } while (opcion < 1 || opcion > 4);

        titulo = leerCadena("Título: ");
        anho = leerEntero("Año: ");

        switch (opcion) {
            case 1:
                return new Articulo(leerCadena("Nombre revista: "),
                        leerEntero("Volumen: "), leerEntero("Página inicial: "),
                        leerEntero("Página final: "), titulo, anho, leerArrayAutores("Autores: "));
            case 2:
                return new Comunicacion(leerCadena("Congreso: "),
                        leerCadena("Ciudad: "), leerCadena("País"), titulo,
                        anho, leerEntero("Citas: "), leerArrayAutores("Autores: "));
            case 3:
                return new Poster(leerCadena("Nombre sesión: "),
                        leerEntero("Hora inicio: "),
                        leerEntero("Minuto inicio: "), leerEntero("Duración: "),
                        leerCadena("Nombre congreso: "), leerCadena("Ciudad: "),
                        leerCadena("País: "), titulo, anho, leerEntero("Citas: "),
                        leerArrayAutores("Autores: "));
            case 4:
                return new Libro(leerCadena("Editorial: "), leerCadena("Lugar: "),
                        titulo, anho, leerEntero("Citas: "), leerArrayAutores("Autores: "));
        }
        return null;
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

    private static Autor[] leerArrayAutores(String mensaje) {
        Autor[] toret;
        int num;
        System.out.print(mensaje);
        num = leerEntero("Cantidad: ");
        toret = new Autor[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Autor " + (i + 1));
            toret[i] = new Autor(leerCadena("Apellidos: "), leerCadena("Nombre: "),
                    leerCadena("ORCID: "));
        }
        return toret;
    }

}
