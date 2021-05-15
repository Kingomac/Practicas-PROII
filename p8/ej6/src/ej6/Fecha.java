package ej6;

import java.util.Calendar;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Fecha {

    public static enum Etq {
        FECHA, DIA, MES, ANHO
    }

    public static Fecha parseFecha(String fecha) throws FechaFormatoException, NumberFormatException {
        int dia;
        int mes;
        int anho;
        String[] temp = fecha.split("/");

        if (temp.length != 3) {
            throw new FechaFormatoException();
        }
        dia = Integer.parseInt(temp[0]);
        mes = Integer.parseInt(temp[1]);
        anho = Integer.parseInt(temp[2]);
        if (!correcta(dia, mes, anho)) {
            throw new FechaFormatoException();
        }
        return new Fecha(dia, mes, anho);
    }

    public static boolean correcta(int dia, int mes, int anho) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(anho, mes - 1, dia);
        try {
            calendar.getTime();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean correcta(Fecha f) {
        return correcta(f.getDia(), f.getMes(), f.getAnho());
    }

    private int dia;
    private int mes;
    private int anho;

    public Fecha(Element el) throws ParsingException, NumberFormatException {
        Element elDia = el.getFirstChildElement(Etq.DIA.name());
        Element elMes = el.getFirstChildElement(Etq.MES.name());
        Element elAnho = el.getFirstChildElement(Etq.ANHO.name());

        if (elDia == null) {
            throw new ParsingException("Falta el día de la fecha");
        }
        if (elMes == null) {
            throw new ParsingException("Falta el mes de la fecha");
        }
        if (elAnho == null) {
            throw new ParsingException("Falta el año de la fecha");
        }

        this.dia = Integer.parseInt(elDia.getValue());
        this.mes = Integer.parseInt(elMes.getValue());
        this.anho = Integer.parseInt(elAnho.getValue());
    }

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", getDia(), getMes(), getAnho());
    }

    public Element toDOM() {
        Element elFecha = new Element(Etq.FECHA.name());
        Element elDia = new Element(Etq.DIA.name());
        Element elMes = new Element(Etq.MES.name());
        Element elAnho = new Element(Etq.ANHO.name());

        elDia.appendChild(Integer.toString(getDia()));
        elMes.appendChild(Integer.toString(getMes()));
        elAnho.appendChild(Integer.toString(getAnho()));

        elFecha.appendChild(elDia);
        elFecha.appendChild(elMes);
        elFecha.appendChild(elAnho);

        return elFecha;
    }

}
