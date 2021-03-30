package ui;

import core.Matriz;

/**
 *
 * @author Mario
 */
public class Calculadora {

    private Matriz resultado;

    public Calculadora(Matriz m) {
        resultado = m;
    }

    public Matriz getResultado() {
        return resultado;
    }

    public void sumar(Matriz m) throws Exception {
        resultado = resultado.sumar(m);
    }

    public void multiplicar(Matriz m) throws Exception {
        resultado = resultado.multiplicar(m);
    }

    public void traspuesta() {
        resultado = resultado.traspuesta();
    }
}
