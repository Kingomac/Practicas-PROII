package ej5;

/**
 *
 * @author Mario
 *
 * La información para manejar libros está formada por su título, autores,
 * editorial, año de edición e isbn. Para visualizar un libro se hace como en
 * este ejemplo: Titulo = Thinking in Java Autores = Bruce Eckel Editorial =
 * Prentice Hall Año = 2007 Isbn = 0131872486
 *
 */
public class Libro {
//<editor-fold>

    private String autores;
    private String editorial;
    private String titulo;
    private int anho;
    private String isbn;
//</editor-fold>

    public Libro(String titulo, String autores, String editorial, int anho, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anho = anho;
        this.isbn = isbn;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnho() {
        return anho;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Titulo: ");
        toret.append(getTitulo());
        toret.append("\nAutores: ");
        toret.append(getAutores());
        toret.append("\nEditorial: ");
        toret.append(getEditorial());
        toret.append("\nAño: ");
        toret.append(getAnho());
        toret.append("\nISBN: ");
        toret.append(getIsbn());
        return toret.toString();
    }
}
