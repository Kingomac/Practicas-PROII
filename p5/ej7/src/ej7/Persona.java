package ej7;

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
public abstract class Persona {

    private final String dni;
    private String nombre;
    private String apellidos;
    private Fecha fechaNacimiento;

    public Persona(String dni, String nombre, String apellidos, Fecha fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("DNI: ").append(getDni()).append("; Nombre: ")
                .append(getNombre()).append("; Fecha de nacimiento: ")
                .append(getFechaNacimiento());
        return toret.toString();
    }

}
