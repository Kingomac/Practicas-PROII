package ej4;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 *
 *
 * Un alumno de PROII se define por un dni (sin letra), unos apellidos y un
 * nombre. Además, tiene cinco notas asociadas, una para el Bloque I, otra para
 * el Bloque II, la correspondiente al Bloque III, otra para Programación y
 * finalmente la de Practicas. Además de un constructor (que aceptará DNI,
 * apellidos y nombre), y miembros getter, será necesario también un miembro o
 * miembros setter para poder cambiar las cinco notas (se recomienda utilizar un
 * vector para almacenar las notas, y un enumerado para los valores a evaluar:
 * BLOQUE_I, BLOQUE__I, BLOQUE_III, PROGRAMACION, PRACTICAS). La nota final se
 * calcula sabiendo que la nota de cada bloque tiene un peso del 15%, la nota de
 * programación tiene un peso del 30%, y la de prácticas el 25% restante. Los
 * alumnos se visualizan de la siguiente forma: "dni - apellidos, nombre: nota
 * final". La nota final de un alumno se visualiza como un mensaje de texto
 * indicando la calificación (suspenso, aprobado, notable o sobresaliente), y
 * entre paréntesis la nota numérica, por ejemplo: aprobado(5.6).
 *
 */
public class Alumno {

    public static enum Nota {
        BLOQUE_I, BLOQUE_II, BLOQUE_III, PROGRAMACION, PRACTICAS
    }
    private static final double[] ponderaciones = new double[]{0.15, 0.15, 0.15,
        0.3, 0.25};

    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    private final int dni;
    private final String apellidos;
    private final String nombre;

    private double[] notas;

    public Alumno(int dni, String apellidos, String nombre) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.notas = new double[Nota.values().length];
    }

    public int getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota(Nota nota) {
        return this.notas[nota.ordinal()];
    }

    public void setNota(Nota tipo, double nota) {
        this.notas[tipo.ordinal()] = nota;
    }

    /**
     * Cada bloque tiene un peso del 15%, la nota de programación tiene un peso
     * del 30%, y la de prácticas el 25% restante
     *
     * @return ejemplo: aprobado(5.6)
     */
    public String calcularNotaFinal() {
        String toret;
        DecimalFormat df = new DecimalFormat("##.#");
        double nota = 0;
        for (int i = 0; i < Nota.values().length; i++) {
            nota += getNota(Nota.values()[i]) * ponderaciones[i];
        }
        if (nota < 5) {
            toret = "suspenso(";
        } else if (nota >= 5 && nota < 7) {
            toret = "aprobado(";
        } else if (nota >= 7 && nota < 9) {
            toret = "notable(";
        } else {
            toret = "sobresaliente(";
        }

        return toret + df.format(nota) + ")";
    }

    /**
     * Devuelve la información de el alumno con el formato: dni - apellidos,
     * nombre: nota final
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(getDni());
        toret.append(LETRAS_DNI.charAt(getDni() % 23));
        toret.append(" - ");
        toret.append(getApellidos());
        toret.append(", ");
        toret.append(getNombre());
        toret.append(": ");
        toret.append(calcularNotaFinal());
        return toret.toString();
    }

}
