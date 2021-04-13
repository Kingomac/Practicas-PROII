package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class ClienteExcepcion extends Exception {

    /**
     * Creates a new instance of <code>ClienteExcepcion</code> without detail
     * message.
     */
    public ClienteExcepcion() {
    }

    /**
     * Constructs an instance of <code>ClienteExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ClienteExcepcion(String msg) {
        super(msg);
    }
}
