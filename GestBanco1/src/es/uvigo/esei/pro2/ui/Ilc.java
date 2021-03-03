package es.uvigo.esei.pro2.ui;

/**
 *
 * @author nrufino
 */
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
        int maxClientes = leeNum("Num. max. clientes: ");

        // Prepara
        Banco coleccion = new Banco(maxClientes);

        // Bucle ppal
        do {
            System.out.println("\nGestión de una entidad bancaria.");
            System.out.println("Clientes: " + coleccion.getNumClientes() + "/"
                    + coleccion.getMaxClientes());

            op = menu(coleccion);

            switch (op) {
                case 0:
                    System.out.println("Fin.");
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
                    break;
                default:
                    System.out.println("No es correcta esa opción ( "
                            + op + " )");
            }
        } while (op != 0);

    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizap.
     * @return El num., como entero
     */
    private int leeNum(String msg) {
        boolean repite;
        int toret = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            repite = false;
            System.out.print(msg);

            try {
                toret = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException exc) {
                repite = true;
            }
        } while (repite);

        return toret;
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
                    "1. Inserta un nuevo cliente\n"
                    + "2. Modifica un cliente\n"
                    + "3. Elimina un cliente\n"
                    + "4. Listar clientes\n"
                    + "5. Listar según tipo de cuenta\n"
                    + "0. Salir\n");
            toret = leeNum("Selecciona: ");
        } while (toret < 0
                && toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Crea un nuevo cliente y lo inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta el cliente.
     */
    private void insertaCliente(Banco coleccion) {
        Cliente c = new Cliente("", "", "", 1);
        try {
            modificaCliente(c);
            coleccion.inserta(c);
        } catch (Exception exc) {
            System.out.println("No se pudo insertar el cliente: " + exc.getMessage());
        }
    }

    /**
     * Borra un cliente por su posicion en la colección.
     *
     * @param coleccion La coleccion en la que se elimina el cliente
     */
    private void eliminaCliente(Banco coleccion) {
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
        if (coleccion.getNumClientes() > 0) {
            try {
                this.modificaCliente(coleccion.get(leePosCliente(coleccion)));
            } catch (Exception exc) {
                System.out.println("No se pudo obtener el cliente a modificar: " + exc.getMessage());
            }
        } else {
            System.out.println("La coleccion no contiene clientes.");
        }
    }

    private void modificaCliente(Cliente c) {
        String info;
        String mensaje;
        int tipoCuenta;
        int numCuentas = 0;
        int anho = 0;
        Cuenta cu;

        Scanner teclado = new Scanner(System.in);

        // Nombre
        System.out.print("Nombre del cliente ");
        if (c.getNombre().length() > 0) {
            System.out.print("[" + c.getNombre() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            c.setNombre(info);
        }

        // D.N.I.
        System.out.print("D.N.I. del cliente ");
        if (c.getDni().length() > 0) {
            System.out.print("[" + c.getDni() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            c.setDni(info);
        }

        // Domicilio
        System.out.print("Domicilio del cliente ");
        if (c.getDomicilio().length() > 0) {
            System.out.print("[" + c.getDomicilio() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            c.setDomicilio(info);
        }

        // Número de cuentas para el cliente
        do {
            mensaje = "Numero de cuentas del cliente ";
            if (c.getNumCuentas() > 0) {
                mensaje += "[" + c.getNumCuentas() + "]:";
            }
            numCuentas = leeNum(mensaje);
        } while (numCuentas < 1);
        c.setNumCuentas(numCuentas);

        // Datos de todas las cuentas del cliente
        numCuentas = 0;

        do {
            try {
                System.out.println("Introduce los datos de una cuenta.");
                cu = c.getCuenta(numCuentas++);

                // Numero de cuenta
                System.out.print("Numero de cuenta del cliente ");
                if (cu.getNumCuenta().length() > 0) {
                    System.out.print("[" + cu.getNumCuenta() + "]");
                }
                System.out.print(": ");
                info = teclado.nextLine().trim();

                if (info.length() > 0) {
                    cu.setNumCuenta(info);
                }

                // Año
                mensaje = "Año de apertura de la cuenta del cliente ";
                if (cu.getAno() > 0) {
                    mensaje += "[" + cu.getAno() + "] ";
                }
                mensaje += ":";
                anho = leeNum(mensaje);
                cu.setAno(anho);

                // Tipo de cuenta
                System.out.println(cu.getTipo() == null ? "Tipo de cuenta: " : "La cuenta es de tipo " + cu.getTipo());
                do {
                    for (int i = 0; i < Cuenta.Tipo.values().length; i++) {
                        System.out.println("\t" + (i + 1) + ". " + Cuenta.Tipo.values()[i]);
                    }
                    tipoCuenta = leeNum("-> ");
                } while (tipoCuenta < 1 || tipoCuenta > Cuenta.Tipo.values().length);
                cu.setTipo(Cuenta.Tipo.values()[tipoCuenta - 1]);
            } catch (Exception exc) {
                System.out.println("No se pudo obtener la cuenta: " + exc.getMessage());
            }
        } while (numCuentas < c.getNumCuentas());
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
            toret = leeNum("Introduzca posición del cliente (1..."
                    + numClientes + "): ");
        } while (toret < 1
                || toret > numClientes);

        return toret - 1;
    }

    /**
     * Lee un caracter del teclado
     *
     * @param men Mensaje a visualizar
     * @return el caracter introducido por el usuario
     */
    private char leeCaracter(String men) {
        Scanner teclado = new Scanner(System.in);

        System.out.print(men);
        return (teclado.nextLine().trim().charAt(0));
    }

    /**
     * Visualiza los clientes almacenados en la coleccion por la salida std.
     *
     * @param coleccion El objeto Banco del que visualizar sus clientes.
     */
    private void visualiza(Banco coleccion) {
        final int numClientes = coleccion.getNumClientes();

        if (numClientes > 0) {
            for (int i = 0; i < numClientes; i++) {
                try {
                    System.out.print((i + 1) + ". ");
                    System.out.println(coleccion.get(i).toString());
                } catch (Exception exc) {
                    System.out.println("No se pudo obtener el cliente: " + exc.getMessage());
                }
            }
        } else {
            System.out.println("No hay clientes.");
        }
    }

    /**
     * Visualiza los clientes con cuentas de cierto tipo
     *
     * @param tipo Tipo del que listar las cuentas
     */
    private void listar(Banco coleccion) {
        Cuenta.Tipo tipo;
        int numTipo;
        do {
            System.out.println("Tipo de cuenta:");
            for (int i = 0; i < Cuenta.Tipo.values().length; i++) {
                System.out.println("\t" + (i + 1) + ". " + Cuenta.Tipo.values()[i]);
            }
            numTipo = leeNum("-> ");
        } while (numTipo < 1 || numTipo > Cuenta.Tipo.values().length);
        tipo = Cuenta.Tipo.values()[numTipo - 1];
        for (int i = 0; i < coleccion.getNumClientes(); i++) {
            try {
                Cliente c = coleccion.get(i);
                int j = 0;
                while (j < c.getNumCuentas() && c.getCuenta(j).getTipo() != tipo) {
                    j++;
                }
                if (j < c.getNumCuentas()) {
                    System.out.println((i + 1) + ". " + c);
                }
            } catch (Exception exc) {
                System.out.println("Se ha producido un error mostrando este cliente: " + exc.getMessage());
            }
        }
    }
}
