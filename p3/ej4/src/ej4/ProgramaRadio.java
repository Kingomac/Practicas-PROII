package ej4;

/**
 *
 * @author Mario
 *
 * Clase ProgramaRadio en la que se almacena el título del programa, el nombre
 * del locutor, la duración en minutos y la hora a la que empieza dicho
 * programa. La duración mínima de un programa será de 60 minutos, por lo que no
 * será posible crear programas con una duración más corta
 *
 */
public class ProgramaRadio {

    public static final int MIN_DURACION = 60;

    private String titulo;
    private String locutor;
    private int duracion;

    /**
     * Crea un programa de radio
     *
     * @param titulo String título del programa
     * @param locutor String locutor del programa
     * @param duracion int duración en minutos del programa
     * @throws Exception Se produce cuando la duración es inferior a la duración
     * mínima
     */
    public ProgramaRadio(String titulo, String locutor, int duracion) throws Exception {
        if (duracion < MIN_DURACION) {
            throw new Exception("Duración del programa inferior a " + MIN_DURACION + " minutos");
        }
        this.duracion = duracion;
        this.titulo = titulo;
        this.locutor = locutor;
    }

    /**
     * Crea un programa de radio vacío por defecto
     */
    public ProgramaRadio() {
        titulo = "";
        locutor = "";
        duracion = MIN_DURACION;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLocutor() {
        return locutor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setLocutor(String locutor) {
        this.locutor = locutor;
    }

    public void setDuracion(int duracion) throws Exception {
        if (duracion < MIN_DURACION) {
            throw new Exception("Duración del programa inferior a 60 minutos");
        }
        this.duracion = duracion;
    }

}
