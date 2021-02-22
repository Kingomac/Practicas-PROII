package ej4;

/**
 *
 * @author Mario
 */
public class PoligonoRegular {

    private int numLados;

    public PoligonoRegular(int lados) {
        numLados = lados;
        if (numLados < 3) {
            numLados = 3;
        }
    }

    public int getNumLados() {
        return numLados;
    }

    public int getNumAngulos() {
        return 360 / numLados;
    }
}
