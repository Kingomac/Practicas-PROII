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
        VEHICULO, MATRICULA, MARCA, MODELO, FECHA_MATRICULACION
    }

    private String matricula;
    private String marca;
    private String modelo;
    private Fecha fechaMatriculacion;

    public Vehiculo(Element el) throws ParsingException {
        Element elMatricula = el.getFirstChildElement(Etq.MATRICULA.name());
        Element elMarca = el.getFirstChildElement(Etq.MARCA.name());
        Element elModelo = el.getFirstChildElement(Etq.MODELO.name());
        Element elFechaMatriculacion = el.getFirstChildElement(Etq.FECHA_MATRICULACION.name());

        if (elMatricula == null) {
            throw new ParsingException("Falta la matrícula");
        }
        if (elMarca == null) {
            throw new ParsingException("Falta la marca");
        }
        if (elModelo == null) {
            throw new ParsingException("Falta el modelo");
        }
        if (elFechaMatriculacion == null) {
            throw new ParsingException("Falta la fecha de matriculación");
        }

        matricula = elMatricula.getValue();
        marca = elMarca.getValue();
        modelo = elModelo.getValue();
        fechaMatriculacion = new Fecha(elFechaMatriculacion);
    }

    public Vehiculo(String matricula, String marca, String modelo, Fecha fechaMatriculacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
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

    public Fecha getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrícula: ").append(getMatricula()).append("; Marca: ").
                append(getMarca()).append("; Modelo: ").append(getModelo());
        return sb.toString();
    }

    public Element toDOM() {
        Element vehiculo = new Element(Etq.VEHICULO.name());
        Element elMatricula = new Element(Etq.MATRICULA.name());
        Element elMarca = new Element(Etq.MARCA.name());
        Element elModelo = new Element(Etq.MODELO.name());
        Element elFechaMatriculacion = fechaMatriculacion.toDOM();

        elMatricula.appendChild(getMatricula());
        elMarca.appendChild(getMarca());
        elModelo.appendChild(getModelo());
        elFechaMatriculacion.setLocalName(Etq.FECHA_MATRICULACION.name());

        vehiculo.appendChild(elMatricula);
        vehiculo.appendChild(elMarca);
        vehiculo.appendChild(elModelo);
        vehiculo.appendChild(elFechaMatriculacion);

        return vehiculo;
    }

}
