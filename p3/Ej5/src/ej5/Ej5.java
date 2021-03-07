package ej5;

import java.util.Scanner;

/**
 *
 * @author Mario
 *
 * Modifica la clase Deportista (https://ideone.com/zTygxi) añadiendo el
 * atributo edad, y modifica la gestión de errores para utilizar excepciones.
 *
 */
public class Ej5 {

    private static Scanner entrada;

    public static void main(String[] args) {

        entrada = new Scanner(System.in);
        Contenedor pabellon = new Contenedor(100);

        Deportista deportista1 = leeDeportista();
        /*Deportista deportista1 = new Deportista("12345678A","Pedro Cuesta",
        				Deportista.Categoria.SENIOR);*/
        pabellon.inserta(deportista1);

        Deportista deportista2 = leeDeportista();
        /*Deportista deportista2 = new Deportista("87654321Z", "Antonio García",
        					Deportista.Categoria.CADETE);*/
        pabellon.inserta(deportista2);

        System.out.println();
        System.out.println(pabellon.get(0));
        System.out.println(pabellon.get(1));

    }

    /**
     * método estático para leer los datos de un deportista
     *
     * @return los datos del deportista, un objeto Deportista
     */
    public static Deportista leeDeportista() {

        String dni;
        String nombre;
        char car;
        Deportista.Categoria categoria = Deportista.Categoria.BENJAMIN;
        int edad;
        Deportista toret = null;

        do {
            System.out.print("Introduce DNI: ");
            dni = entrada.nextLine();
        } while ("".equals(dni.trim()));

        do {
            System.out.print("Introduce nombre y apellidos: ");
            nombre = entrada.nextLine();
        } while ("".equals(nombre.trim()));

        do {
            System.out.print("Introduce categoría: "
                    + "(B)enjamin, (A)alevin, (I)nfantil, (C)adete, "
                    + "(J)uvenil o (S)enior ");
            car = entrada.nextLine().trim().toUpperCase().charAt(0);
        } while ((car != 'B') && (car != 'A') && (car != 'I') && (car != 'C')
                && (car != 'J') && (car != 'S'));

        switch (car) {
            case 'B':
                categoria = Deportista.Categoria.BENJAMIN;
                break;
            case 'A':
                categoria = Deportista.Categoria.ALEVIN;
                break;
            case 'I':
                categoria = Deportista.Categoria.INFANTIL;
                break;
            case 'C':
                categoria = Deportista.Categoria.CADETE;
                break;
            case 'J':
                categoria = Deportista.Categoria.JUVENIL;
                break;
            case 'S':
                categoria = Deportista.Categoria.SENIOR;
        }
        do {
            System.out.print("Edad: ");
            try {
                edad = Integer.parseInt(entrada.nextLine());
                toret = new Deportista(dni, nombre, categoria, edad);
            } catch (NumberFormatException exc) {
                edad = -1;
                System.out.println("Asegurate de introducir un entero");
            } catch (Exception exc) {
                edad = -1;
                System.out.println("Error creando el deportista: " + exc.getMessage());
            }
        } while (edad < Deportista.MIN_EDAD || edad > Deportista.MAX_EDAD);
        return toret;

    }

}
