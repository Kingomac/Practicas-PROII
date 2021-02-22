/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

/**
 *
 * @author Mario
 */
public class Punto {

    /**
     * El origen de coordenadas
     */
    public static final Punto ORIGEN = new Punto(0, 0);

    private int x;
    private int y;

    /**
     * Construye un objeto Punto a partir de sus coordenadas
     *
     * @param a la coordenada x
     * @param b la coordenada y
     */
    public Punto(int a, int b) {
        x = a;
        y = b;
    }

    /**
     * @return La coordenada x
     */
    public int getX() {
        return x;
    }

    /**
     * @return La coordenada y
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calcula la distancia a (0, 0)
     *
     * @return la distancia, como un double
     */
    public double calculaDistanciaOrigen() {
        double toret = (x * x) + (y * y);
        return Math.sqrt(toret);
    }

    public int getCuadrante() {
        if (getX() > 0 && getY() > 0) {
            return 1;
        }
        if (getX() < 0 && getY() < 0) {
            return 3;
        }
        if (getX() < 0 && getY() > 0) {
            return 2;
        }
        return 4;
    }

    /**
     * @return info del objeto como una cadena
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
