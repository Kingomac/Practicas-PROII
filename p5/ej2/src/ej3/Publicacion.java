package ej3;

import ej5.AutorInexistenteExcepcion;
import ej5.Autor;

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
public abstract class Publicacion {

    private String titulo; // Titulo de la publicación (libro, artículo o comunicación a congreso)
    private int anho; // Año original de publicación
    private int citas;
    private Autor[] autores;

    public Publicacion(String titulo, int anho, int citas, Autor... autores) {
        this.titulo = titulo;
        this.anho = anho;
        this.citas = citas;
        this.autores = autores;
    }

    public Autor getAutor(int i) throws AutorInexistenteExcepcion {
        if (i >= autores.length) {
            throw new AutorInexistenteExcepcion("El autor no existe");
        }
        return autores[i];
    }

    public void setAutores(Autor... autores) {
        this.autores = autores;
    }

    public int getCitas() {
        return citas;
    }

    public void setCitas(int citas) {
        this.citas = citas;
    }

    /**
     * @return Devuelve el título de la publicación
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Actualiza el titulo de la publicación
     *
     * @param titulo nuevo titulo, como cadena
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return Devuelve el año de publicación
     */
    public int getAnho() {
        return anho;
    }

    /**
     * Actualiza el año de publicación
     *
     * @param anho nuevo año, como int
     */
    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("\n\tTitulo: ").append(getTitulo())
                .append("\n\tAño publicacion: ").append(getAnho())
                .append("\n\tCitas: ").append(citas);

        return toret.toString();
    }
}
