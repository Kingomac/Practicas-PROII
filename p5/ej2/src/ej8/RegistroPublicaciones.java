package ej8;

import ej2.Articulo;
import ej2.Comunicacion;
import ej2.Libro;
import ej3.Publicacion;
import ej5.Autor;

/**
 *
 * @author Mario
 */
public class RegistroPublicaciones {

    private Publicacion[] publicaciones;
    private Autor autor;

    public RegistroPublicaciones(Autor autor, Publicacion... publicaciones) {
        this.publicaciones = publicaciones;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Publicacion getPublicacion(int i) throws PublicacionInexistenteException {
        if (i < 0 || i > publicaciones.length) {
            throw new PublicacionInexistenteException("La publicación no existe");
        }
        return publicaciones[i];
    }

    public void insertarPublicaciones(Publicacion... publicaciones) {
        Publicacion[] nuevas = new Publicacion[this.publicaciones.length + publicaciones.length];
        for (int i = 0; i < this.publicaciones.length; i++) {
            nuevas[i] = this.publicaciones[i];
        }

        for (int i = this.publicaciones.length; i < nuevas.length; i++) {
            nuevas[i] = publicaciones[i - this.publicaciones.length];
        }
        this.publicaciones = nuevas;
    }

    public void eliminarPublicacion(int i) throws PublicacionInexistenteException {
        if (i < 0 || i > publicaciones.length) {
            throw new PublicacionInexistenteException("La publicación no existe");
        }
        Publicacion[] nuevas = new Publicacion[this.publicaciones.length - 1];
        for (int j = 0; j < i; j++) {
            nuevas[j] = publicaciones[j];
        }
        for (int j = i + 1; j < nuevas.length; j++) {
            nuevas[j - 1] = publicaciones[j];
        }
        publicaciones = nuevas;
    }

    public double calcularIndiceH() {
        double toret = 0;
        for (Publicacion p : publicaciones) {
            if (p.getClass() == Articulo.class) {
                toret += 1;
            } else if (p.getClass() == Libro.class) {
                toret += 0.8;
            } else if (p.getClass() == Comunicacion.class) {
                toret += 0.6;
            } else {
                toret += 0.4;
            }
        }
        return toret;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(autor.toString());
        toret.append(":\n");
        for (Publicacion p : publicaciones) {
            toret.append("\n---------------------------------------\n").append(p);
        }
        toret.append("\n***************************************\n");
        return toret.toString();
    }

}
