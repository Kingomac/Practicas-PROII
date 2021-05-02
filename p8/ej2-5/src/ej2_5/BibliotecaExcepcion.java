package ej2_5;

/**
 *
 * @author Mario
 */
public class BibliotecaExcepcion extends Exception {

    /**
     * Creates a new instance of <code>BibliotecaExcepcion</code> without detail message.
     */
    public BibliotecaExcepcion() {
    }


    /**
     * Constructs an instance of <code>BibliotecaExcepcion</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BibliotecaExcepcion(String msg) {
        super(msg);
    }
}
