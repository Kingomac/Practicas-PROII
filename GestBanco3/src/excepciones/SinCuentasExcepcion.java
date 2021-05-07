package excepciones;

/**
 *
 * @author Mario
 */
public class SinCuentasExcepcion extends CuentaExcepcion {

    /**
     * Creates a new instance of <code>SinCuentasExcepcion</code> without detail
     * message.
     */
    public SinCuentasExcepcion() {
    }

    /**
     * Constructs an instance of <code>SinCuentasExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SinCuentasExcepcion(String msg) {
        super(msg);
    }
}
