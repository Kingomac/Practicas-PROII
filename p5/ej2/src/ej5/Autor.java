package ej5;

/**
 *
 * Una publicación científica puede tener varios autores. Crea la clase Autor,
 * que guarda su identificador (ORCID: Open Researcher and Contributor ID, es un
 * identificador alfanumérico único para cada investigador), su apellidos,
 * nombre e institución al que corresponde. Usando la clase Autor, modifica la
 * clase Publicacion para conocer el primer autor de toda publicación
 * científica.
 *
 * @author Mario
 */
public class Autor {

    private String apellidos;
    private String nombre;
    private final String orcid;
    private double indiceH;

    public Autor(String apellidos, String nombre, String orcid) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.orcid = orcid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrcid() {
        return orcid;
    }

    public double getIndiceH() {
        return indiceH;
    }

    public void setIndiceH(double indiceH) {
        this.indiceH = indiceH;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, %s", orcid, apellidos, nombre);
    }

}
