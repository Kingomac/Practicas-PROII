package ej2_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Ej2_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Biblioteca biblioteca = new Biblioteca();
        do {
            opcion = menu();
            try {
                switch (opcion) {
                    case 1:
                        biblioteca.insertar(leerLibro());
                        break;
                    case 2:
                        guardar(biblioteca);
                        break;
                    case 3:
                        biblioteca = cargar();
                        break;
                    case 4:
                        System.out.println(biblioteca);
                        break;

                }
            } catch (ParsingException ex) {
                System.err.println("Error de formato del archivo a cargar: " + ex.getMessage());
            } catch (FileNotFoundException ex) {
                System.err.println("El archivo no existe: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Error guardando o cargando archivo: " + ex.getMessage());
            }
        } while (opcion != 0);

    }

    private static void guardar(Biblioteca b) throws FileNotFoundException, IOException {
        String ruta = leerCadena("Ruta: ");
        b.toXML(ruta);
    }

    private static Biblioteca cargar() throws IOException, ParsingException {
        String ruta = leerCadena("Ruta: ");
        return new Biblioteca(ruta);
    }

    private static Libro leerLibro() {
        String titulo = leerCadena("\tTítulo: ");
        String autor = leerCadena("\tAutor: ");
        LocalDate fechaEdicion = leerFecha("\tFecha de edición (dd/mm/yyy): ");
        String url = leerCadenaVacia("\tUrl: ");
        if (url.equals("")) {
            return new Libro(titulo, autor, fechaEdicion);
        }
        return new LibroElectronico(url, titulo, autor, fechaEdicion);
    }

    private static int menu() {
        int toret;
        do {
            System.out.println("1. Insertar");
            System.out.println("2. Guardar");
            System.out.println("3. Cargar");
            System.out.println("4. Listar");
            System.out.println("0. Salir");
            toret = leerEntero("-> ");
        } while (toret < 0 || toret > 4);
        return toret;
    }

    private static String leerCadena(String mensaje) {
        String toret;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            toret = scan.nextLine().trim();
            if (toret.equals("")) {
                System.err.println("La cadena no puede ser vacía");
            }
        } while ("".equals(toret));
        return toret;
    }

    private static String leerCadenaVacia(String mensaje) {
        String toret;
        Scanner scan = new Scanner(System.in);
        System.out.print(mensaje);
        return scan.nextLine().trim();
    }

    private static int leerEntero(String msg) {
        Scanner entrada = new Scanner(System.in);
        int entero = 0;
        boolean existeError;

        do {
            try {
                existeError = false;
                System.out.print(msg);
                entero = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Error de formato numerico.");
                existeError = true;
            }
        } while (existeError);

        return entero;
    }

    private static LocalDate leerFecha(String mensaje) {
        boolean seguir = true;
        String fecha;
        int dia = 31;
        int mes = 1;
        int anho = 2021;
        do {
            fecha = leerCadena(mensaje);
            seguir = fecha.split("/").length != 3;
            if (!seguir) {
                try {
                    dia = Integer.parseInt(fecha.split("/")[0]);
                    mes = Integer.parseInt(fecha.split("/")[1]);
                    anho = Integer.parseInt(fecha.split("/")[2]);
                    seguir = false;
                } catch (NumberFormatException ex) {
                    System.err.println("Los números deben ser enteros");
                    seguir = true;
                }
            }
        } while (seguir);
        return LocalDate.of(anho, mes - 1, dia);
    }

}
