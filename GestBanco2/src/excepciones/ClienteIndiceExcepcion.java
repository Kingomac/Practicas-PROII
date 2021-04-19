package excepciones;

/**
 *
 * @author Mario
 */
public class ClienteIndiceExcepcion extends BancoException {

    /**
     * Creates a new instance of <code>ClienteNoExisteExcepcion</code> without
     * detail message.
     */
    public ClienteIndiceExcepcion() {
    }

    /**
     * Constructs an instance of <code>ClienteNoExisteExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ClienteIndiceExcepcion(String msg) {
        super(msg);
    }
}
