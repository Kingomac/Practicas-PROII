package es.uvigo.esei.pro2.core;

import java.util.Calendar;

/**
 *
 * @author Mario
 */
public class Fecha {

    public static Fecha parseFecha(String fecha) throws FechaFormatoExcepcion, NumberFormatException {
        int dia;
        int mes;
        int anho;
        String[] temp = fecha.split("/");

        if (temp.length != 3) {
            throw new FechaFormatoExcepcion();
        }
        dia = Integer.parseInt(temp[0]);
        mes = Integer.parseInt(temp[1]);
        anho = Integer.parseInt(temp[2]);
        if (!correcta(dia, mes, anho)) {
            throw new FechaFormatoExcepcion();
        }
        return new Fecha(dia, mes, anho);
    }

    public static boolean correcta(int dia, int mes, int anho) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(anho, mes - 1, dia);
        try {
            calendar.getTime();
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    private int dia;
    private int mes;
    private int anho;

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) throws FechaFormatoExcepcion {
        if (!correcta(dia, getMes(), getAnho())) {
            throw new FechaFormatoExcepcion();
        }
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) throws FechaFormatoExcepcion {
        if (!correcta(getDia(), mes, getAnho())) {
            throw new FechaFormatoExcepcion();
        }
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) throws FechaFormatoExcepcion {
        if (!correcta(getDia(), getMes(), anho)) {
            throw new FechaFormatoExcepcion();
        }
        this.anho = anho;
    }

    public void set(int dia, int mes, int anho) throws FechaFormatoExcepcion {
        if (!correcta(dia, mes, anho)) {
            throw new FechaFormatoExcepcion();
        }
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", getDia(), getMes(), getAnho());
    }

}
