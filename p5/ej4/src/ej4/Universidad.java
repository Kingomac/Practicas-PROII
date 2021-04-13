package ej4;

/**
 *
 * @author Mario
 */
public class Universidad {

    private Persona[] personas;
    private String nombre;
    private int numPersonas;

    public Universidad(int maxPersonas, String nombre) {
        this.nombre = nombre;
        numPersonas = 0;
        personas = new Persona[maxPersonas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxPersonas() {
        return personas.length;
    }

    public void insertar(Persona p) throws Exception {
        if (numPersonas == personas.length) {
            throw new Exception("Número máximo de personas alcanzado");
        }
        personas[numPersonas++] = p;
    }

    public void borrar(int i) throws Exception {
        if (i < 0 || i >= numPersonas) {
            throw new Exception("La posición no es válida");
        }
        personas[i] = personas[--numPersonas];
    }

    public String listar(int opc) {
        StringBuilder toret = new StringBuilder();
        for (int i = 0; i < numPersonas; i++) {
            switch (opc) {
                case 1:
                    if (personas[i] instanceof Alumno) {
                        toret.append(personas[i]);
                    }
                    break;
                case 2:
                    if (personas[i] instanceof Erasmus) {
                        toret.append(personas[i]);
                    }
                    break;
                case 3:
                    if (personas[i] instanceof Profesor) {
                        toret.append(personas[i]);
                    }
            }
            toret.append("\n");
        }
        return toret.toString();
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
