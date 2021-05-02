package ej2_5;

import java.time.LocalDate;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Mario
 */
public class LibroElectronico extends Libro {

    public static enum Etq {
        URL
    }

    private String url;

    public LibroElectronico(String url, String titulo, String autor, LocalDate fechaEdicion) {
        super(titulo, autor, fechaEdicion);
        this.url = url;
    }

    public LibroElectronico(Element e) throws ParsingException {
        super(e);
        Element elUrl = e.getFirstChildElement(Etq.URL.name());
        if (elUrl == null) {
            throw new ParsingException("Falta la url del libro electrónico");
        }
        this.url = elUrl.getValue().trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Element toDOM() {
        Element libro = super.toDOM();
        Element elUrl = new Element(Etq.URL.name());

        elUrl.appendChild(getUrl());

        libro.appendChild(elUrl);

        return libro;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", super.toString(), getUrl());
    }

}
