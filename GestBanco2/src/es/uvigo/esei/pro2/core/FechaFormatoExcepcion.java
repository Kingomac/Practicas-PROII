/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author Mario
 */
public class FechaFormatoExcepcion extends Exception {

    /**
     * Creates a new instance of <code>FechaFormatoException</code> without
     * detail message.
     */
    public FechaFormatoExcepcion() {
    }

    /**
     * Constructs an instance of <code>FechaFormatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FechaFormatoExcepcion(String msg) {
        super(msg);
    }
}
