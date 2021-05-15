/*
 *  Definición de la clase Banco
 *  En un banco tendremos una serie de clientes
 */
package es.uvigo.esei.pro2.core;

import excepciones.ClienteIndiceExcepcion;
import excepciones.CuentaIndiceExcepcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Serializer;

public class Banco {

    private static final String ETQ_BANCO = "banco";
    private static final String ETQ_NOMBRE = "nombre";
    private static final String ETQ_CLIENTES = "clientes";

    private String nombre;
    private final ArrayList<Cliente> clientes; // Array de los clientes del banco
    // El atributo numClientes propociona información de:
    //  1.  numero de clientes existentes en el array clientes en cada momento
    //  2.  posición/indice del elemento del array donde se debería añadir un
    //      nuevo cliente

    public Banco(String nf) throws IOException, ParsingException {
        Builder parser = new Builder();
        Document doc = parser.build(new File(nf));
        Element elBanco = doc.getRootElement();
        Element elNombre = elBanco.getFirstChildElement(ETQ_NOMBRE);
        Element elClientes = elBanco.getFirstChildElement(ETQ_CLIENTES);
        Elements elsClientes;

        if (elNombre == null) {
            throw new ParsingException("Falta el nombre del banco");
        }

        if (elClientes == null) {
            throw new ParsingException("Faltan los clientes del banco");
        }

        nombre = elNombre.getValue();
        elsClientes = elClientes.getChildElements();
        clientes = new ArrayList<>(elsClientes.size());

        for (Element e : elsClientes) {
            clientes.add(new Cliente(e));
        }
    }

    /**
     * Nuevo Banco con un número estimado de clientes.
     *
     * @param numClientes el número estimado de clientes, como entero.
     * @param nombre
     */
    public Banco(int numClientes, String nombre) {
        clientes = new ArrayList<>(numClientes);
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
                    + " / " + getNumClientes());
        }

        return clientes.get(pos);
    }

    /**
     * Devuelve el num. de clientes creados.
     *
     * @return el num. de clientes existentes, como entero.
     */
    public int getNumClientes() {
        return clientes.size();
    }

    /**
     * Inserta un nuevo cliente
     *
     * @param c el nuevo objeto Cliente
     */
    public void inserta(Cliente c) {
        clientes.add(c);
    }

    /**
     * Elimina un cliente
     *
     * @param pos el lugar del cliente en el vector de clientes
     */
    public void elimina(int pos) throws ClienteIndiceExcepcion {
        if (pos < 0 || pos >= getNumClientes()) {
            throw new ClienteIndiceExcepcion();
        }
        clientes.remove(pos);
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
                for (int j = 0; j < clientes.get(i).getNumCuentas(); j++) {
                    if (clientes.get(i).getCuenta(j).getTipo().equals(tipo)) {
                        cliente.append("\t");
                        cliente.append(clientes.get(i).getCuenta(j).toString());
                        cliente.append("\n");
                    }
                }

                if (cliente.length() != 0) {
                    toret.append("El cliente ");
                    toret.append(clientes.get(i).getNombre());
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

        toret.append("Nombre del banco: ").append(getNombre()).append("\n");

        if (numClientes > 0) {
            for (int i = 0; i < numClientes; i++) {
                toret.append(i + 1).append(". ");
                toret.append(clientes.get(i).toString()).append("\n");
            }
        } else {
            toret.append("No hay clientes.");
        }

        return toret.toString();
    }

    public Element toDOM() {
        Element elBanco = new Element(ETQ_BANCO);
        Element elNombre = new Element(ETQ_NOMBRE);
        Element elClientes = new Element(ETQ_CLIENTES);

        elNombre.appendChild(getNombre());
        for (Cliente c : clientes) {
            elClientes.appendChild(c.toDom());
        }

        elBanco.appendChild(elNombre);
        elBanco.appendChild(elClientes);

        return elBanco;
    }

    public void toXml(String nf) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(nf);
        Serializer serial = new Serializer(f);
        Document doc = new Document(this.toDOM());
        serial.write(doc);
        f.close();
    }
}
