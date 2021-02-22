package ej1;

/**
 *
 * @author Mario
 *
 * Los puntos son coordenadas cartesianas de dos dimensiones x e y que se
 * expresan como “(x, y)”. Es posible calcular la distancia al origen (que
 * siempre es (0, 0)) mediante la raíz cuadrada de la suma de las coordenadas al
 * cuadrado.
 *
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto p1 = new Punto(2, 3);
        System.out.println("La distancia a "
                + Punto.ORIGEN + " es "
                + p1.calculaDistanciaOrigen());

        System.out.println("Está en el cuadrante " + p1.getCuadrante());
    }

}
