package ej4;

/**
 *
 * @author Mario
 *
 * Un polígono regular es una figura que está formada por un número de lados
 * numLados. Los polígonos se expresan como "Polígono de lados: numLados y
 * angulos:numAngulos". Para calcular los ángulos entre los lados del polígono,
 * se divide 360 entre el número de lados. El polígono regular más pequeño
 * posible es el de tres lados (un triángulo equilátero).
 *
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PoligonoRegular triangulo = new PoligonoRegular(3);
        System.out.println("Ángulos: " + triangulo.getNumAngulos());
    }

}
