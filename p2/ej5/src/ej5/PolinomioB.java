package ej5;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 *
 * b. En realidad, los grados podrían ser simplemente laposición en un solo
 * vector. Así, para un elemento n del polinomio, el coeficiente sería
 * coeficientes[ n ] (llamémosle c) y el grado el propio valor de n. Así,
 * resultaría en cx^n. Nótese que aquellas posiciones del vector en las que no
 * existe un elemento correspondiente en el polinomio estarían a 0. Así, para
 * x^3 + 9, el vector sería [1, 0, 0, 9].
 *
 *
 */
public class PolinomioB {

    private int grado;
    private double[] coeficientes;

    public PolinomioB(int grado, double[] coeficientes) {
        this.grado = grado;
        this.coeficientes = coeficientes;
    }

    public int getGrado() {
        return grado;
    }

    /**
     * @return Polinomio formateado
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.#; 0.#");
        for (int i = 0; i < coeficientes.length; i++) {
            if (coeficientes[i] != 0) {
                String formateado = df.format(coeficientes[i]);
                if (!formateado.equals("1")) {
                    toret.append(formateado);
                }
                if (i < coeficientes.length - 1) {
                    toret.append("x^");
                    toret.append(coeficientes.length - i - 1);
                    toret.append(coeficientes[i + 1] > -1 ? " + " : " - ");
                }
            }
        }
        toret.append(" = 0");
        return toret.toString();
    }

}
