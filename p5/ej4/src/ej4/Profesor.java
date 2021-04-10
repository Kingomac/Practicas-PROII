package ej4;

/**
 *
 * Implementa la clase Persona, que contenga al menos un atributo DNI y disponga
 * de un constructor parametrizado. A partir de ella, define la clase Alumno,
 * conteniendo al menos un atributo planEstudios y un constructor parametrizado,
 * y la clase Profesor, conteniendo al menos un atributo despacho, y otro
 * asignatura, además de su constructor parametrizado. Crea el método toString()
 * para cada clase.
 *
 * @author Mario
 */
public class Profesor extends Persona {

    private int despacho;
    private String asignatura;

    public Profesor(int despacho, String asignatura, String dni, String nombre, String apellidos, Fecha fechaNacimiento) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.despacho = despacho;
        this.asignatura = asignatura;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append(":\n\tDespacho: ").append(despacho).append("\n\tAsignatura: ")
                .append(asignatura);
        return toret.toString();
    }

}
