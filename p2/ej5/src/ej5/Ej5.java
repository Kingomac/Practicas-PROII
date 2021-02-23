package ej5;

/**
 *
 * @author Mario
 *
 *
 * Un polinomio se representa como sigue x^3 + 2x^2 + 5x + 9 = 0, y es muy
 * sencillo de almacenar teniendo en cuenta que solamente es necesario recordar,
 * para cada elemento, la constante por la que se multiplica (el coeficiente), y
 * el factor al que elevar (el grado). Así, en el caso anterior, los pares (1,
 * 3), (2, 2), (5, 1) y (9, 0) representarían el polinomio x^3 + 2x^2 + 5x + 9 =
 * 0. Crea la clase Polinomio empleando las siguientes estrategias:
 *
 * a. Utiliza dos vectores paralelos. En el primer vector, almacenarás el
 * coeficiente, mientras en el segundo almacenarás el grado. Para construir el
 * polinomio, dado el elemento n, tomarás el coeficiente de coeficientes[ n ]
 * (llamémosle c), y el grado de grados[ n ] (llamémosle g), con lo que el
 * elemento n será cx^g.
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
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PolinomioA pA = new PolinomioA(new double[]{5.4, -2, 1, 3}, new int[]{4, 3, 2, 0});
        PolinomioB pB = new PolinomioB(4, new double[]{5.4, -2, 1, 0, 3});
        System.out.println("Polinomio A: " + pA);
        System.out.println("Polinomio B: " + pB);
    }

}
