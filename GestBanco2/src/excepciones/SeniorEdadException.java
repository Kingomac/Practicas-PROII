package excepciones;

/**
 *
 * @author Mario
 */
public class SeniorEdadException extends CuentaExcepcion {

    /**
     * Creates a new instance of <code>SeniorEdadException</code> without detail
     * message.
     */
    public SeniorEdadException() {
    }

    /**
     * Constructs an instance of <code>SeniorEdadException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SeniorEdadException(String msg) {
        super(msg);
    }
}
