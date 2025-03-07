
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Nodo<T> { // Atributos de la clase Nodo
    private T data;
    private Nodo pNext;

    /**
    * Constructor que inicializa un nodo con el dato especificado y el siguiente nodo como null.
    * @param data el dato que se va a almacenar en el nodo
    */
    public Nodo(T data) {
        this.data = data;
        this.pNext = null;
    }
     /**
     * Se encarga de modificar la data de un nodo
     * @param data 
     */
    public void setData(T data) { 
        this.data = data;
    }
    /**
     * Modifica el apuntador pNext de un nodo
     * @param pNext 
     */
    public void setpNext(Nodo pNext) { 
        this.pNext = pNext;
    }
    /**
     * Obtiene la data de un nodo
     * @return 
     */
    public T getData() { 
        return data;
    }
     /**
     * Obtiene el apuntador al siguiente de un nodo
     * @return 
     */
    public Nodo getpNext() {
        return pNext;
    }
    
}
