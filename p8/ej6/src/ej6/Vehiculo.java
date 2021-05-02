package ej6;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public abstract class Vehiculo {

    public static enum Tipo {
        TAXI, AUTOBUS
    }

    public static enum Etq {
        VEHICULO, MATRICULA, MARCA, MODELO
    }

    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(Element el) throws ParsingException {
        Element elMatricula = el.getFirstChildElement(Etq.MATRICULA.name());
        Element elMarca = el.getFirstChildElement(Etq.MARCA.name());
        Element elModelo = el.getFirstChildElement(Etq.MODELO.name());

        if (elMatricula == null) {
            throw new ParsingException("Falta la matrícula");
        }
        if (elMarca == null) {
            throw new ParsingException("Falta la marca");
        }
        if (elModelo == null) {
            throw new ParsingException("Falta el modelo");
        }

        matricula = elMatricula.getValue();
        marca = elMarca.getValue();
        modelo = elModelo.getValue();
    }

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        if (this instanceof Taxi) {
            return Tipo.TAXI;
        }
        return Tipo.AUTOBUS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrícula: ").append(getMatricula()).append("; Marca: ").
                append(getMarca()).append("; Modelo: ").append(getModelo());
        return sb.toString();
    }

    public Element toDom() {
        Element vehiculo = new Element(Etq.VEHICULO.name());
        Element elMatricula = new Element(Etq.MATRICULA.name());
        Element elMarca = new Element(Etq.MARCA.name());
        Element elModelo = new Element(Etq.MODELO.name());

        elMatricula.appendChild(getMatricula());
        elMarca.appendChild(getMarca());
        elModelo.appendChild(getModelo());

        vehiculo.appendChild(elMatricula);
        vehiculo.appendChild(elMarca);
        vehiculo.appendChild(elModelo);

        return vehiculo;
    }

}
