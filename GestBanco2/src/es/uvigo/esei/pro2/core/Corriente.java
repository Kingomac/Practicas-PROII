package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class Corriente extends Cuenta {

    private String numeroTarjeta;
    private Fecha fechaCaducidad;

    public Corriente(String numeroTarjeta, Fecha fechaCaducidad, String numCuenta, Fecha fechaApertura) {
        super(numCuenta, fechaApertura);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }

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

}
