package ej3;

/**
 *
 * @author Mario
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private int dni;
    private final String LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";

    public Persona(String nombre, String apellidos, int dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getDni() {
        return String.valueOf(dni) + LETRA.charAt(dni % 23);
    }

    public String toString() {
        return getDni() + " - " + apellidos + ", " + nombre;
    }
}
