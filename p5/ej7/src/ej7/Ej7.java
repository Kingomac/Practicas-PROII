package ej7;

/**
 *
 * @author Mario
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reunion r1 = new Reunion(new Fecha(15, 4, 2021), new Hora(10, 30));
        Reunion r2 = new ReunionPeriodica(ReunionPeriodica.Periodo.SEMANAL, new Fecha(18, 5, 2021), new Hora(11, 0));
        System.out.println(r1);
        System.out.println(r2);
    }

}
