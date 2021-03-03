/*
 * Definicion de la clase Cliente
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Cliente {

    private String dni; // D.N.I. del cliente
    private String nombre;  // Nombre completo del cliente
    private String domicilio;  // Domicilio del cliente

    private Cuenta[] cuentas; // Cuentas del cliente
    private int numCuentas; // Numero de cuentas que posee el cliente

    /**
     * Crea un nuevo cliente, con sus datos: nombre, domicilio y aÃ±o
     *
     * @param d D.N.I. del cliente
     * @param nombre nombre completo del cliente
     * @param domicilio el domicilio del cliente
     * @param numCuentas numero de cuentas que tiene el cliente
     */
    public Cliente(String d, String nombre, String domicilio,
            int numCuentas) {
        this.setDni(d);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setNumCuentas(numCuentas);
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
     * Cambia el D.N.I.del cliente
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
     * Devuelve el número de cuentas que tiene el cliente
     *
     * @return el número de cuentas, como int.
     */
    public int getNumCuentas() {
        return numCuentas;
    }

    /**
     * Cambia el número de cuentas que tine el cliente
     *
     * @param numCuentas El nuevo valor, como int.
     */
    public void setNumCuentas(int numCuentas) {
        this.numCuentas = numCuentas;
        cuentas = new Cuenta[numCuentas];
        for (int i = 0; i < numCuentas; i++) {
            Cuenta cu = new Cuenta("", 0);
            cuentas[i] = cu;
        }
    }

    /**
     * Devuelve la cuenta especificada por el índice
     *
     * @param pos la posición de la cuenta a obtener, como int
     * @return la cuenta especificada, como Cuenta.
     * @throws Exception cuando se accede a una posición inválida
     */
    public Cuenta getCuenta(int pos) throws Exception {
        if (pos >= getNumCuentas() || pos < 0) {
            throw new Exception("getCuenta(): intenta acceder a una posición inválida: " + (pos + 1));
        }
        return cuentas[pos];
    }

    /**
     * Cambia la cuenta espcificada por el índice
     *
     * @param pos la posición de la cuenta a modificar, como int
     * @param cu el nuevo valor de la cuenta, como cuenta
     */
    public void setCuenta(int pos, Cuenta cu) throws Exception {
        if (pos >= getNumCuentas() || pos < 0) {
            throw new Exception("setCuenta(pos, cu): intenta acceder a una posición inválida: " + (pos + 1));
        }
        cuentas[pos] = cu;
    }

    /**
     * Proporciona todos los datos del cliente
     *
     * @return El valor como cadena
     */
    public String toString() {
        StringBuilder toret = new StringBuilder("Datos del cliente: ");
        toret.append(getDni()).append(" ; ").append(getNombre()).append(" ; ")
                .append(getDomicilio()).append("\n\tDatos de sus cuentas");
        for (int i = 0; i < getNumCuentas(); i++) {
            toret.append("\n\t\t").append(cuentas[i]);
        }
        return toret.toString();
    }

}
