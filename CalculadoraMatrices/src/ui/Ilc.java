package ui;

import core.Matriz;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Ilc {

    public static void inicio() {
        System.out.println("Matriz inicial: ");
        Calculadora calc = new Calculadora(leerMatriz());
        int opcion;
        do {
            opcion = menu();
            try {
                switch (opcion) {
                    case 1 ->
                        calc.sumar(leerMatriz());
                    case 2 ->
                        calc.multiplicar(leerMatriz());
                }
                System.out.println(calc.getResultado());
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        } while (opcion != 3);
    }

    public static int menu() {
        System.out.println("1. Sumar\n2. Multiplicar\n3. Salir");
        return Ilc.leerEntero("->");
    }

    public static Matriz leerMatriz() {
        Scanner scan = new Scanner(System.in);
        boolean seguir;
        double[][] numeros = new double[0][0];
        int numColumnas = -1;
        do {
            try {
                System.out.println("Introduce una matriz(fila por fila separando los números por espacios): ");
                String lectura = scan.nextLine().trim();
                if ("".equals(lectura)) {
                    seguir = false;
                } else {
                    String[] valores = lectura.split(" ");
                    if (numColumnas == -1) {
                        numColumnas = valores.length;
                    }
                    if (valores.length > numColumnas) {
                        throw new Exception("Más columnas que la primera fila");
                    }
                    double[] fila = new double[numColumnas];
                    for (int i = 0; i < valores.length; i++) {
                        fila[i] = Double.parseDouble(valores[i]);
                    }
                    for (int i = valores.length; i < numColumnas; i++) {
                        fila[i] = 0;
                    }
                    double[][] nuevo = new double[numeros.length + 1][numColumnas];
                    for (int i = 0; i < nuevo.length - 1; i++) {
                        nuevo[i] = numeros[i];
                    }
                    nuevo[nuevo.length - 1] = fila;
                    numeros = nuevo;
                    seguir = true;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Error: " + ex.getMessage());
                seguir = true;
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
                seguir = true;
            }
        } while (seguir);
        return new Matriz(numeros);
    }

    public static int leerEntero(String mensaje) {
        Scanner scan = new Scanner(System.in);
        boolean seguir;
        int toret = 0;
        do {
            try {
                System.out.print(mensaje);
                toret = Integer.parseInt(scan.nextLine().trim());
                seguir = false;
            } catch (NumberFormatException ex) {
                System.err.println("Error, introduce un entero: " + ex.getMessage());
                seguir = true;
            }
        } while (seguir);
        return toret;
    }
}
