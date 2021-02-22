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
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo(4, 60, 6);
        System.out.println(v.toString());
        System.out.println("\tDistancia depósito lleno: " + v.getDistanciaDepositoLleno());
        System.out.println("\tDistancia 10 litros: " + v.getDistanciaDadoConsumo(10));
    }

}
