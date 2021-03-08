/*
 * Definicion de la clase Cliente
 */
package es.uvigo.esei.pro2.core;

public class Cliente {

    private String dni;             // D.N.I. del cliente
    private String nombre;          // Nombre del cliente
    private String domicilio;       // Domicilio del cliente
    private Cuenta[] cuentas;     // Cuentas bancarias del cliente

    /**
     * Crea un nuevo cliente, con sus datos: nombre, domicilio, año y las
     * cuentas que tiene.
     *
     * @param dni D.N.I. del cliente
     * @param nombre nombre completo del cliente
     * @param domicilio el domicilio del cliente
     * @param cuentas array con las cuentas que tiene el cliente
     */
    public Cliente(String dni, String nombre, String domicilio,
            Cuenta[] cuentas) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuentas = cuentas;
    }

    /**
     * Devuelve el D.N.I. del cliente
     *
     * @return el dni del cliente, como String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Cambia el D.N.I. del cliente
     *
     * @param d el dni del cliente
     */
    public void setDni(String d) {
        dni = d;
    }

    /**
     * Devuelve el nombre del cliente
     *
     * @return El valor como cadena
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del cliente
     *
     * @param nombre El nuevo valor, como cadena
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    /**
     * Devuelve el domicilio del cliente
     *
     * @return El valor como cadena
     *
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Cambia el domicilio del cliente
     *
     * @param domicilio El nuevo valor, como cadena
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio.trim();
    }

    /**
     * Añade una nueva cuenta al listado de cuentas del cliente
     *
     * @param cuenta la nueva Cuenta
     */
    public void nuevaCuenta(Cuenta cuenta) {

    }

    /**
     * Devuelve el número de cuentas del cliente
     *
     * @return el número de cuentas del cliente
     */
    public int getNumCuentas() {
        return this.cuentas.length;
    }

    /**
     * Devuelve el objeto de tipo Cuenta que se encuentra en la posición
     * especificada (empezando en 0)
     *
     * @param cuenta el índice de la cuenta (empezando en 0)
     * @return la Cuenta que se encuentra en la posición especificada
     */
    public Cuenta getCuenta(int cuenta) {
        if ((cuenta < 0) || (cuenta >= getNumCuentas())) {
            System.err.println("El índice especificado no es válido.");
            System.exit(-1);
        }

        return this.cuentas[cuenta];
    }

    /**
     * Elimina la Cuenta de la posición especificada (empezando en 0)
     *
     * @param pos el índice de la cuenta que se quiere eliminar (empezando en 0)
     */
    public void eliminaCuenta(int pos) {
        Cuenta[] nuevasCuentas;
        int indiceNuevasCuentas;

        if (getNumCuentas() == 1) {
            System.err.println("El cliente solo tiene una cuenta y no puede"
                    + " quedar sin ninguna.");
            System.exit(-1);
        } else {
            nuevasCuentas = new Cuenta[getNumCuentas() - 1];
            indiceNuevasCuentas = 0;
            for (int i = 0; i < getNumCuentas(); i++) {
                if (i != pos) {
                    nuevasCuentas[indiceNuevasCuentas++] = cuentas[i];
                }
            }

            this.cuentas = nuevasCuentas;
        }
    }

    @Override
    public String toString() {
        String toret;

        toret = "Cliente " + getNombre() + " con DNI "
                + getDni() + " y domicilio en " + getDomicilio() + ". \n\n "
                + "\tDatos de sus cuentas:  ";

        for (Cuenta cuenta : this.cuentas) {
            toret += "\n\t\t" + cuenta.toString();
        }

        return toret;
    }
}
