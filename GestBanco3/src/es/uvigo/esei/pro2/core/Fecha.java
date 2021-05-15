package es.uvigo.esei.pro2.core;

import excepciones.FechaFormatoExcepcion;
import java.util.Calendar;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Fecha {

    private static final String ETQ_FECHA = "fecha";
    private static final String ETQ_DIA = "dia";
    private static final String ETQ_MES = "mes";
    private static final String ETQ_ANHO = "anho";

    /**
     * Convierte un String que contenga una fecha en formato dd/mm/yyy en una
     * Fecha
     *
     * @param fecha String a convertir
     * @return Fecha
     * @throws FechaFormatoExcepcion La fecha no es correcta
     * @throws NumberFormatException No se pueden convertir los números a
     * enteros
     */
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

    /**
     * Comprueba si una fecha es correcta
     *
     * @param dia
     * @param mes
     * @param anho
     * @return true: la fecha es correcta; false: la fecha es incorrecta
     */
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

    public Fecha(Element el) throws ParsingException, NumberFormatException {
        Element elDia = el.getFirstChildElement(ETQ_DIA);
        Element elMes = el.getFirstChildElement(ETQ_MES);
        Element elAnho = el.getFirstChildElement(ETQ_ANHO);

        if (elDia == null) {
            throw new ParsingException("Falta el día");
        }
        if (elMes == null) {
            throw new ParsingException("Falta el mes");
        }
        if (elAnho == null) {
            throw new ParsingException("Falta el año");
        }

        dia = Integer.parseInt(elDia.getValue());
        mes = Integer.parseInt(elMes.getValue());
        anho = Integer.parseInt(elAnho.getValue());
    }

    /**
     * Crea una fecha
     *
     * @param dia
     * @param mes
     * @param anho
     */
    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    /**
     * Devuelve el día de la fecha
     *
     * @return int día
     */
    public int getDia() {
        return dia;
    }

    /**
     * Cambia el día de la fecha comprobando si es correcta
     *
     * @param dia int nuevo valor del día
     * @throws FechaFormatoExcepcion se produce si la fecha nueva no es correcta
     */
    public void setDia(int dia) throws FechaFormatoExcepcion {
        if (!correcta(dia, getMes(), getAnho())) {
            throw new FechaFormatoExcepcion();
        }
        this.dia = dia;
    }

    /**
     * Devuelve el mes de la fecha
     *
     * @return int mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Cambia el mes de la fecha comprobando si es correcta
     *
     * @param mes int nuevo valor del mes
     * @throws FechaFormatoExcepcion se produce si la fecha nueva no es correcta
     */
    public void setMes(int mes) throws FechaFormatoExcepcion {
        if (!correcta(getDia(), mes, getAnho())) {
            throw new FechaFormatoExcepcion();
        }
        this.mes = mes;
    }

    /**
     * Devuelve el año de la fecha
     *
     * @return int año
     */
    public int getAnho() {
        return anho;
    }

    /**
     * Cambia el año de la fecha comprobando si es correcta
     *
     * @param anho int nuevo valor del año
     * @throws FechaFormatoExcepcion se produce si la fecha nueva no es correcta
     */
    public void setAnho(int anho) throws FechaFormatoExcepcion {
        if (!correcta(getDia(), getMes(), anho)) {
            throw new FechaFormatoExcepcion();
        }
        this.anho = anho;
    }

    /**
     * Cambia todos los valores de la fecha
     *
     * @param dia int nuevo día
     * @param mes int nuevo mes
     * @param anho int nuevo año
     * @throws FechaFormatoExcepcion se produce si la fecha nueva no es correcta
     */
    public void set(int dia, int mes, int anho) throws FechaFormatoExcepcion {
        if (!correcta(dia, mes, anho)) {
            throw new FechaFormatoExcepcion();
        }
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    /**
     * Devuelve la fecha en formato dd/mm/yyy
     *
     * @return Fecha como String dd/mm/yyy
     */
    @Override
    public String toString() {
        return String.format("%d/%d/%d", getDia(), getMes(), getAnho());
    }

    public Element toDOM() {
        Element fecha = new Element(ETQ_FECHA);
        Element elDia = new Element(ETQ_DIA);
        Element elMes = new Element(ETQ_MES);
        Element elAnho = new Element(ETQ_ANHO);

        elDia.appendChild(Integer.toString(getDia()));
        elMes.appendChild(Integer.toString(getMes()));
        elAnho.appendChild(Integer.toString(getAnho()));

        fecha.appendChild(elDia);
        fecha.appendChild(elMes);
        fecha.appendChild(elAnho);

        return fecha;

    }

}
