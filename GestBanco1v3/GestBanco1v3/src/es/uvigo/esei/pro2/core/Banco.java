/*
 *  Definición de la clase Banco
 *  En un banco tendremos una serie de clientes
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Banco {

    private final Cliente[] clientes; // Array de los clientes del banco
    private int numClientes;
    // El atributo numClientes propociona información de:
    //  1.  numero de clientes existentes en el array clientes en cada momento
    //  2.  posición/indice del elemento del array donde se debería añadir un
    //      nuevo cliente

    /**
     * Nuevo Banco con un num. max. de clientes.
     *
     * @param maxClientes el num. max. de clientes, como entero.
     */
    public Banco(int maxClientes) {
        numClientes = 0;
        clientes = new Cliente[maxClientes];
    }

    /**
     * Devuelve el cliente situado en pos
     *
     * @param pos el lugar del cliente en el vector de clientes
     * @return el objeto Cliente correspondiente.
     */
    public Cliente get(int pos) {
        if (pos >= getNumClientes()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1)
                    + " / " + getMaxClientes());
            System.exit(-1);
        }

        return clientes[pos];
    }

    /**
     * Devuelve el num. de clientes creados.
     *
     * @return el num. de clientes existentes, como entero.
     */
    public int getNumClientes() {
        return numClientes;
    }

    /**
     * Devuelve el max. de numClientes
     *
     * @return el num. de clientes max., como entero
     */
    public int getMaxClientes() {
        return clientes.length;
    }

    /**
     * Inserta un nuevo cliente
     *
     * @param c el nuevo objeto Cliente
     */
    public void inserta(Cliente c) {
        final int maxClientes = getMaxClientes();

        if (getNumClientes() >= maxClientes) {
            System.err.println("inserta(): sobrepasa max.: " + maxClientes);
            System.exit(-1);
        }

        clientes[numClientes] = c;
        ++numClientes;
    }

    /**
     * Elimina un cliente
     *
     * @param pos el lugar del cliente en el vector de clientes
     */
    public void elimina(int pos) {
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < clientes.length; i++) {
            toret.append(String.format("%d. Datos del cliente: %s ; %s ; %s\nDatos de sus cuentas:\n",
                    i + 1, clientes[i].getDni(), clientes[i].getNombre(),
                    clientes[i].getDomicilio()));
            for (int j = 0; j < clientes[i].getNumCuentas(); j++) {
                toret.append(clientes[i].getCuenta(j) + "\n");
            }
        }
        return toret.toString();
    }
}
