package ej2;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 *
 * Dado el siguiente código, completa con el control de excepciones que sea
 * necesario. Justifica el añadir el control de excepciones en un lugar u otro.
 *
 */
public class Ej2 {

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        int num1;
        int num2;
        num1 = leerEntero("\nIntroduzca dividendo: ");
        num2 = leerEntero("\nIntroduzca divisor: ");
        try {
            System.out.println("\nEl resultado es: " + divide(num1, num2));
        } catch (ArithmeticException exc) {
            System.out.println("No se pudo realizar la operación: " + exc.getMessage());
        }
    }

    private static int leerEntero(String mensaje) {
        // True: sigue ejecutando el bucle // False: sale del bucle
        boolean seguir;
        int num = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            try {
                num = Integer.parseInt(entrada.nextLine());
                seguir = false;
            } catch (NumberFormatException exc) {
                System.err.println("Error leyendo el número: asegurate de que es un entero: " + exc.getMessage());
                seguir = true;
            }
        } while (seguir);
        return num;
    }

}
