package ej2;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 * Los coches se definen por su marca (marca), modelo (modelo), número de
 * puertas (numPuertas), capacidad del maletero en metros cúbicos (capacidad),
 * el tipo de coche (tipo, que puede ser MONOVOLUMEN, FAMILIAR, COMPACTO,
 * BERLINA y CAMIONETA) y número de caballos (cv). Se expresan como "marca
 * modelo (tipo, cv CV), numPuertas PUERTAS, MALETERO de capacidad METROS
 * CÚBICOS". El coche de referencia es un "Volkswagen Escarabajo (COMPACTO, 61
 * CV), 4 PUERTAS, MALETERO de 100 METROS CÚBICOS".
 *
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coche c1 = new Coche("Volkswagen", "Escarabajo", 4, 100, Coche.Tipo.COMPACTO, 61);
        System.out.println(c1);
    }

    private static Coche leerCoche() {
        int numTipo;
        Coche toret = new Coche();
        System.out.println("Introduce un coche:");
        toret.setMarca(leerCampoObligatorio("\tMarca: "));
        toret.setModelo(leerCampoObligatorio("\tModelo: "));
        toret.setNumPuertas(Integer.parseInt(leerCampoObligatorio("\tPuertas:")));
        toret.setCapacidad(Double.parseDouble(leerCampoObligatorio("\tCapacidad: ")));
        /*  FORMA 1
        do {
            numTipo = Integer.parseInt(leerCampoObligatorio("Tipo de coche (1. "
                    + "Berlina, 2. Camioneta, 3. Compacto, 4. Familiar o 5. "
                    + "Monovolumen): "));
        } while (numTipo < 1 || numTipo > 5);
        switch (numTipo) {
            case 1:
                toret.setTipo(Coche.Tipo.BERLINA);
                break;
            case 2:
                toret.setTipo(Coche.Tipo.CAMIONETA);
                break;
            case 3:
                toret.setTipo(Coche.Tipo.COMPACTO);
                break;
            case 4:
                toret.setTipo(Coche.Tipo.FAMILIAR);
                break;
            default:
                toret.setTipo(Coche.Tipo.MONOVOLUMEN);
        }*/
 /* FORMA 2
        do {
            System.out.println("Introduce un coche:");
            for (int i = 0; i < Coche.Tipo.values().length; i++) {
                System.out.println((i + 1) + ": " + Coche.Tipo.values()[i]);
            }
            numTipo = Integer.parseInt(leerCampoObligatorio("-> "));
        } while (numTipo < 1 || numTipo > Coche.Tipo.values().length);
        toret.setTipo(Coche.Tipo.values()[numTipo - 1]);
         */

        // FORMA 3
        do {
            for (Coche.Tipo t : Coche.Tipo.values()) {
                System.out.println((t.ordinal() + 1) + ". " + t);
            }
            numTipo = Integer.parseInt(leerCampoObligatorio("-> "));
        } while (numTipo < 1 || numTipo > Coche.Tipo.values().length);
        toret.setTipo(Coche.Tipo.values()[numTipo - 1]);
        //FIN FORMA 3

        toret.setCaballos(Integer.parseInt(leerCampoObligatorio("\tCaballos: ")));
        return toret;
    }

    private static String leerCampoObligatorio(String mensaje) {
        String toret;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            toret = entrada.nextLine().trim();
        } while ("".equals(toret));
        return toret;
    }

}
