package ej2;

/**
 *
 * @author Mario
 *
 * Una dirección de correo electrónico se compone de un nombre, apellidos,
 * usuario y servidor. Las direcciones de correo se expresan como "apellidos,
 * nombre: usuario@servidor". Una de estas direcciones de correo se puede crear
 * de dos maneras: aportando los cuatro valores, o solamente dos (apellidos y
 * nombre). En este último caso, se construye el usuario del correo con el
 * primer apellido, y la inicial del nombre; el servidor será siempre
 * "esei.uvigo.es".
 *
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CorreoElectronico a = new CorreoElectronico("Mario", "Vila Comesaña");
        CorreoElectronico b = new CorreoElectronico("Mario", "Vila Comesaña", "vcmario", "gmail.com");
        System.out.println("Constructor 1: " + a.toString());
        System.out.println("Constructor 2: " + b.toString());
    }
}
