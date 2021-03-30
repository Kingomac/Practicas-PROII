package ej7;

/**
 *
 * @author Mario
 */
public class Reunion {

    private Fecha fecha;
    private Hora hora;

    public Reunion(Fecha fecha, Hora hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

}
