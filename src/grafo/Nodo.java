
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Nodo<T> {
    private T data;
    private Nodo pNext;

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
