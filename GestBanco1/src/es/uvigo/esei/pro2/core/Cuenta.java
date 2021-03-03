/*
 *  Definición de la clase Cuenta
 *  En un banco tendremos una serie de clientes con sus cuentas
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Cuenta {

    public static enum Tipo {
        AHORRO, CORRIENTE
    };

    private String numCuenta; // Número de cuenta del cliente
    private int ano;    // Año de apertura de la cuenta del cliente
    private Tipo tipo; // Tipo de cuenta

    /**
     * Crea una nueva cuenta del cliente, con sus datos: numero de cuenta, año
     * de apertura
     *
     * @param numCuenta número de cuenta del cliente
     * @param anho el año de apertura de la cuenta del cliente
     */
    public Cuenta(String numCuenta, int anho) {
        setNumCuenta(numCuenta);
        setAno(anho);
        setTipo(null);
    }

    /**
     * Devuelve el número de cuenta del cliente
     *
     * @return el numCuenta del cliente, como String.
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Cambia el número de cuenta del cliente
     *
     * @param nCuenta el numCuenta del cliente
     */
    public void setNumCuenta(String nCuenta) {
        numCuenta = nCuenta;
    }

    /**
     * Devuelve el año de apertura de la cuenta del cliente
     *
     * @return El valor como entero
     *
     */
    public int getAno() {
        return ano;
    }

    /**
     * Cambia el año de apertura de la cuenta del cliente
     *
     * @param ano El nuevo valor, como entero
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Devuelve el tipo de cuenta
     *
     * @return Tipo de cuenta
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo de cuenta del cliente
     *
     * @param tipo Nuevo valor como Cuenta.Tipo.*
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Proporciona todos los datos de la cuenta
     *
     * @return El valor como cadena
     */
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(getNumCuenta()).append(" ; ").append(getAno())
                .append(" ; ").append(getTipo().toString().toLowerCase());
        return toret.toString();
    }
}
