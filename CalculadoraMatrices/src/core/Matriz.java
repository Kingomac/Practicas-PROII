package core;

/**
 *
 * @author Mario
 */
public class Matriz {

    private double numeros[][];
    private int numFilas;
    private int numColumnas;

    public Matriz(int m, int n) {
        numFilas = m;
        numColumnas = n;
        numeros = new double[m][n];
    }

    public Matriz(double[][] m) {
        numeros = m;
        numFilas = m.length;
        numColumnas = m[0].length;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void insertarFila(double... fila) {
        double[][] nuevo = new double[numFilas + 1][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            nuevo[i] = numeros[i];
        }
        nuevo[numFilas++] = fila;
        numeros = nuevo;
    }

    public void insertarColumna(double... columna) {
        double[][] nuevo = new double[numFilas][numColumnas + 1];
        for (int i = 0; i < numColumnas; i++) {
            for (int j = 0; j < numFilas; j++) {
                nuevo[j][i] = numeros[i][j];
            }
        }
        for (int i = numColumnas - 1; i < numColumnas + 1; i++) {
            for (int j = 0; j < numFilas; j++) {
                nuevo[j][i] = columna[j];
            }
        }
        numeros = nuevo;
    }

    public double get(int i, int j) throws Exception {
        if (i > numFilas || i < 0 || j < 0 || j > numColumnas) {
            throw new Exception("No se puede obtener la posición");
        }
        return numeros[i][j];
    }

    public Matriz sumar(Matriz m) throws Exception {
        if (m.getNumColumnas() != numColumnas || m.getNumFilas() != numFilas) {
            throw new Exception("No se pueden sumar dos matrices con número de filas o columnas diferentes");
        }
        double[][] suma = new double[numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                suma[i][j] = numeros[i][j] + m.get(i, j);
            }
        }
        return new Matriz(suma);
    }

    public Matriz multiplicar(Matriz m) throws Exception {
        if (numColumnas != m.getNumFilas()) {
            throw new Exception("No se pueden multiplicar las matrices");
        }
        double[][] multiplicacion = new double[numFilas][m.getNumColumnas()];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < m.getNumColumnas(); j++) {
                for (int k = 0; k < numColumnas; k++) {
                    multiplicacion[i][j] += numeros[i][k] * m.get(k, j);
                }
            }
        }
        return new Matriz(multiplicacion);
    }

    public Matriz traspuesta() {
        double[][] m = new double[numeros[0].length][numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[0].length; j++) {
                m[j][i] = numeros[i][j];
            }
        }
        return new Matriz(m);
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                toret.append(numeros[i][j]).append(" ");
            }
            toret.append("\n");
        }
        return toret.toString();
    }
}
