package ej7;

/**
 *
 * @author Mario
 */
public class ReunionPeriodica extends Reunion {

    public static enum Periodo {
        DIARIA, SEMANAL, MENSUAL, TRIMESTRAL
    }

    private Periodo frecuencia;

    public ReunionPeriodica(Periodo frecuencia, Fecha fecha, Hora hora) {
        super(fecha, hora);
        this.frecuencia = frecuencia;
    }

    public Periodo getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Periodo frecuencia) {
        this.frecuencia = frecuencia;
    }

}
