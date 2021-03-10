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
        int maxClientes;
        do {
            maxClientes = leeEntero("Num. max. clientes: ");
        } while (maxClientes <= 0);

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
                    System.out.println(coleccion);
                    break;
                case 5:
                    listar(coleccion);
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
                    + "5. Filtrar clientes por tipo de cuenta\n"
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
        try {
            coleccion.inserta(c);
        } catch (Exception ex) {
            System.err.println("No se pudo insertar el cliente: " + ex.getMessage());
        }
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
            try {
                this.modificaCliente(coleccion.get(leePosCliente(coleccion)));
            } catch (Exception ex) {
                System.err.println("No se puedo obtener el cliente: " + ex.getMessage());
            }
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
        Cuenta.Tipo tipo = leerTipoCuenta();
        String numCuenta = leeCadena("\tNúmero de cuenta: ");
        int anho = leeEntero("\tAño de apertura: ");

        return new Cuenta(numCuenta, anho, tipo);
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
                case 2: {
                    try {
                        modificaCuenta(c.getCuenta(leePosCuenta(c.getNumCuentas())));
                    } catch (Exception ex) {
                        System.err.println("No se pudo obtener la cuenta: " + ex.getMessage());
                    }
                }
                break;

                case 3: {
                    try {
                        c.eliminaCuenta(leePosCuenta(c.getNumCuentas()));
                    } catch (Exception ex) {
                        System.err.println("No se pudo obtener la cuenta: " + ex.getMessage());
                    }
                }
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
        String numCuenta;

        String temp;
        int numTipo;

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
        cuenta.setTipo(leerTipoCuenta(cuenta.getTipo()));
    }

    /**
     * Pide introducir un tipo de cuenta por teclado y marcando cuál es el tipo
     * que ya tenía
     *
     * @return Tipo de cuenta introducido
     */
    private Cuenta.Tipo leerTipoCuenta(Cuenta.Tipo actual) {
        int numTipo;
        do {
            for (int i = 0; i < Cuenta.Tipo.values().length; i++) {
                System.out.format("\t%s%d. %s\n", Cuenta.Tipo.values()[i].equals(actual) ? "*" : "", i + 1, Cuenta.Tipo.values()[i]);
            }
            numTipo = Ilc.leeEntero("\t-> ");
        } while (numTipo < 1 || numTipo > Cuenta.Tipo.values().length);
        return Cuenta.Tipo.values()[numTipo - 1];
    }

    /**
     * Lee un tipo de cuenta por teclado
     *
     * @return Tipo de cuenta introducido
     */
    private Cuenta.Tipo leerTipoCuenta() {
        return leerTipoCuenta(null);
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
     * Muestra una lista de clientes filtrados por los tipos de cuentas que
     * tienen
     *
     * @param coleccion Banco que contiene la información de los clientes
     */
    private void listar(Banco coleccion) {
        Cuenta.Tipo tipo = leerTipoCuenta();
        for (int i = 0; i < coleccion.getNumClientes(); i++) {
            try {
                int j = 0;
                Cuenta c = coleccion.get(i).getCuenta(j);
                while (j < coleccion.get(i).getNumCuentas() && c.getTipo() != tipo) {
                    c = coleccion.get(i).getCuenta(j);
                }
                if (c.getTipo() == tipo) {
                    System.out.println((i + 1) + ". " + coleccion.get(i));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }

        }
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
    /*private void visualiza(Banco coleccion) {
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
    }*/

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
