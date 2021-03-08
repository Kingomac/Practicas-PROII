package ej1;

import java.util.Scanner;

/**
 *
 * Escribe un programa que acepte un número entero n, y después una secuencia de
 * n números enteros. Entonces, el programa calculará su media, mayor, y menor.
 * Captura las excepciones que se puedan producir, mostrando un mensaje
 * informativo.
 *
 * @author Mario
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 0;
        int[] valores;
        int mayor;
        int menor;
        double media;

        do {
            System.out.println("¿De cuántos números se va a hacer la media, el mayor y el menor? (mínimo 1)");
            num = leerEntero("-> ");
        } while (num < 1);

        valores = new int[num];
        media = mayor = menor = valores[0] = leerEntero("Valor 1: ");
        for (int i = 1; i < valores.length; i++) {
            valores[i] = leerEntero("Valor " + (i + 1) + ": ");
            media += valores[i];
            if (valores[i] < menor) {
                menor = valores[i];
            }
            if (valores[i] > mayor) {
                mayor = valores[i];
            }
            media += valores[i];
        }

        System.out.println("Media: " + media);
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
    }

    /*private static int leerEntero(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        int toret = 0;
        boolean seguir = false;
        do {
            System.out.print(mensaje);
            try {
                toret = Integer.parseInt(entrada.nextLine());
                seguir = false;
            } catch (NumberFormatException exc) {
                System.out.println("Error, asegúrate de estar introduciendo un número entero: " + exc.getMessage());
                seguir = true;
            }
        } while (seguir);
        return toret;
    }*/
    /**
     * Método para leer enteros mejorado
     *
     * @param msg
     * @return
     */
    public static int leerEntero(String msg) {
        int toret = 0;
        String temp;
        boolean noValido = false;   // True: si no es un entero valido
        // False: si tiene un entero valido
        Scanner teclado = new Scanner(System.in);

        do {
            try {
                noValido = false;
                System.out.print(msg);
                temp = teclado.nextLine();
                toret = Integer.parseInt(temp);
            } catch (NumberFormatException exc) {
                noValido = true;
                System.err.println("Error. Formato numerico no valido");
            }
        } while (noValido == true);

        return toret;
    }

}
