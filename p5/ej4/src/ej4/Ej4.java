package ej4;

/**
 *
 * Implementa la clase Persona, que contenga al menos un atributo DNI y disponga
 * de un constructor parametrizado. A partir de ella, define la clase Alumno,
 * conteniendo al menos un atributo planEstudios y un constructor parametrizado,
 * y la clase Profesor, conteniendo al menos un atributo despacho, y otro
 * asignatura, además de su constructor parametrizado. Crea el método toString()
 * para cada clase.
 *
 * @author Mario
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona a = new Persona("12345678Z", "Persona A");
        Alumno b = new Alumno("nuevo", "87654321", "Alumno B");
        Profesor c = new Profesor(322, "PROII", "23456789X", "Profesor C");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
