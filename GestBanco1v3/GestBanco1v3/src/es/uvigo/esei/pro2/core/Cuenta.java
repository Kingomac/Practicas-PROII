/*
 *  Definición de la clase Cuenta
 *  En un banco tendremos una serie de clientes con sus cuentas bancarias
 */
package es.uvigo.esei.pro2.core;

public class Cuenta {

    public static enum Tipo {
        AHORRO, CORRIENTE
    };

    private String numCuenta;   // Numero de cuenta
    private int anhoApertura;   // Año de apertura de la cuenta
    private Tipo tipo;

    /**
     * Crea una nueva cuenta del cliente, con sus datos: numero de cuenta, año
     * de apertura y tipo de cuenta (ahorro o corriente)
     *
     * @param numCuenta número de cuenta del cliente
     * @param anhoApertura el año de apertura de la cuenta del cliente
     * @param tipo tipo de cuenta
     */
    public Cuenta(String numCuenta, int anhoApertura, Tipo tipo) {

        this.numCuenta = numCuenta;
        this.anhoApertura = anhoApertura;
        this.tipo = tipo;
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
    public int getAnho() {
        return anhoApertura;
    }

    /**
     * Cambia el año de apertura de la cuenta del cliente
     *
     * @param ano El nuevo valor, como entero
     */
    public void setAnho(int ano) {
        this.anhoApertura = ano;
    }

    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo de cuenta
     *
     * @param tipo Nuevo valor como Cuenta.Tipo
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return Datos de la cuenta en formato => "Cuenta número: ...; Año de
     * apertura: ...; Tipo: ...
     */
    @Override
    public String toString() {
        return String.format("Cuenta número: %s; Año de apertura: %d; Tipo: %s",
                getNumCuenta(), getAnho(), getTipo().toString().toLowerCase());
    }
}
