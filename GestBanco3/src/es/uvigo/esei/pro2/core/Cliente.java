/*
 * Definicion de la clase Cliente
 */
package es.uvigo.esei.pro2.core;

import excepciones.CuentaIndiceExcepcion;
import excepciones.SinCuentasExcepcion;
import java.util.ArrayList;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;

public class Cliente {

    public static enum Etq {
        CLIENTE, DNI, NOMBRE, DOMICILIO, CUENTAS
    }

    private String dni;             // D.N.I. del cliente
    private String nombre;          // Nombre del cliente
    private String domicilio;       // Domicilio del cliente
    private ArrayList<Cuenta> cuentas;     // Cuentas bancarias del cliente

    public Cliente(Element el) throws ParsingException {
        Element elDni = el.getFirstChildElement(Etq.DNI.name());
        Element elNombre = el.getFirstChildElement(Etq.NOMBRE.name());
        Element elDomicilio = el.getFirstChildElement(Etq.DOMICILIO.name());
        Element elCuentas = el.getFirstChildElement(Etq.CUENTAS.name());
        Elements elsCuenta;

        if (elDni == null) {
            throw new ParsingException("Falta el DNI del cliente");
        }
        if (elNombre == null) {
            throw new ParsingException("Falta el nombre del cliente");
        }
        if (elDomicilio == null) {
            throw new ParsingException("Falta el domicilio del cliente");
        }

        if (elCuentas == null) {
            throw new ParsingException("Faltan las cuentas de cliente");
        }

        dni = elDni.getValue();
        nombre = elNombre.getValue();
        domicilio = elDomicilio.getValue();
        elsCuenta = elCuentas.getChildElements();
        cuentas = new ArrayList<>(elsCuenta.size());

        for (Element e : elsCuenta) {
            if (e.getLocalName().equals(Ahorro.Etq.CUENTA_AHORRO.name())) {
                cuentas.add(new Ahorro(e));
            } else {
                cuentas.add(new Corriente(e));
            }
        }

    }

    /**
     * Crea un nuevo cliente, con sus datos: nombre, domicilio, año y las
     * cuentas que tiene.
     *
     * @param dni D.N.I. del cliente
     * @param nombre nombre completo del cliente
     * @param domicilio el domicilio del cliente
     * @param cuentas array con las cuentas que tiene el cliente
     */
    public Cliente(String dni, String nombre, String domicilio,
            ArrayList<Cuenta> cuentas) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuentas = cuentas;
    }

    /**
     * Devuelve el D.N.I. del cliente
     *
     * @return el dni del cliente, como String.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Cambia el D.N.I. del cliente
     *
     * @param d el dni del cliente
     */
    public void setDni(String d) {
        dni = d;
    }

    /**
     * Devuelve el nombre del cliente
     *
     * @return El valor como cadena
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del cliente
     *
     * @param nombre El nuevo valor, como cadena
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    /**
     * Devuelve el domicilio del cliente
     *
     * @return El valor como cadena
     *
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Cambia el domicilio del cliente
     *
     * @param domicilio El nuevo valor, como cadena
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio.trim();
    }

    /**
     * Añade una nueva cuenta al listado de cuentas del cliente
     *
     * @param cuenta la nueva Cuenta
     */
    public void nuevaCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    /**
     * Devuelve el número de cuentas del cliente
     *
     * @return el número de cuentas del cliente
     */
    public int getNumCuentas() {
        return cuentas.size();
    }

    /**
     * Devuelve el objeto de tipo Cuenta que se encuentra en la posición
     * especificada (empezando en 0)
     *
     * @param cuenta el índice de la cuenta (empezando en 0)
     * @return la Cuenta que se encuentra en la posición especificada
     */
    public Cuenta getCuenta(int cuenta) throws CuentaIndiceExcepcion {
        if ((cuenta < 0) || (cuenta >= getNumCuentas())) {
            throw new CuentaIndiceExcepcion("La posicion indicada no es valida.");
        }

        return this.cuentas.get(cuenta);
    }

    /**
     * Elimina la Cuenta de la posición especificada (empezando en 0)
     *
     * @param pos el índice de la cuenta que se quiere eliminar (empezando en 0)
     */
    public void eliminaCuenta(int pos) throws SinCuentasExcepcion {
        if (getNumCuentas() == 1) {
            throw new SinCuentasExcepcion("El cliente debe tener como minimo "
                    + "una cuenta");
        }
        cuentas.remove(pos);
    }

    /**
     * Devuelve los datos del Cliente
     *
     * @return los datos del cliente, como cadena
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Cliente ").append(getNombre());
        toret.append(" con DNI ").append(getDni());
        toret.append(" y domicilio en ").append(getDomicilio());
        toret.append(". \n\n \tDatos de sus cuentas:  ");

        for (Cuenta cuenta : this.cuentas) {
            toret.append("\n\t\t").append(cuenta.toString());
        }

        return toret.toString();
    }

    public Element toDom() {
        Element elCliente = new Element(Etq.CLIENTE.name());
        Element elDNI = new Element(Etq.DNI.name());
        Element elNombre = new Element(Etq.NOMBRE.name());
        Element elDomicilio = new Element(Etq.DOMICILIO.name());
        Element elCuentas = new Element(Etq.CUENTAS.name());

        elDNI.appendChild(getDni());
        elNombre.appendChild(getNombre());
        elDomicilio.appendChild(getDomicilio());

        for (Cuenta c : cuentas) {
            elCuentas.appendChild(c.toDom());
        }

        elCliente.appendChild(elDNI);
        elCliente.appendChild(elNombre);
        elCliente.appendChild(elDomicilio);
        elCliente.appendChild(elCuentas);

        return elCliente;
    }

}
