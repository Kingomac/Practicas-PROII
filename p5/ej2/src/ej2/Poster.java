package ej2;

import ej5.Autor;
import ej6.ExcedeDuracionException;
import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * 2. En algunos congresos se utilizan también los pósteres para el intercambio
 * de conocimiento. Crea la clase Poster, subclase de la clase Comunicacion del
 * ejercicio anterior, donde se gestiona el nombre de la sesión en la que se
 * expone, sala, hora de inicio (hora y minuto) y número de horas que dura la
 * exposición del póster (no puede ser menor de 4 horas) .
 *
 * 3. Las publicaciones científicas normalmente citan a otras. Añade, al
 * ejercicio anterior, la posibilidad de guardar el número de citas que tiene
 * una publicación dada.
 *
 * @author Mario
 */
public class Poster extends Comunicacion {

    private final int MIN_HORAS = 4;

    private String nombreSesion;
    private LocalTime horaInicio;
    private Duration duracion;

    /**
     * Crea un póster
     *
     * @param nombreSesion String Nombre de la sesión
     * @param horaInicio LocalTime Hora de inicio local al lugar
     * @param duracion Duration Duración en minutos de la sesión
     * @param nombreCongreso String Nombre de congreso
     * @param ciudad String Ciudad
     * @param pais String País
     * @param titulo String Título
     * @param anho int Año
     * @param citas int Número de citas
     * @param autores Autor[] Autores del Póster
     */
    public Poster(String nombreSesion, LocalTime horaInicio, Duration duracion, String nombreCongreso, String ciudad, String pais, String titulo, int anho, int citas, Autor... autores) {
        super(nombreCongreso, ciudad, pais, titulo, anho, citas, autores);
        this.nombreSesion = nombreSesion;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
    }

    /**
     * Crea un póster
     *
     * @param nombreSesion String Nombre de la sesión
     * @param horaInicio int Hora de inicio
     * @param minutoInicio int Minuto de inicio
     * @param duracion long Duración en minutos de la sesión
     * @param nombreCongreso String Nombre de congreso
     * @param ciudad String Ciudad
     * @param pais String País
     * @param titulo String Título
     * @param anho int Año
     * @param citas int Número de citas
     * @param autores Autor[] Autores del Póster
     */
    public Poster(String nombreSesion, int horaInicio, int minutoInicio, long duracion, String nombreCongreso, String ciudad, String pais, String titulo, int anho, int citas, Autor... autores) {
        super(nombreCongreso, ciudad, pais, titulo, anho, citas, autores);
        this.nombreSesion = nombreSesion;
        this.horaInicio = LocalTime.of(horaInicio, minutoInicio);
        this.duracion = Duration.ofMinutes(duracion);
    }

    /**
     * Crea un póster
     *
     * @param com Comunicacion Comunicación de la sesión
     * @param nombreSesion String Nombre de la sesión
     * @param horaInicio LocalTime Hora de inicio local al lugar
     * @param duracion Duration Duración en minutos de la sesión
     * @param citas int Número de citas
     * @param autores Autor[] Autores del Póster
     */
    public Poster(Comunicacion com, String nombreSesion, LocalTime horaInicio, Duration duracion, int citas, Autor... autores) {
        super(com.getNombreCongreso(), com.getCiudad(), com.getPais(), com.getTitulo(), com.getAnho(), citas, autores);
        this.nombreSesion = nombreSesion;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
    }

    /**
     *
     * @param com Comunicacion Comunicación de la sesión
     * @param nombreSesion String Nombre de la sesión
     * @param horaInicio int Hora de inicio
     * @param minutoInicio int Minuto de inicio
     * @param duracion long Duración en minutos de la sesión
     * @param citas int Número de citas
     * @param autores Autor[] Autores del Póster
     */
    public Poster(Comunicacion com, String nombreSesion, int horaInicio, int minutoInicio, long duracion, int citas, Autor... autores) {
        super(com.getNombreCongreso(), com.getCiudad(), com.getPais(), com.getTitulo(), com.getAnho(), citas, autores);
        this.nombreSesion = nombreSesion;
        this.horaInicio = LocalTime.of(horaInicio, minutoInicio);
        this.duracion = Duration.ofMinutes(duracion);
    }

    public String getNombreSesion() {
        return nombreSesion;
    }

    public void setNombreSesion(String nombreSesion) {
        this.nombreSesion = nombreSesion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) throws ExcedeDuracionException {
        if (duracion.getSeconds() < MIN_HORAS * 3600) {
            throw new ExcedeDuracionException("Duración de la sesión sobrepasada en " + (MIN_HORAS * 3600 - duracion.getSeconds()) + " segundos");
        }
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("Sesión: ").append(nombreSesion).append("\n\tCongreso: ")
                .append("Hora inicio: ").append(horaInicio).append("\n\tDuración: ")
                .append(duracion.toHours()).append(" h ");
        if (duracion.toMinutes() - duracion.toHours() * 60 != 0) {
            toret.append(duracion.toMinutes() - duracion.toHours() * 60).append(" m");
        }
        toret.append("\n\tCongreso: ").append(super.getNombreCongreso());
        return toret.toString();
    }

}
