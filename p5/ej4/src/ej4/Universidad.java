package ej4;

/**
 *
 * @author Mario
 */
public class Universidad {

    private final int MAX_PERSONAS;
    private Persona[] personas;
    private String nombre;
    private int numPersonas;

    public Universidad(int MAX_PERSONAS, String nombre) {
        this.MAX_PERSONAS = MAX_PERSONAS;
        this.nombre = nombre;
        numPersonas = 0;
        personas = new Persona[MAX_PERSONAS];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxPersonas() {
        return MAX_PERSONAS;
    }

    public void insertar(Persona p) throws Exception {
        if (numPersonas == MAX_PERSONAS) {
            throw new Exception("Número máximo de personas alcanzado");
        }
        personas[numPersonas++] = p;
    }

    public void borrar(int i) throws Exception {
        if (i < 0 || i > numPersonas) {
            throw new Exception("La posición no es válida");
        }
        personas[i] = personas[--numPersonas];
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < numPersonas; i++) {
            toret.append(personas[i]);
        }
        return toret.toString();
    }
}
