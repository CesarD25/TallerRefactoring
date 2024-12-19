import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static Singleton instancia;

    private final List<Opciones> listaObjetos;

    private Singleton() {
        listaObjetos = new ArrayList<>();
    }

    public static Singleton getInstancia() {
        if (instancia == null) {
            synchronized (Singleton.class) { 
                if (instancia == null) {
                    instancia = new Singleton();
                }
            }
        }
        return instancia;
    }

    public void agregarObjeto(Opciones objeto) {
        if (objeto != null) {
            listaObjetos.add(objeto);
            System.out.println("Objeto agregado: " + objeto.getClass().getSimpleName());
        }
    }

    public void eliminarObjeto(Opciones objeto) {
        if (listaObjetos.remove(objeto)) {
            System.out.println("Objeto eliminado: " + objeto.getClass().getSimpleName());
        } else {
            System.out.println("El objeto no se encontró en la lista.");
        }
    }

    public List<Opciones> obtenerLista() {
        return new ArrayList<>(listaObjetos); 
    }
}


