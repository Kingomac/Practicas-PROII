package es.uvigo.esei.pro2.core;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 */
public class Ahorro extends Cuenta {

    private double interes;

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
}
