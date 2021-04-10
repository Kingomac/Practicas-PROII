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
public class Alumno extends Persona {

    private String planEstudios;

    public Alumno(String planEstudios, String dni, String nombre, String apellidos, Fecha fechaNacimiento) {
        super(dni, nombre, apellidos, fechaNacimiento);
        this.planEstudios = planEstudios;
    }

    public String getPlanEstudios() {
        return planEstudios;
    }

    public void setPlanEstudios(String planEstudios) {
        this.planEstudios = planEstudios;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append(":\n\tPlan de estudios: ").append(planEstudios);
        return toret.toString();
    }

}
