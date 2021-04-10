package ej4;

/**
 *
 * @author Mario
 */
public class Erasmus extends Alumno {

    private String universidadProcedencia;

    public Erasmus(String universidadProcedencia, String planEstudios, String dni, String nombre, String apellidos, Fecha fechaNacimiento) {
        super(planEstudios, dni, nombre, apellidos, fechaNacimiento);
        this.universidadProcedencia = universidadProcedencia;
    }

    public String getUniversidadProcedencia() {
        return universidadProcedencia;
    }

    public void setUniversidadProcedencia(String universidadProcedencia) {
        this.universidadProcedencia = universidadProcedencia;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(super.toString()).append("\n\t(Erasmus) Universidad de procedencia: ")
                .append(universidadProcedencia);
        return toret.toString();
    }

}
