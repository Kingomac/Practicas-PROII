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
    private Fecha fechaIngreso;

    public Autor(String apellidos, String nombre, String orcid, Fecha fechaIngreso) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.orcid = orcid;
        this.fechaIngreso = fechaIngreso;
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

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Orcid:").append(getOrcid()).append("\bApellidos: ").append(getApellidos())
                .append("\nNombre: ").append(getNombre()).append("\nFecha de ingreso")
                .append(getFechaIngreso());
        return toret.toString();
    }

}
