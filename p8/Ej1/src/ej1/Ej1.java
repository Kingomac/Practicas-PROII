package ej1;

import java.io.FileOutputStream;
import java.io.IOException;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 *
 * @author Mario
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear los elementos
        Element raiz = new Element("mensajes");
        Element mensaje = new Element("mensaje");

// Crear el documento
        mensaje.appendChild("Hola, mundo");
        raiz.appendChild(mensaje);
        Document doc = new Document(raiz);

// Guardarlo
        try {

            FileOutputStream f = new FileOutputStream("mensaje.xml");
            Serializer serial = new Serializer(f);
            serial.setIndent(4);
            serial.write(doc);
            f.close();
            System.out.println("Ok");
        } catch (IOException exc) {

            System.err.println("ERROR de archivo: " + exc.getMessage());

        }
    }

}
