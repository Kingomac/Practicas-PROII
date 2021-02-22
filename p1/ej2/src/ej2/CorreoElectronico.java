package ej2;

/**
 *
 * @author Mario
 */
public class CorreoElectronico {

    private String nombre, apellidos, usuario, servidor;
    private static final String SERVIDOR_DEFECTO = "esei.uvigo.es";

    public CorreoElectronico(String nombre, String apellidos, String usuario, String servidor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.servidor = servidor;
    }

    public CorreoElectronico(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        usuario = apellidos.split(" ")[0] + nombre.charAt(0);
        usuario = usuario.toLowerCase();
        servidor = SERVIDOR_DEFECTO;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServidor() {
        return servidor;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(getApellidos());
        s.append(", ");
        s.append(getNombre());
        s.append(": ");
        s.append(getUsuario());
        s.append("@");
        s.append(getServidor());
        return s.toString();
    }

}
