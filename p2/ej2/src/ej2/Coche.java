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
public class Coche {

    public static enum Tipo {
        MONOVOLUMEN, FAMILIAR, COMPACTO, BERLINA, CAMIONETA
    };

    private final String marca;
    private final String modelo;
    private final int numPuertas;
    private final double capacidad; // m^3
    private final Tipo tipo;
    private final int caballos;

    /**
     * Crea un vehículo asignando todos sus atributos
     *
     * @param marca
     * @param modelo
     * @param numPuertas
     * @param capacidad en metros cúbicos
     * @param tipo
     * @param caballos en cv
     */
    public Coche(String marca, String modelo, int numPuertas, double capacidad, Tipo tipo, int caballos) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.caballos = caballos;
    }

    /**
     * Devuelve la marca del coche
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve el modelo del coche
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devuelve el número de puertas del coche
     *
     * @return
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     * Devuelve la capacidad del maletero del coche en metros cúbicos
     *
     * @return
     */
    public double getCapacidad() {
        return capacidad;
    }

    /**
     * Devuelve el tipo según el enumerado Tipo
     *
     * @return
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Devuelve los caballos en cv del coche
     *
     * @return
     */
    public int getCaballos() {
        return caballos;
    }

    /**
     * Devuelve el coche con el formato: "marca modelo (tipo, cv CV), numPuertas
     * PUERTAS, MALETERO de capacidad METROS CÚBICOS"
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(getMarca());
        toret.append(" ");
        toret.append(getModelo());
        toret.append(" (");
        toret.append(getTipo().toString());
        toret.append(", ");
        toret.append(getCaballos());
        toret.append(" CV");
        toret.append("), ");
        toret.append(getNumPuertas());
        toret.append(" PUERTAS , MALETERO de ");
        toret.append(getCapacidad());
        toret.append(" METROS CÚBICOS");
        return toret.toString();
    }
}
