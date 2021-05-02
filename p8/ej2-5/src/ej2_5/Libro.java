package ej2_5;

import java.time.LocalDate;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Libro {

    public static enum Etq {
        LIBRO, TITULO, AUTOR, FECHA_EDICION
    }

    private String titulo;
    private String autor;
    private LocalDate fechaEdicion;

    public Libro(Element e) throws ParsingException {
        Element elTitulo = e.getFirstChildElement(Etq.TITULO.name());
        Element elAutor = e.getFirstChildElement(Etq.AUTOR.name());
        Element elFechaEdicion = e.getFirstChildElement(Etq.FECHA_EDICION.name());

        if (elTitulo == null) {
            throw new ParsingException("Falta el título");
        }
        if (elAutor == null) {
            throw new ParsingException("Falta el autor");
        }
        if (elFechaEdicion == null) {
            throw new ParsingException("Falta la fecha de edición");
        }
        this.titulo = elTitulo.getValue().trim();
        this.autor = elAutor.getValue().trim();
        this.fechaEdicion = LocalDate.parse(elFechaEdicion.getValue().trim());
    }

    public Libro(String titulo, String autor, LocalDate fechaEdicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaEdicion = fechaEdicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Element toDOM() {
        Element libro = new Element(Etq.LIBRO.name());
        Element elTitulo = new Element(Etq.TITULO.name());
        Element elAutor = new Element(Etq.AUTOR.name());
        Element elFechaEdicion = new Element(Etq.FECHA_EDICION.name());

        elTitulo.appendChild(getTitulo());
        elAutor.appendChild(getAutor());
        elFechaEdicion.appendChild(getFechaEdicion().toString());

        libro.appendChild(elTitulo);
        libro.appendChild(elAutor);
        libro.appendChild(elFechaEdicion);

        return libro;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getTitulo(), getAutor());
    }
}
