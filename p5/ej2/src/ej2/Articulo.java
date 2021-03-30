package ej2;

import ej3.Publicacion;
import ej6.PaginasInicialFinalIncorrectasException;
import ej5.Autor;

/**
 *
 * @author Mario
 */
public class Articulo extends Publicacion {

    private String nombreRevista; // Nombre de la revista
    private int volumen; // Volumen
    private int pagInicial; // Pagina inicial
    private int pagFinal; // Pagina final

    /**
     * Crea uno artículo científico publicado en una revista
     *
     * @param nombreRevista nombre de la revista
     * @param volumen número de volumen
     * @param pagInicial página inicial donde aparece la publicación
     * @param pagFinal página final donde aparece la publicación
     * @param titulo título del artículo científico
     * @param anho año de publicación del artículo
     * @param autores autores del artículo
     */
    public Articulo(String nombreRevista, int volumen, int pagInicial,
            int pagFinal, String titulo, int anho, Autor... autores) {

        super(titulo, anho, anho, autores);
        this.nombreRevista = nombreRevista;
        this.volumen = volumen;
        this.pagInicial = pagInicial;
        this.pagFinal = pagFinal;
    }

    /**
     * @return Devuelve el nombre de la revista
     */
    public String getNombreRevista() {
        return nombreRevista;
    }

    /**
     * Actualiza el nombre de la revista
     *
     * @param nombreRevista nuevo nombre de revista, como cadena
     */
    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    /**
     * @return Devuelve el volument de la revista
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * Actualiza el número del volumen de la revista
     *
     * @param volumen nuevo numero de volument, como int
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    /**
     * @return Devuelve el numero de la pagina inicial donde aparece la
     * publicación
     */
    public int getPagInicial() {
        return pagInicial;
    }

    /**
     * Actualiza el número de la primera página de la publicación
     *
     * @param pagInicial nuevo numero de página inicial, como int
     */
    public void setPagInicial(int pagInicial) throws PaginasInicialFinalIncorrectasException {
        if (pagInicial > getPagFinal()) {
            throw new PaginasInicialFinalIncorrectasException("Página inicial mayor que la final");
        } else {
            this.pagInicial = pagInicial;
        }
    }

    /**
     * @return Devuelve el numero de la pagina final donde aparece la
     * publicación
     */
    public int getPagFinal() {
        return pagFinal;
    }

    /**
     * Actualiza el número de la última página de la publicación
     *
     * @param pagFinal nuevo numero de página final, como int
     */
    public void setPagFinal(int pagFinal) throws PaginasInicialFinalIncorrectasException {
        if (pagFinal < getPagInicial()) {
            throw new PaginasInicialFinalIncorrectasException("Página final menor que página inicial");
        }
        this.pagFinal = pagFinal;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("\nArticulo en revista científica. ");
        toret.append(super.toString());
        toret.append("\n\tNombre revista: ").append(getNombreRevista());
        toret.append("\tVolumen: ").append(getVolumen());
        toret.append(", ").append(getPagInicial()).append(" - ").append(getPagFinal());

        return toret.toString();
    }
}
