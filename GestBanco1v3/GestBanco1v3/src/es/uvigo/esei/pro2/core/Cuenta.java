/*
 *  Definición de la clase Cuenta
 *  En un banco tendremos una serie de clientes con sus cuentas bancarias
 */
package es.uvigo.esei.pro2.core;

public class Cuenta {

    public static final double MIN_SALDO = -10000;

    public static enum Tipo {
        AHORRO, CORRIENTE, VIVIENDA
    };

    private String numCuenta;   // Numero de cuenta
    private int anhoApertura;   // Año de apertura de la cuenta
    private Tipo tipo;
    private double saldo;

    /**
     * Crea una nueva cuenta del cliente, con sus datos: numero de cuenta, año
     * de apertura y tipo de cuenta (ahorro o corriente)
     *
     * @param numCuenta número de cuenta del cliente
     * @param anhoApertura el año de apertura de la cuenta del cliente
     * @param tipo tipo de cuenta
     * @param saldo saldo inicial de la cuenta
     */
    public Cuenta(String numCuenta, int anhoApertura, Tipo tipo, double saldo) {

        this.numCuenta = numCuenta;
        this.anhoApertura = anhoApertura;
        this.tipo = tipo;
        this.saldo = saldo;
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

    /**
     * Devuelve el tipo de cuenta
     *
     * @return Tipo de cuenta como Cuenta.Tipo
     */
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
     * Devuelve el saldo de la cuenta
     *
     * @return double Saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Cambia el saldo
     *
     * @param saldo double Nuevo saldo
     * @throws Exception El saldo debe ser mayor a MIN_SALDO
     */
    public void setSaldo(double saldo) throws Exception {
        if (saldo < MIN_SALDO) {
            throw new Exception(String.format("El saldo no puede ser menor a %#.2f", MIN_SALDO));
        }
        this.saldo = saldo;
    }

    /**
     *
     * @return Datos de la cuenta en formato => "Cuenta número: ...; Año de
     * apertura: ...; Tipo: ...; Saldo: ...
     */
    @Override
    public String toString() {
        return String.format("Cuenta número: %s; Año de apertura: %d; Tipo: %s;"
                + " Saldo: %#.2f",
                getNumCuenta(), getAnho(), getTipo().toString().toLowerCase(),
                getSaldo());
    }
}
