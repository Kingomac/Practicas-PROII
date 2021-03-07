package ej5;

/**
 *
 * @author Mario
 */
public class Deportista {

    public static enum Categoria {
        BENJAMIN, ALEVIN, INFANTIL, CADETE,
        JUVENIL, SENIOR
    };
    public static final int MIN_EDAD = 16;
    public static final int MAX_EDAD = 65;

    private final String dni;
    private final String nombre;
    private final Categoria categoria;
    private final int edad;

    /**
     * crea un deportista, asignando su dni, nombre y categoría
     *
     * @param dni, el DNI como String
     * @param nombre, el nombre como String
     * @param categoria, la categoria como un enumerado Categoria
     * @param edad, edad como int
     */
    public Deportista(String dni, String nombre, Categoria categoria, int edad) throws Exception {
        if (edad < MIN_EDAD || edad > MAX_EDAD) {
            throw new Exception("No cumple con los requisitos de edad: mínima " + MIN_EDAD + " / máxima " + MAX_EDAD);
        }
        this.dni = dni;
        this.nombre = nombre;
        this.categoria = categoria;
        this.edad = edad;
    }

    /**
     * Devuelve el dni del deportista
     *
     * @return el dni como String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Devuelve el nombre del deportista
     *
     * @return el nombre como String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la categoría del deportista
     *
     * @return la categoría como enum Categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Devuelve la información de un deportista como un String
     *
     * @return String
     */
    public String toString() {
        return getNombre() + " " + getDni() + " "
                + getCategoria().toString().toLowerCase();
    }
}
