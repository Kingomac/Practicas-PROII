/*
 *  Definición de la clase Banco
 *  En un banco tendremos una serie de clientes
 */
package es.uvigo.esei.pro2.core;

import excepciones.ClienteIndiceExcepcion;
import excepciones.CuentaIndiceExcepcion;
import excepciones.DemasiadosClientesExcepcion;

public class Banco {

    private String nombre;
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
    public Banco(int maxClientes, String nombre) {
        numClientes = 0;
        clientes = new Cliente[maxClientes];
        this.nombre = nombre;
    }

    /**
     * Devuelve el cliente situado en pos
     *
     * @param pos el lugar del cliente en el vector de clientes
     * @return el objeto Cliente correspondiente.
     */
    public Cliente get(int pos) throws ClienteIndiceExcepcion {
        if (pos >= getNumClientes()) {
            throw new ClienteIndiceExcepcion("get(): sobrepasa la pos: " + (pos + 1)
                    + " / " + getMaxClientes());
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
     * @throws DemasiadosClientesExcepcion se produce cuando se alcanza la
     * capacidad máxima de clientes en el banco
     */
    public void inserta(Cliente c) throws DemasiadosClientesExcepcion {
        final int maxClientes = getMaxClientes();

        if (getNumClientes() >= maxClientes) {
            throw new DemasiadosClientesExcepcion("inserta(): sobrepasa max.: " + maxClientes);
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
        clientes[pos] = clientes[--numClientes];
//        for (int i = pos; i < (getNumClientes() - 1); i++) {
//            clientes[i] = clientes[i + 1];
//        }
//        --numClientes;
    }

    /**
     * Devuelve los datos de las cuentas del tipo especificado
     *
     * @param tipo tipo de cuenta a buscar
     * @return los datos del banco, como cadena
     * @throws CuentaIndiceExcepcion
     */
    public String listarCuentas(Cuenta.Tipo tipo) throws CuentaIndiceExcepcion {
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
     * Devuelve el nombre del banco
     *
     * @return String del nombre del banco
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del banco
     *
     * @param nombre String del nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los datos del Banco
     *
     * @return los datos del banco, como cadena
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        final int numClientes = getNumClientes();

        toret.append("Nombre del banco: ").append(getNombre());

        if (numClientes > 0) {
            for (int i = 0; i < numClientes; i++) {
                toret.append(i + 1).append(". ");
                toret.append(clientes[i].toString()).append("\n");
            }
        } else {
            toret.append("No hay clientes.");
        }

        return toret.toString();
    }
}
