package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class Senior extends Cuenta {

    public static final int MIN_EDAD = 65; // Edad mínima para crear la cuenta

    private final Fecha fechaRenovacion;

    /**
     * Crea una cuenta de tipo Senior
     *
     * @param numCuenta número de cuenta como String
     * @param fechaApertura fecha de apertura como Fecha
     */
    public Senior(String numCuenta, Fecha fechaApertura) {
        super(numCuenta, fechaApertura);
        int dia = fechaApertura.getDia();
        int mes = fechaApertura.getMes();
        int anho = fechaApertura.getAnho() + 5;
        // Se comprueba si la fecha es correcta porque podría salir que
        // tuviese la fecha de renovación un 29 de febrero que no existe
        if (!Fecha.correcta(dia, mes, anho)) {
            dia--;
        }
        fechaRenovacion = new Fecha(dia, mes, anho);
    }

    /**
     * Devuelve la fecha de renovación
     *
     * @return Fecha fecha de renovación
     */
    public Fecha getFechaRenovacion() {
        return fechaRenovacion;
    }

    /**
     * Devuelve la información de la cuenta como String
     *
     * @return (datos generales de la cuenta); Fecha de renovación: dd/mm/yyy
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Fecha de renovación: ").append(getFechaRenovacion());
        return toret.toString();
    }

}
