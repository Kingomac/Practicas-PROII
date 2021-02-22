package ej5;

/**
 *
 * @author Mario
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     *
     * La información para manejar libros está formada por su título, autores,
     * editorial, año de edición e isbn. Para visualizar un libro se hace como
     * en este ejemplo: Titulo = Thinking in Java Autores = Bruce Eckel
     * Editorial = Prentice Hall Año = 2007 Isbn = 0131872486
     *
     */
    public static void main(String[] args) {
        Libro libro = new Libro("Thinking in Java", "Bruce Eckel",
                "Prentice Hall", 2007, "0131872486");
        System.out.println(libro.toString());
    }

}
