package ej1;

import ej5.Libro;
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
        Libro[] libros = new Libro[12];
        libros[0] = new Libro("De catro a catro. Follas sin data d'un diario d'abordo",
                "Manuel Antonio", "Editorial Nós", 1928, "9788482882031");
        libros[1] = new Libro("Non vellos non deben de namorarse",
                "Alfonso Daniel Manuel Rodríguez Castelao", "Editorial Galaxia",
                1953, "9788482887401");
        libros[2] = leerLibro();
        libros[3] = leerLibro();
        for (Libro l : libros) {
            if (l != null) {
                System.out.println(l);
                System.out.println("--------------------");
            }
        }
    }

    private static Libro leerLibro() {
        String titulo;
        String autores;
        String editorial;
        String isbn;
        int anho;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce un libro:");
        System.out.print("\tTítulo: ");
        titulo = scan.nextLine();
        System.out.print("\tAutores: ");
        autores = scan.nextLine();
        System.out.print("\tEditorial: ");
        editorial = scan.nextLine();
        System.out.print("\tAño: ");
        anho = Integer.parseInt(scan.nextLine());
        System.out.print("\tIsbn: ");
        isbn = scan.nextLine();
        return new Libro(titulo, autores, editorial, anho, isbn);
    }
}
