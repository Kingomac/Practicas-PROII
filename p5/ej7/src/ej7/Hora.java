package ej7;

/**
 *
 * @author Mario
 */
public class Hora {

    private int horas;
    private int minutos;
    private int segundos;

    public Hora(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas >= 60) {
            throw new HoraIncorrectaException("Horas mayor que 60");
        }
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos >= 60) {
            throw new HoraIncorrectaException("Minutos mayor que 60");
        }
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) throws HoraIncorrectaException {
        if (segundos >= 60) {
            throw new HoraIncorrectaException("Segundos mayor que 60");
        }
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", getHoras(), getMinutos());
    }
}
