package ej6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Serializer;

/**
 *
 * @author Mario
 */
public class GestionTransportes {

    public static enum Etq {
        VEHICULOS
    }

    private ArrayList<Vehiculo> vehiculos;

    public GestionTransportes(String nf) throws ParsingException, NumberFormatException, IOException {
        this();
        Builder parser = new Builder();
        Document doc = parser.build(new File(nf));

        Elements els = doc.getRootElement().getChildElements();

        for (Element e : els) {
            if (e.getFirstChildElement(Taxi.Etq.NUM_LICENCIA.name()) != null) {
                this.insertar(new Taxi(e));
            } else {
                this.insertar(new Autobus(e));
            }
        }
    }

    public GestionTransportes() {
        vehiculos = new ArrayList<>();
    }

    public void insertar(Vehiculo e) {
        vehiculos.add(e);
    }

    public void eliminar(int i) {
        vehiculos.remove(i);
    }

    public int getNumVehiculos() {
        return vehiculos.size();
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < vehiculos.size(); i++) {
            toret.append("\t").append(i + 1).append(". ").append(vehiculos.get(i)).append("\n");
        }
        return toret.toString();
    }

    public Element toDom() {
        Element elVehiculos = new Element(Etq.VEHICULOS.name());
        for (Vehiculo c : this.vehiculos) {
            elVehiculos.appendChild(c.toDom());
        }
        return elVehiculos;
    }

    public void toXML(String nf) throws IOException {
        FileOutputStream f = new FileOutputStream(nf);
        Document doc = new Document(this.toDom());
        Serializer serial = new Serializer(f);
        serial.write(doc);
        f.close();
    }

}
