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

    /**
     * Habría que validar los argumentos antes de crear la clase
     *
     * @param nombre
     * @param apellidos
     * @param dni
     * @throws Exception
     */
    public Persona(String nombre, String apellidos, int dni) throws Exception {
        this.nombre = nombre;
        this.apellidos = apellidos;
        if (dni <= 10000000 || dni >= 99999999) {
            throw new Exception("DNI introducido invalido: " + dni);
        }
        this.dni = dni;
    }

    public String getDni() {
        return String.valueOf(dni) + LETRA.charAt(dni % 23);
    }

    @Override
    public String toString() {
        return getDni() + " - " + apellidos + ", " + nombre;
    }
}
