package es.uvigo.esei.pro2.core;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 */
public class Ahorro extends Cuenta {

    private double interes;

    public Ahorro(double interes, String numCuenta, Fecha fechaApertura) {
        super(numCuenta, fechaApertura);
        this.interes = interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public int getTipo() {
        return 0;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.00");
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Intereses: ").append(format.format(getInteres())).append("%");
        return toret.toString();
    }
}
