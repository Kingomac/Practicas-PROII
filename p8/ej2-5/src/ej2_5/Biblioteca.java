package ej2_5;

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
public class Biblioteca {

    public static enum Etq {
        BIBLIOTECA
    }

    private ArrayList<Libro> libros;

    public Biblioteca(String nf) throws IOException, ParsingException {
        this();
        Builder parser = new Builder();
        Document doc = parser.build(new File(nf));

        Elements elLibros = doc.getRootElement().getChildElements();

        for (int i = 0; i < elLibros.size(); i++) {
            if (elLibros.get(i).getFirstChildElement(LibroElectronico.Etq.URL.name()) != null) {
                this.insertar(new LibroElectronico(elLibros.get(i)));
            } else {
                this.insertar(new Libro(elLibros.get(i)));
            }
        }
    }

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void insertar(Libro l) {
        libros.add(l);
    }

    public void eliminar(int n) {
        libros.remove(n);
    }

    public Element toDom() {
        Element biblioteca = new Element(Etq.BIBLIOTECA.name());
        for (Libro l : libros) {
            biblioteca.appendChild(l.toDOM());
        }
        return biblioteca;
    }

    public void toXML(String nombre) throws IOException {
        FileOutputStream f = new FileOutputStream(nombre);
        Serializer serial = new Serializer(f);
        Document doc = new Document(this.toDom());
        serial.write(doc);
        f.close();
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < libros.size(); i++) {
            toret.append("\t").append(i + 1).append(". ").append(libros.get(i)).append("\n");
        }
        return toret.toString();
    }
}
