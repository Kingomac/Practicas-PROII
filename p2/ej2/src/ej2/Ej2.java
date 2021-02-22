package ej2;

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

}
