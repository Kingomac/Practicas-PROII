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
        Element mensajes = new Element("mensajes");
        Element mensaje = new Element("mensaje");
        mensaje.appendChild("Hola, mundo");
        mensajes.appendChild(mensaje);

        Document doc = new Document(mensajes);

        try ( FileOutputStream f = new FileOutputStream("mensajes.xml")) {
            Serializer serializer = new Serializer(f);
            serializer.write(doc);
        } catch (IOException ex) {
            System.err.println("ERROR escribiendo XML: " + ex.getMessage());
        }
    }

}
