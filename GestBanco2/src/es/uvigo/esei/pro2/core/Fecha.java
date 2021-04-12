package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class Fecha {

    public static Fecha parse(String fecha) throws FechaFormatoException, NumberFormatException {
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
        if (mes == 2) {
            if (dia != 29 && anho % 4 == 0 && anho % 100 != 0 && anho % 400 == 0) {
                return false;
            }
            if (dia != 28) {
                return false;
            }
            return true;
        }
        if (dia > 31 || mes > 12 || anho < 1900 || dia < 1 || mes < 1) {
            return false;
        }
        if (mes % 2 != 0 && dia > 31) {
            return false;
        }
        if (mes % 2 == 0 && dia > 30) {
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

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", getDia(), getMes(), getAnho());
    }

}
