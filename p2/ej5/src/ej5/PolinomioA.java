package ej5;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 *
 * a. Utiliza dos vectores paralelos. En el primer vector, almacenarás el
 * coeficiente, mientras en el segundo almacenarás el grado. Para construir el
 * polinomio, dado el elemento n, tomarás el coeficiente de coeficientes[ n ]
 * (llamémosle c), y el grado de grados[ n ] (llamémosle g), con lo que el
 * elemento n será cx^g.
 *
 */
public class PolinomioA {

    private double[] coeficientes;
    private int[] grado;

    public PolinomioA(double[] coeficientes, int[] grado) {
        this.coeficientes = coeficientes;
        this.grado = grado;
    }

    public int getGrado() {
        int max = 0;
        for (int i : grado) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * @return Polinomio formateado
     */
    @Override
    public String toString() {
        if (grado.length != coeficientes.length) {
            return "Entradas no válidas";
        }
        StringBuilder toret = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.#; 0.#");
        for (int i = 0; i < grado.length; i++) {
            if (coeficientes[i] != 0) {
                String formateado = df.format(coeficientes[i]);
                if (!formateado.equals("1")) {
                    toret.append(formateado);
                }
                if (grado[i] > 0) {
                    toret.append("x");
                    if (grado[i] > 1) {
                        toret.append("^");
                        toret.append(grado[i]);
                    }
                    toret.append(coeficientes[i + 1] > -1 ? " + " : " - ");
                }
            }
        }
        toret.append(" = 0");
        return toret.toString();
    }
}
