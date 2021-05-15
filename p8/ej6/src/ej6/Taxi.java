package ej6;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Taxi extends Vehiculo {

    public static enum Etq {
        NUM_LICENCIA
    }

    private int numLicencia;

    public Taxi(Element el) throws ParsingException, NumberFormatException {
        super(el);
        Element elNumLicencia = el.getFirstChildElement(Etq.NUM_LICENCIA.name());
        if (elNumLicencia == null) {
            throw new ParsingException("Falta el número de licencia");
        }
        numLicencia = Integer.parseInt(elNumLicencia.getValue());
    }

    public Taxi(int numLicencia, String matricula, String marca, String modelo, Fecha fechaMatriculacion) {
        super(matricula, marca, modelo, fechaMatriculacion);
        this.numLicencia = numLicencia;
    }

    public int getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(int numLicencia) {
        this.numLicencia = numLicencia;
    }

    @Override
    public Element toDOM() {
        Element vehiculo = super.toDOM();
        Element elNumLicencia = new Element(Etq.NUM_LICENCIA.name());
        elNumLicencia.appendChild(Integer.toString(getNumLicencia()));
        vehiculo.appendChild(elNumLicencia);
        return vehiculo;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Número de licencia: ").append(getNumLicencia());
        return toret.toString();
    }

}
