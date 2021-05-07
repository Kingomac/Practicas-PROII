/*
 *  Definición de la clase Cuenta
 *  En un banco tendremos una serie de clientes con sus cuentas bancarias
 */
package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

public abstract class Cuenta {

    public static enum Etq {
        NUM_CUENTA, FECHA_APERTURA, CUENTA
    }

    public static enum Tipo {
        AHORRO, CORRIENTE
    }

    public static Tipo getTipo(Cuenta c) {
        if (c instanceof Ahorro) {
            return Tipo.AHORRO;
        }
        return Tipo.CORRIENTE;
    }

    private String numCuenta;   // Numero de cuenta
    private Fecha fechaApertura;   // Año de apertura de la cuenta

    public Cuenta(Element el) throws ParsingException {
        Element elNumCuenta = el.getFirstChildElement(Etq.NUM_CUENTA.name());
        Element elFechaApertura = el.getFirstChildElement(Etq.FECHA_APERTURA.name());

        if (elNumCuenta == null) {
            throw new ParsingException("Falta el número de cuenta");
        }
        if (elFechaApertura == null) {
            throw new ParsingException("Falta la fecha de apertura");
        }

        numCuenta = elNumCuenta.getValue();
        fechaApertura = new Fecha(elFechaApertura);
    }

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

    public Tipo getTipo() {
        return Cuenta.getTipo(this);
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

    public Element toDom() {
        Element cuenta = new Element(Etq.CUENTA.name());
        Element elNumCuenta = new Element(Etq.NUM_CUENTA.name());
        Element elFechaApertura = fechaApertura.toDom();

        elNumCuenta.appendChild(getNumCuenta());
        elFechaApertura.setLocalName(Etq.FECHA_APERTURA.name());

        cuenta.appendChild(elNumCuenta);
        cuenta.appendChild(elFechaApertura);

        return cuenta;
    }

}
