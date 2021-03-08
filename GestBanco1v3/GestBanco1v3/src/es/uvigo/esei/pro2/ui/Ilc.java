package es.uvigo.esei.pro2.ui;

import es.uvigo.esei.pro2.core.Banco;
import es.uvigo.esei.pro2.core.Cliente;
import es.uvigo.esei.pro2.core.Cuenta;

import java.util.Scanner;

/**
 * Interfaz de lin. de comando
 */
public class Ilc {

    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int op;

        // Lee el num. max. de clientes
        int maxClientes = leeEntero("Num. max. clientes: ");

        // Prepara
        Banco coleccion = new Banco(maxClientes);

        // Bucle ppal
        do {
            System.out.println("\n--------------------------------");
            System.out.println("\nGestión de una entidad bancaria.");

            op = menu(coleccion);

            switch (op) {
                case 0:
                    System.out.println("Fin gestión banco.");
                    break;
                case 1:
                    insertaCliente(coleccion);
                    break;
                case 2:
                    modificaCliente(coleccion);
                    break;
                case 3:
                    eliminaCliente(coleccion);
                    break;
                case 4:
                    visualiza(coleccion);
                    break;
                default:
                    System.out.println("No es correcta esa opción"
                            + " ( " + op + " )");
            }
        } while (op != 0);

    }

    /**
     * Presenta un menu con las opciones, y permite seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menu(Banco coleccion) {
        int toret;

        do {
            System.out.println(
                    String.format("%d/%d\n", coleccion.getNumClientes(), coleccion.getMaxClientes())
                    + "1. Inserta un nuevo cliente\n"
                    + "2. Modifica un cliente\n"
                    + "3. Elimina un cliente\n"
                    + "4. Listar clientes\n"
                    + "0. Salir\n");
            toret = leeEntero("Selecciona: ");
        } while (toret < 0 && toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Crea un nuevo cliente y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el cliente.
     */
    private void insertaCliente(Banco coleccion) {
        System.out.println("\n------------");
        System.out.println("\nAlta cliente");

        Cliente c = leeCliente();
        coleccion.inserta(c);
    }

    /**
     * Borra un cliente por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el cliente
     */
    private void eliminaCliente(Banco coleccion) {
        System.out.println("\n------------");
        System.out.println("\nBaja cliente\n");

        if (coleccion.getNumClientes() > 0) {
            coleccion.elimina(leePosCliente(coleccion));
        } else {
            System.out.println("La coleccion no contiene clientes.");
        }
    }

    /**
     * Modifica un cliente existente.
     *
     * @param coleccion La coleccion de la cual modificar un cliente.
     */
    private void modificaCliente(Banco coleccion) {
        System.out.println("\n--------------------");
        System.out.println("\nModificación cliente");

        if (coleccion.getNumClientes() > 0) {
            this.modificaCliente(coleccion.get(leePosCliente(coleccion)));
        } else {
            System.out.println("La coleccion no contiene clientes.");
        }
    }

    /**
     * Lee del teclado los datos de un cliente
     *
     * @return El objeto Cliente creado
     */
    private Cliente leeCliente() {
        System.out.println("\nIntroduce los datos del nuevo cliente:");

        String nombre = leeCadena("\tNombre: ");
        String dni = leeCadena("\tD.N.I.: ");
        String domicilio = leeCadena("\tDomicilio: ");

        int numCuentas = 0;
        do {
            numCuentas = leeEntero("\tNumero de cuentas: ");
            if (numCuentas < 1) {
                System.out.println("El número de cuentas no puede ser "
                        + "inferior a 1. Por favor, introdúdelo de nuevo.");
            }
        } while (numCuentas < 1);

        Cuenta[] cuentas = leerCuentas(numCuentas);

        return new Cliente(dni, nombre, domicilio, cuentas);
    }

    /**
     * Lee los datos de las cuentas bancarias
     *
     * @param numCuentas numero de cuentas a leer
     * @return Array con las cuentas bancarias creadas
     */
    private Cuenta[] leerCuentas(int numCuentas) {
        Cuenta[] cuentas = new Cuenta[numCuentas];

        for (int i = 0; i < numCuentas; i++) {
            System.out.println("\n\tDatos de la cuenta número " + (i + 1));
            cuentas[i] = leerCuenta();
        }

        return cuentas;
    }

    /**
     * Lee del teclado los datos de una cuenta bancaria
     *
     * @return El objeto Cuenta creado
     */
    private Cuenta leerCuenta() {
        char tipoCuenta;
        boolean ahorro = false;
        boolean corriente = false;

        String numCuenta = leeCadena("\tNúmero de cuenta: ");
        int anho = leeEntero("\tAño de apertura: ");

        do {
            tipoCuenta = leeCadena("\tIntroduce el tipo de cuenta del clietne "
                    + "(A: ahorro, C: corriente): ").toUpperCase().charAt(0);
        } while ((tipoCuenta != 'A') && (tipoCuenta != 'C'));

        switch (tipoCuenta) {
            case 'A':
                ahorro = true;
                break;
            case 'C':
                corriente = true;
                break;
        }

        return new Cuenta(numCuenta, anho, ahorro, corriente);
    }

    /**
     * Modifica los datos de un cliente
     *
     * @param c Objeto Cliente a modificar
     */
    private void modificaCliente(Cliente c) {
        int op = 0;

        System.out.println("\nModificando los datos del siguiente cliente:");
        System.out.println(c);
        System.out.println();

        String nombre = leeCadena("\tNombre [" + c.getNombre() + "]: ", true);
        if (!nombre.isEmpty()) {
            c.setNombre(nombre);
        }

        String dni = leeCadena("\tDNI [" + c.getDni() + "]: ", true);
        if (!dni.isEmpty()) {
            c.setDni(dni);
        }

        String domicilio = leeCadena("\tDomicilio [" + c.getDomicilio() + "]: ",
                true);
        if (!domicilio.isEmpty()) {
            c.setDomicilio(domicilio);
        }

        do {
            System.out.println("\nMenú de modificación de las cuentas:");

            op = menuEdicionCuentas();

            switch (op) {
                case 0:
                    System.out.println("Fin.");
                    break;
                case 1:
                    c.nuevaCuenta(leerCuenta());
                    break;
                case 2:
                    modificaCuenta(c.getCuenta(leePosCuenta(c.getNumCuentas())));
                    break;
                case 3:
                    c.eliminaCuenta(leePosCuenta(c.getNumCuentas()));
                    break;
                default:
                    System.out.println("No es correcta esa opción ( "
                            + op + " )");
            }
        } while (op != 0);
    }

    /**
     * Lee la posición de la cuenta a tratar
     *
     * @param numCuentas numero de cuentas existentes
     * @return int Posición/indice donde esta la cuenta a tratar
     */
    private int leePosCuenta(int numCuentas) {
        int toret;

        do {
            toret = leeEntero("Introduzca posición de la cuenta (1..."
                    + numCuentas + "): ");
        } while (toret < 1 || toret > numCuentas);

        return toret - 1;
    }

    /**
     * Modifica los datos de una cuenta
     *
     * @param cuenta Objeto Cuenta a modificar
     */
    private void modificaCuenta(Cuenta cuenta) {
        char tipoCuenta;
        String numCuenta;
        int anho;

        String temp;
        String tipoCuentaActual;

        boolean ahorro = false;
        boolean corriente = false;

        numCuenta = leeCadena("\tNúmero de cuenta ["
                + cuenta.getNumCuenta() + "]: ", true);
        if (!numCuenta.isEmpty()) {
            cuenta.setNumCuenta(numCuenta);
        }

        temp = leeCadena("\tAño de apertura [" + cuenta.getAnho() + "]: ",
                true);
        if (!temp.isEmpty()) {
            cuenta.setAnho(Integer.parseInt(temp));
        }

        if (cuenta.estaEtiquetadoComoAhorro()) {
            tipoCuentaActual = "Ahorro";
            tipoCuenta = 'A';
        } else {
            tipoCuentaActual = "Corriente";
            tipoCuenta = 'C';
        }
        do {
            temp = leeCadena("\tIntroduce el tipo de cuenta del clietne "
                    + "(A: ahorro, C: corriente) [" + tipoCuentaActual
                    + "] : ", true);
            if (temp.length() != 0) {
                tipoCuenta = temp.toUpperCase().charAt(0);
            }
        } while ((tipoCuenta != 'A') && (tipoCuenta != 'C'));

        switch (tipoCuenta) {
            case 'A':
                ahorro = true;
                break;
            case 'C':
                corriente = true;
                break;
        }
        cuenta.setEtiquetaAhorro(ahorro);
        cuenta.setEtiquetaCorriente(corriente);
    }

    /**
     * Visualiza el menu de gestión de cuentas y obtiene la opción deseada
     *
     * @return int Opción del menú elegida
     */
    private int menuEdicionCuentas() {
        int toret;

        do {
            System.out.println(
                    "\n1. Inserta una nueva cuenta\n"
                    + "2. Modifica una cuenta existente\n"
                    + "3. Elimina una cuenta existente\n"
                    + "0. Terminar\n");
            toret = leeEntero("Selecciona: ");
        } while (toret < 0 && toret > 3);

        System.out.println();
        return toret;
    }

    /**
     * Lee del teclado la posición de un cliente en la colección
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return la posición del cliente, como entero.
     */
    private int leePosCliente(Banco coleccion) {
        final int numClientes = coleccion.getNumClientes();
        int toret;

        do {
            toret = leeEntero("Introduzca posición del cliente (1..."
                    + numClientes + "): ");
        } while (toret < 1 || toret > numClientes);

        return toret - 1;
    }

    /**
     * Visualiza los clientes almacenados en la coleccion por la salida std.
     *
     * @param coleccion El objeto Banco del que visualizar sus clientes.
     */
    private void visualiza(Banco coleccion) {
        System.out.println("\n--------------------");
        System.out.println("\nListar clientes\n");

        final int numClientes = coleccion.getNumClientes();

        if (numClientes > 0) {
            for (int i = 0; i < numClientes; i++) {
                System.out.print((i + 1) + ". ");
                System.out.println(coleccion.get(i).toString());
            }
        } else {
            System.out.println("No hay clientes.");
        }
    }

    /* -------------------------------------------------------------*/
    //  METODOS PARA LA LECTURA DE DATOS DEL TECLADO
    /* -------------------------------------------------------------*/
    /**
     * Lee una cadena del teclado
     *
     * @param mensaje Literal que especifica lo que el usuario debe introducir
     * @return String cadena leida del teclado
     */
    private static String leeCadena(String mensaje) {
        return leeCadena(mensaje, false);
    }

    /**
     * Lee una cadena del teclado
     *
     * @param mensaje Literal que especifica lo que el usuario debe introducir
     * @param permiteVacia True: campo no obligatorio; False: campo obligatorio
     * @return String cadena leida del teclado
     */
    private static String leeCadena(String mensaje,
            boolean permiteVacia) {
        String leer;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(mensaje);
            leer = scanner.nextLine().trim();
            if (!permiteVacia && leer.length() == 0) {
                System.out.println("La cadena introducida no puede estar vacía. "
                        + "Por favor, introdúcela de nuevo.");
            }
        } while ((permiteVacia == false) && leer.length() == 0);

        return leer;
    }

    /**
     * Lee un entero del teclado
     *
     * @param mensaje Literal que especifica lo que el usuario debe introducir
     * @return int Entero leido del teclado
     */
    private static int leeEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean esValido = false; // True: entero leido correctamente
        int leer = 0;

        do {
            try {
                System.out.print(mensaje);
                leer = Integer.parseInt(scanner.nextLine().trim());
                esValido = true;
            } catch (NumberFormatException e) {
                System.err.println("La cadena introducida no se puede "
                        + "convertir a número entero. Por favor, "
                        + "introdúcela de nuevo.");
            }
        } while (!esValido);

        return leer;
    }

}
