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

    private String marca;
    private String modelo;
    private int numPuertas;
    private double capacidad; // m^3
    private Tipo tipo;
    private int caballos; // cv

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

    public Coche() {
        this.marca = "";
        this.modelo = "";
        this.numPuertas = 0;
        this.capacidad = 0;
        this.tipo = Tipo.BERLINA;
        this.caballos = 0;
    }

    /**
     *
     * @return Devuelve la marca del coche
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @return Devuelve el modelo del coche
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @return Devuelve el número de puertas del coche
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     *
     * @return Devuelve la capacidad del maletero del coche en metros cúbicos
     */
    public double getCapacidad() {
        return capacidad;
    }

    /**
     *
     * @return Devuelve el tipo según el enumerado Tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     *
     * @return Devuelve los caballos en cv del coche
     */
    public int getCaballos() {
        return caballos;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    /**
     *
     * @return Devuelve el coche con el formato: "marca modelo (tipo, cv CV),
     * numPuertas PUERTAS, MALETERO de capacidad METROS CÚBICOS"
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
