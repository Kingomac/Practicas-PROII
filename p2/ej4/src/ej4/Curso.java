package ej4;

/**
 *
 * @author Mario
 */
public class Curso {

    private Alumno[] alumnos;
    private int cont;
    private final int maxAlumnos;

    public Curso(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
        this.alumnos = new Alumno[maxAlumnos];
    }

    public int getCont() {
        return cont;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void insertar(Alumno a) throws Exception {
        if (cont + 1 == maxAlumnos) {
            throw new Exception("Capacidad máxima de alumnos alcanzada");
        }
        alumnos[cont++] = a;
    }

    public Alumno getAlumno(int pos) throws Exception {
        if (pos < 0 || pos > getCont() - 1) {
            throw new Exception("Posición inválida");
        }
        return alumnos[pos];
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < getCont(); i++) {
            toret.append(i + 1).append(". ").append(alumnos[i]);
        }
        return toret.toString();
    }
}
