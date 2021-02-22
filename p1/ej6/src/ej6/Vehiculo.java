package ej6;

/**
 *
 * @author Mario
 *
 * La información relevante de un vehículo es el número máximo de pasajeros, la
 * capacidad del depósito (en litros) y el consumo medio de combustible (litros
 * a los 100 km). Un ejemplo sería un vehículo de 4 pasajeros, depósito de 60
 * litros y consumo medio de 6 litros. Además de los métodos habituales
 * implementar métodos para obtener la distancia (en km) que podría recorrer con
 * el depósito lleno, así como la distancia que podría recorrer con un
 * determinado número de litros en el depósito.
 *
 */
public class Vehiculo {

    private int maxPasajeros;
    private float litrosDeposito;
    private float consumoMedio;

    public Vehiculo(int maxPasajeros, float litrosDeposito, float consumoMedio) {
        this.maxPasajeros = maxPasajeros;
        this.litrosDeposito = litrosDeposito;
        this.consumoMedio = consumoMedio;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public float getLitrosDeposito() {
        return litrosDeposito;
    }

    public float getConsumoMedio() {
        return consumoMedio;
    }

    public float getDistanciaDepositoLleno() {
        return litrosDeposito * 100 / consumoMedio;
    }

    public float getDistanciaDadoConsumo(float consumo) {
        return consumo * 100 / consumoMedio;
    }

    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Vehiculo\n\t");
        toret.append("Capacidad pasajeros: ");
        toret.append(getMaxPasajeros());
        toret.append("\n\tCapacidad combustible: ");
        toret.append(getLitrosDeposito());
        toret.append(" litros\n\tConsumo medio: ");
        toret.append(getConsumoMedio());
        toret.append(" litros cada 100 Km");
        return toret.toString();
    }
}
