package ej4;

import java.time.LocalTime;

/**
 *
 * @author Mario
 *
 *
 * Clase ProgramacionDiaria que es responsable de almacenar todos los programas
 * de un día, así como de crear un nuevo programa (a partir de un título, un
 * nombre de locutor, y una duración), asignándolo a la siguiente hora
 * disponible. Esta clase es también responsable de saber cuántos minutos
 * disponibles y ocupados hay en la programación diaria
 *
 */
public class ProgramacionDiaria {

    private ProgramaRadio[] programas;
    private int numProgramas;
    private int minutosOcupados;

    /**
     * Crea una programación vacía que puede llegar a ocupar un día entero
     */
    public ProgramacionDiaria() {
        programas = new ProgramaRadio[(int) (ProgramaRadio.MIN_DURACION / 60 * 24)];
        minutosOcupados = 0;
        numProgramas = 0;
    }

    public int getMinutosOcupados() {
        return minutosOcupados;
    }

    /**
     * Añade un programa a la ProgramacionDiaria
     *
     * @param programa Programa que se va a añadir
     * @throws Exception Se produce en caso de que se supere el máximo de
     * programas o de minutos del día
     */
    public void crearPrograma(ProgramaRadio programa) throws Exception {
        if (numProgramas == 24) {
            throw new Exception("Alcanzado número máximo de programas");
        }
        if (minutosOcupados + programa.getDuracion() > 24 * 60) {
            throw new Exception("Alcanzados máximos minutos de programas");
        }
        minutosOcupados += programa.getDuracion();
        programas[numProgramas] = programa;
        numProgramas++;
    }

    /**
     * Devuelve la información de los programas ordenados y con formato Inicio -
     * Fin / Título / Locutor / Duración
     *
     * @return String con toda la información
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        LocalTime ultimaHora = LocalTime.MIN;
        toret.append("Inicio - Fin (hora:minuto) / Título / Locutor / Duración\n");
        for (int i = 0; i < numProgramas; i++) {
            toret.append(ultimaHora).append(" - ");
            ultimaHora = ultimaHora.plusMinutes(programas[i].getDuracion());
            toret.append(ultimaHora).append(" / ").append(programas[i].getTitulo())
                    .append(" / ").append(programas[i].getLocutor()).append(" / ")
                    .append(programas[i].getDuracion()).append(" minutos\n");
        }
        return toret.toString();
    }
}
