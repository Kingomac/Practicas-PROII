package ej2;

import ej3.Publicacion;
import ej5.Autor;

/**
 *
 * @author Mario
 */
public class Libro extends Publicacion {

    private String editorial; // Editorial
    private String lugar; // Lugar de publicacion

    /**
     * Crea un nuevo libro científico
     *
     * @param editorial nombre de la editorial
     * @param lugar lugar donde se publica el libro
     * @param titulo título del libro
     * @param anho año de publicación del libro
     * @param citas número de citas del libro
     * @param autores lista de autores del libro
     */
    public Libro(String editorial, String lugar,
            String titulo, int anho, int citas, Autor... autores) {

        super(titulo, anho, citas, autores);
        this.editorial = editorial;
        this.lugar = lugar;
    }

    /**
     * @return Devuelve la editorial del libro
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Actualiza la editorial del libro
     *
     * @param editorial nueva editorial, como cadena
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return Devuelve el lugar donde se publica el libro
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Actualiza el lugar de publicación del libro
     *
     * @param lugar nuevo lugar de publicación, como cadena
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("\nLibro.");
        toret.append(super.toString());
        toret.append("\n\tEditorial: ").append(getEditorial());
        toret.append("\tLugar de publicacion: ").append(getLugar());

        return toret.toString();
    }
}
