package ej7;

/**
 *
 * @author Mario
 */
public class Reunion {

    private Fecha fecha;
    private Hora hora;
    private Persona[] asistentes;

    public Reunion(Fecha fecha, Hora hora, Persona... asistentes) {
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = asistentes;
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

    public Persona[] getAsistentes() {
        return asistentes;
    }

    public void insertarAsistente(Persona p) {
        Persona[] nuevos = new Persona[asistentes.length + 1];
        for (int i = 0; i < asistentes.length; i++) {
            nuevos[i] = asistentes[i];
        }
        nuevos[asistentes.length] = p;
        asistentes = nuevos;
    }

    public void eliminarAsistente(int pos) throws AsistenteIndiceExcepcion {
        if (pos < 0 || pos >= asistentes.length) {
            throw new AsistenteIndiceExcepcion();
        }
        Persona[] nuevos = new Persona[asistentes.length - 1];
        asistentes[pos] = asistentes[asistentes.length - 1];
        for (int i = 0; i < nuevos.length; i++) {
            nuevos[i] = asistentes[i];
        }
        asistentes = nuevos;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Reunión:\n\tFecha: ").append(getFecha()).append("\n\tHora: ")
                .append(getHora());
        return toret.toString();
    }
}
