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

    private Cliente[] clientes;
    private int numClientes;

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
            throw new Exception("get(pos): se intentó obtener un cliente de índice inválido");
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
     * @return el num. de clientes max,, como entero
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
            throw new Exception("inserta(Cliente): se intentó sobrepasar el máximo de clientes");
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
        numClientes--;
        for (int i = pos - 1; i < getNumClientes(); i++) {
            clientes[i] = clientes[i + 1];
        }
    }

    @Override
    public String toString() {
        if (getNumClientes() == 0) {
            return "No hay clientes";
        }
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < getNumClientes(); i++) {
            try {
                toret.append(i + 1).append(".").append(this.get(i));
            } catch (Exception ex) {
                toret.append("No se pudo obtener el cliente: ").append(ex.getMessage());
            }
        }
        return toret.append("\n").toString();
    }

}
