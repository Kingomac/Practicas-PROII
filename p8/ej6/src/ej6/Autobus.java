package ej6;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class Autobus extends Vehiculo {

    public static enum Etq {
        NUM_PLAZAS
    }

    private int numPlazas;

    public Autobus(Element el) throws ParsingException, NumberFormatException {
        super(el);
        Element elNumPlazas = el.getFirstChildElement(Etq.NUM_PLAZAS.name());
        if (elNumPlazas == null) {
            throw new ParsingException("Falta el número de plazas");
        }
        numPlazas = Integer.parseInt(elNumPlazas.getValue());
    }

    public Autobus(int numPlazas, String matricula, String marca, String modelo, Fecha fechaMatriculacion) {
        super(matricula, marca, modelo, fechaMatriculacion);
        this.numPlazas = numPlazas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder(super.toString());
        toret.append("; Número de plazas: ").append(getNumPlazas());
        return toret.toString();
    }

    @Override
    public Element toDom() {
        Element vehiculo = super.toDom();
        Element elNumPlazas = new Element(Etq.NUM_PLAZAS.name());

        elNumPlazas.appendChild(Integer.toString(getNumPlazas()));
        vehiculo.appendChild(elNumPlazas);
        return vehiculo;
    }

}
