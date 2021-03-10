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
    public Cliente get(int pos) throws Exception {
        if (pos >= getNumClientes()) {
            throw new Exception(String.format("get(): sobrepasa la pos: %d / %d",
                    pos + 1, getMaxClientes()));
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
    public void inserta(Cliente c) throws Exception {
        final int maxClientes = getMaxClientes();

        if (getNumClientes() >= maxClientes) {
            throw new Exception("inserta(): sobrepasa max.: " + maxClientes);
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
        for (int i = pos; i < getNumClientes() - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        --numClientes;
    }

    /**
     *
     * @return Lista de clientes con formato "num. Datos del cliente: ...
     * ;...;...; Datos de sus cuentas: ...
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < getNumClientes(); i++) {
            toret.append(String.format("%d. Datos del cliente: %s ; %s ; %s\nDatos de sus cuentas:\n",
                    i + 1, clientes[i].getDni(), clientes[i].getNombre(),
                    clientes[i].getDomicilio()));
            for (int j = 0; j < clientes[i].getNumCuentas(); j++) {
                try {
                    toret.append(clientes[i].getCuenta(j));
                } catch (Exception ex) {
                    toret.append("Error: no se pudo obtener la cuenta");
                }
                toret.append("\n");
            }
        }
        return toret.toString();
    }
}
