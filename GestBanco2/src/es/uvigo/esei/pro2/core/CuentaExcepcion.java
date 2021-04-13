package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class CuentaExcepcion extends Exception {

    /**
     * Creates a new instance of <code>CuentaExcepcion</code> without detail message.
     */
    public CuentaExcepcion() {
    }


    /**
     * Constructs an instance of <code>CuentaExcepcion</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CuentaExcepcion(String msg) {
        super(msg);
    }
}
