package ej2;

import ej3.Publicacion;
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
public class Comunicacion extends Publicacion {

    private String nombreCongreso; // Nombre del congreso
    private String ciudad; // Ciudad de celebración del congreso
    private String pais; // Pais de celebración del congreso

    /**
     * Crea una nueva comunicación aceptada en un congreso científico
     *
     * @param nombreCongreso nombre del congreso
     * @param ciudad ciudad donde se celebra el congreso
     * @param pais pais donde se celebra el congreso
     * @param titulo titulo de la comunicación aceptada en el congreso
     * @param anho año en que se celebra el congreso
     * @param citas número de citas de esta publicación
     */
    public Comunicacion(String nombreCongreso, String ciudad, String pais,
            String titulo, int anho, int citas, Autor... autores) {

        super(titulo, anho, citas, autores);
        this.nombreCongreso = nombreCongreso;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    /**
     * @return Devuelve el nombre del congreso al que corresponde la
     * comunicación
     */
    public String getNombreCongreso() {
        return nombreCongreso;
    }

    /**
     * Actualiza el nombre del congreso
     *
     * @param nombreCongreso nuevo nombre de congreso, como cadena
     */
    public void setNombreCongreso(String nombreCongreso) {
        this.nombreCongreso = nombreCongreso;
    }

    /**
     * @return Devuelve la ciudad donde se celebra el congreso
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Actualiza la ciudad donde se celebra el congreso
     *
     * @param ciudad nueva ciudad, como cadena
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return Devuelve el pais donde se celebra el congreso
     */
    public String getPais() {
        return pais;
    }

    /**
     * Actualiza el pais donde se celebra el congreso
     *
     * @param pais nuevo pais, como cadena
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("\nComunicación a congreso.");
        toret.append(super.toString());
        toret.append("\n\tNombre del congreso: ").append(getNombreCongreso());
        toret.append("\tCiudad de celebracion: ").append(getCiudad());
        toret.append("\tPais de celebracion: ").append(getPais());

        return toret.toString();
    }
}
