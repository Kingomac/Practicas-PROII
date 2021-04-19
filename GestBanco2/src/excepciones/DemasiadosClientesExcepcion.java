package excepciones;

/**
 *
 * @author Mario
 */
public class DemasiadosClientesExcepcion extends BancoException {

    /**
     * Creates a new instance of <code>DemasiadosClientesExcepcion</code>
     * without detail message.
     */
    public DemasiadosClientesExcepcion() {
    }

    /**
     * Constructs an instance of <code>DemasiadosClientesExcepcion</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DemasiadosClientesExcepcion(String msg) {
        super(msg);
    }
}
