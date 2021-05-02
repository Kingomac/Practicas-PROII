package ej6;

import java.io.IOException;
import java.util.Scanner;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionTransportes gestion = null;
        try {
            gestion = new GestionTransportes("transportes.xml");
            System.out.println("Datos cargados correctamente");
        } catch (ParsingException | NumberFormatException ex) {
            System.err.println("Error leyendo el archivo: " + ex.getMessage());
            System.exit(-1);
        } catch (IOException ex) {
            System.out.println("No existe un archivo de guardado");
            gestion = new GestionTransportes();
        }
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    System.out.println(gestion);
                    break;
                case 2:
                    gestion.insertar(leerVehiculo());
                    break;
                case 3:
                    borrar(gestion);
                    break;
            }
        } while (opcion != 4);
        try {
            gestion.toXML("transportes.xml");
            System.out.println("Datos guardados");
        } catch (IOException ex) {
            System.err.println("Error guardando el archivo: " + ex.getMessage());
        }
    }

    private static int menu() {
        int toret;
        do {
            System.out.println("Gestión de transportes");
            System.out.println("1. Listar");
            System.out.println("2. Insertar");
            System.out.println("3. Borrar");
            System.out.println("4. Salir");
            toret = leerEntero("-> ");
        } while (toret < 1 || toret > 4);
        return toret;
    }

    private static int leerEntero(String mensaje) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scan.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.err.println("Introduce un número entero");
            }
        }
    }

    private static String leerCadena(String mensaje) {
        Scanner scan = new Scanner(System.in);
        String toret;
        do {
            System.out.print(mensaje);
            toret = scan.nextLine().trim();
        } while (toret.equals(""));
        return toret;
    }

    private static Vehiculo leerVehiculo() {
        String matricula;
        String marca;
        String modelo;
        int tipo;

        System.out.println("Vehículo: ");
        matricula = leerCadena("\tMatrícula: ");
        marca = leerCadena("\tMarca: ");
        modelo = leerCadena("\tModelo: ");

        do {
            System.out.println("\tTipo:");
            for (int i = 0; i < Vehiculo.Tipo.values().length; i++) {
                System.out.format("\t\t%d. %s", i + 1, Vehiculo.Tipo.values()[i]);
            }
            tipo = leerEntero("\t-> ");
        } while (tipo < 1 || tipo > Vehiculo.Tipo.values().length);

        if (Vehiculo.Tipo.values()[tipo - 1] == Vehiculo.Tipo.TAXI) {
            return new Taxi(leerEntero("\tNúmero de licencia: "), matricula, marca, modelo);
        }
        return new Autobus(leerEntero("\tNúmero de plazas: "), matricula, marca, modelo);
    }

    private static void borrar(GestionTransportes gest) {
        int indice;
        do {
            indice = leerEntero("Posición a borrar(1..." + gest.getNumVehiculos() + "): ");
        } while (indice < 1 || indice > gest.getNumVehiculos());
        gest.eliminar(indice - 1);
    }

}
