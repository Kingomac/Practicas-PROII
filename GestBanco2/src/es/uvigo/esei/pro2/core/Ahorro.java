package es.uvigo.esei.pro2.core;

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
    public String toString() {
        return String.format("%s; Intereses: %.2f", super.toString(), getInteres());
    }
}
