package ej5;

/**
 *
 * @author Mario
 */
public class Contenedor {

    private Deportista[] deportistas;
    private int numDeportistas;

    /**
     * Nuevo contenedor con un número máximo de deportistas
     *
     * @param maxDeportistas el número máximo de deportistas, como entero
     */
    public Contenedor(int maxDeportistas) {
        numDeportistas = 0;
        deportistas = new Deportista[maxDeportistas];
    }

    /**
     * Devuelve el deportista de la posición pos
     *
     * @param pos la posición en el vector de deportistas
     * @return el objeto Deportista correspondiente
     */
    public Deportista get(int pos) throws Exception {
        if (pos >= getNumDeportistas()) {
            throw new Exception("get(): sobrepasa la pos: " + (pos + 1) + " / "
                    + getMaxDeportistas());
        }
        return deportistas[pos];
    }

    /**
     * Devuelve el número de deportistas creados
     *
     * @return el número de deportistas disponibles en el vector, como entero
     */
    public int getNumDeportistas() {
        return numDeportistas;
    }

    /**
     * Devuelve el máximo de deportistas
     *
     * @return el número de deportistas máximo, como entero
     */
    public int getMaxDeportistas() {
        return deportistas.length;
    }

    /**
     * Inserta un nuevo deportista
     *
     * @param d el nuevo objeto deportista
     */
    public void inserta(Deportista d) throws Exception {
        final int maxDeportistas = getMaxDeportistas();

        if (getNumDeportistas() >= maxDeportistas) {
            throw new Exception("inserta(): sobrepasa max.: "
                    + maxDeportistas);
        }

        deportistas[numDeportistas] = d;
        ++numDeportistas;
    }
}
