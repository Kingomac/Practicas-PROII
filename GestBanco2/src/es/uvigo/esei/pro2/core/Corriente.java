package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class Corriente extends Cuenta {

    private String numeroTarjeta;
    private Fecha fechaCaducidad;

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

}
