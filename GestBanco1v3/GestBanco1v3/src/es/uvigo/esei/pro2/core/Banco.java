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

    public String listarCuentas(Cuenta.Tipo tipo) throws Exception {
        StringBuilder toret = new StringBuilder();
        StringBuilder cliente;
        final int numClientes = getNumClientes();

        if (numClientes > 0) {
            for (int i = 0; i < numClientes; i++) {
                cliente = new StringBuilder();
                for (int j = 0; j < clientes[i].getNumCuentas(); j++) {
                    if (clientes[i].getCuenta(j).getTipo().equals(tipo)) {
                        cliente.append("\t");
                        cliente.append(clientes[i].getCuenta(j).toString());
                        cliente.append("\n");
                    }
                }

                if (cliente.length() != 0) {
                    toret.append("El cliente ");
                    toret.append(clientes[i].getNombre());
                    toret.append(" tiene las siguientes cuentas del tipo ");
                    toret.append(tipo.name().toLowerCase());
                    toret.append("\n");
                    toret.append(cliente);
                }
            }
        }
        return toret.toString();

    }

    /**
     * Elimina un cliente
     *
     * @param pos el lugar del cliente en el vector de clientes
     */
    public void elimina(int pos) {
//        for (int i = pos; i < getNumClientes() - 1; i++) {
//            clientes[i] = clientes[i + 1];
//        }
//        numClientes--;
        clientes[pos] = clientes[--numClientes];
    }

    /**
     *
     * @return Lista de clientes con formato "num. Datos del cliente: ...
     * ;...;...; Datos de sus cuentas: ...
     */
    @Override
    public String toString() {
        if (getNumClientes() <= 0) {
            return "No hay clientes";
        }
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < getNumClientes(); i++) {
            toret.append(i + 1).append(". ").append(clientes[i]).append("\n");
        }
        return toret.toString();
    }
}
