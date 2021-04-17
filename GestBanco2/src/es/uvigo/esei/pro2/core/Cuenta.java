/*
 *  Definición de la clase Cuenta
 *  En un banco tendremos una serie de clientes con sus cuentas bancarias
 */
package es.uvigo.esei.pro2.core;

public abstract class Cuenta {

    private static final String[] tipos = new String[]{"Ahorro", "Corriente"};

    public static String[] getTipos() {
        return tipos;
    }

    public static String getTipo(Cuenta cuenta) {
        if (cuenta instanceof Ahorro) {
            return tipos[0];
        }
        return tipos[1];
    }

    private String numCuenta;   // Numero de cuenta
    private Fecha fechaApertura;   // Año de apertura de la cuenta

    /**
     * Crea una nueva cuenta del cliente, con sus datos: numero de cuenta, año
     * de apertura y tipo de cuenta (ahorro o corriente)
     *
     * @param numCuenta número de cuenta del cliente
     * @param fechaApertura el año de apertura de la cuenta del cliente
     */
    public Cuenta(String numCuenta, Fecha fechaApertura) {

        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
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
    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Cambia el año de apertura de la cuenta del cliente
     *
     * @param fecha El nuevo valor, como entero
     */
    public void setFechaApertura(Fecha fecha) {
        this.fechaApertura = fecha;
    }

    /**
     * Devuelve los datos de una cuenta
     *
     * @return los datos de una cuenta, como cadena
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Cuenta numero ").append(getNumCuenta());
        toret.append("; Año de apertura: ").append(getFechaApertura());

        return toret.toString();
    }

}
