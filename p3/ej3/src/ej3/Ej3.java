package ej3;

/**
 *
 * @author Mario
 *
 * Las personas se definen por unos apellidos, un nombre y un dni, que es un
 * número. A la hora de visualizarlas, se hace de la forma “dni - apellidos,
 * nombre”. La letra del DNI se puede calcular a partir de la cadena.
 * “TRWAGMYFPDXBNJZSQVHLCKE”, de forma que la letra escogida es el número del
 * DNI módulo 23.
 *
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona yo;
        Persona p;
        try {
            yo = new Persona("Mario", "Vila Comesaña", 395128160);
            System.out.println(yo);
        } catch (Exception exc) {
            System.out.println("Error creando la persona: " + exc.getMessage());
        }
        try {
            p = new Persona("Juan", "Rodríguez Rodríguez", 14326589);
            System.out.println(p);
        } catch (Exception exc) {
            System.out.println("Error creando la persona: " + exc.getMessage());
        }

    }

}
