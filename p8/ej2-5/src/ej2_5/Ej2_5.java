package ej2_5;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Mario
 */
public class Ej2_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro l1 = new Libro("La historia interminable", "Michael Ende", LocalDate.of(1979, Month.MARCH, 20));
        Libro l2 = new Libro("Don Quijote", "Miguel de Cervantes Saavedra", LocalDate.of(1605, Month.MARCH, 20));
        Libro l3 = new Libro("El arte de la guerra", "Sun Tzu", LocalDate.of(1999, Month.MARCH, 20));
        Libro l4 = new LibroElectronico("https://google.es", "No game no life", "Yuu Kamiya", LocalDate.of(2012, Month.APRIL, 25));
        Biblioteca b = new Biblioteca();

        b.insertar(l1);
        b.insertar(l2);
        b.insertar(l3);
        b.insertar(l4);

        try {
            b.toXML("biblioteca.xml");
        } catch (IOException ex) {
            System.err.println("Error guardando el archivo");
        }

        try {
            b = new Biblioteca("biblioteca.xml");
            System.out.println(b);
        } catch (Exception ex) {
            System.err.println("Error leyendo el archivo: " + ex.getMessage());
        }

    }

}
