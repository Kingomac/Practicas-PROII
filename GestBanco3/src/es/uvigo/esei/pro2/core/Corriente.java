package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Corriente extends Cuenta {

    public static enum Etq {
        CUENTA_CORRIENTE, NUM_TARJETA, FECHA_CADUCIDAD
    }

    private String numeroTarjeta;
    private Fecha fechaCaducidad;

    public Corriente(Element el) throws ParsingException {
        super(el);
        Element elNumTarjeta = el.getFirstChildElement(Etq.NUM_TARJETA.name());
        Element elFechaCaducidad = el.getFirstChildElement(Etq.FECHA_CADUCIDAD.name());

        if (elNumTarjeta == null) {
            throw new ParsingException("Falta el número de tarjeta");
        }
        if (elFechaCaducidad == null) {
            throw new ParsingException("Falta la fecha de caducidad de la tarjeta");
        }

        numeroTarjeta = elNumTarjeta.getValue();
        fechaCaducidad = new Fecha(elFechaCaducidad);
    }

    /**
     * Crea una cuenta corriente
     *
     * @param numeroTarjeta String número de la tarjeta asociada
     * @param fechaCaducidad Fecha caducidad de la tarjeta asociada
     * @param numCuenta String número de cuenta
     * @param fechaApertura Fecha fecha de apertura de la cuenta
     */
    public Corriente(String numeroTarjeta, Fecha fechaCaducidad, String numCuenta, Fecha fechaApertura) {
        super(numCuenta, fechaApertura);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Devuelve el número de la tarjeta asociada a la cuenta
     *
     * @return String número de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Cambia el número de la tarjeta asociada
     *
     * @param numeroTarjeta String nuevo número de tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Devuelve la fecha de caducidad de la tarjeta asociada
     *
     * @return fecha de caducidad como Fecha
     */
    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Cambia la fecha de caducidad de la tarjeta asociada
     *
     * @param fechaCaducidad nueva Fecha de caducidad
     */
    public void setFechaCaducidad(Fecha fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Número de tarjeta: ").append(getNumeroTarjeta())
                .append("; Fecha de caducidad: ").append(getFechaCaducidad());
        return toret.toString();
    }

    @Override
    public Element toDom() {
        Element elCuenta = super.toDom();
        Element elNumTarjeta = new Element(Etq.NUM_TARJETA.name());
        Element elFechaCaducidad = fechaCaducidad.toDom();

        elCuenta.setLocalName(Etq.CUENTA_CORRIENTE.name());
        elFechaCaducidad.setLocalName(Etq.FECHA_CADUCIDAD.name());
        elNumTarjeta.appendChild(getNumeroTarjeta());

        elCuenta.appendChild(elNumTarjeta);
        elCuenta.appendChild(elFechaCaducidad);

        return elCuenta;
    }

}
