package es.uvigo.esei.pro2.core;

import java.text.DecimalFormat;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Ahorro extends Cuenta {

    public static enum Etq {
        CUENTA_AHORRO, INTERES
    }

    private double interes;

    public Ahorro(Element el) throws ParsingException, NumberFormatException {
        super(el);
        Element elInteres = el.getFirstChildElement(Etq.INTERES.name());

        if (elInteres == null) {
            throw new ParsingException("Falta el interés de la cuenta");
        }

        interes = Double.parseDouble(elInteres.getValue());
    }

    /**
     * Crea una cuenta de Ahorro
     *
     * @param interes double % de interés de la cuenta
     * @param numCuenta String número de cuenta
     * @param fechaApertura Fecha de apertura
     */
    public Ahorro(double interes, String numCuenta, Fecha fechaApertura) {
        super(numCuenta, fechaApertura);
        this.interes = interes;
    }

    /**
     * Devuelve el % de interés de la cuenta como double
     *
     * @return % interés
     */
    public double getInteres() {
        return interes;
    }

    /**
     * Cambia el % de interés de la cuenta
     *
     * @param interes double nuevo interés
     */
    public void setInteres(double interes) {
        this.interes = interes;
    }

    /**
     * String con la información de la cuenta
     *
     * @return (datos de cuenta); Intereses: 0.00%s
     */
    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.00");
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Intereses: ").append(format.format(getInteres())).append("%");
        return toret.toString();
    }

    @Override
    public Element toDom() {
        Element elCuenta = super.toDom();
        Element elInteres = new Element(Etq.INTERES.name());

        elCuenta.setLocalName(Etq.CUENTA_AHORRO.name());
        elInteres.appendChild(Double.toString(getInteres()));

        elCuenta.appendChild(elInteres);

        return elCuenta;
    }
}
