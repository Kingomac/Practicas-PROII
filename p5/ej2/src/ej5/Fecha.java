package ej5;

/**
 *
 * @author Mario
 */
public class Fecha {

    private int anho;
    private int mes;
    private int dia;

    public Fecha(int dia, int mes, int anho) {
        this.anho = anho;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", getDia(), getMes(), getAnho());
    }
}
