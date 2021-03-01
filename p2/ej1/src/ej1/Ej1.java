package ej1;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 * Dada la clase Libro del ejercicio 5 de la práctica 1
 * (https://ideone.com/HWBk07), implementa en el método main un vector primitivo
 * de objetos de tipo Libro, añade algún libro al vector y visualiza los datos
 * de los libros almacenados en el vector. Añade un método estático (en la clase
 * principal) para leer un libro.
 *
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double precioInferior = 9.99;
        Libro[] libros = new Libro[4];
        libros[0] = new Libro("De catro a catro. Follas sin data d'un diario d'abordo",
                "Manuel Antonio", "Editorial Nós", 1928, "9788482882031", 10);
        libros[1] = new Libro("Os vellos non deben de namorarse",
                "Alfonso Daniel Manuel Rodríguez Castelao", "Editorial Galaxia",
                1953, "9788482887401", 15);
        libros[2] = leerLibro();
        libros[3] = leerLibro();
        for (Libro l : libros) {
            System.out.println(l);
            System.out.println("--------------------");
        }
        System.out.println("Libros con un precio inferior a " + precioInferior + ": " + contabilizarNumLibros(precioInferior, libros));
    }

    private static Libro leerLibro() {
        String titulo;
        String autores;
        String editorial;
        String isbn;
        int anho;
        double precio;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un libro:");
        titulo = leerCampoObligatorio("\tTítulo: ");
        autores = leerCampoObligatorio("\tAutores:");
        editorial = leerCampoObligatorio("\tEditorial:");
        anho = Integer.parseInt(leerCampoObligatorio("\tAño:"));
        isbn = leerCampoObligatorio("\tIsbn:");
        precio = Double.parseDouble(leerCampoObligatorio("\tPrecio: "));
        return new Libro(titulo, autores, editorial, anho, isbn, precio);
    }

    private static String leerCampoObligatorio(String mensaje) {
        String toret;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            toret = entrada.nextLine().trim();
        } while ("".equals(toret));
        return toret;
    }

    private static int contabilizarNumLibros(double precio, Libro[] libros) {
        int toret = 0;
        for (Libro l : libros) {
            if (l.getPrecio() < precio) {
                toret++;
            }
        }
        return toret;
    }
}
