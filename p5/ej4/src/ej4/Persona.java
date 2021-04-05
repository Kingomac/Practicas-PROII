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
public abstract class Persona {

    private final String dni;
    private String nombre;

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return String.format("%s - %s", dni, nombre);
    }

}
