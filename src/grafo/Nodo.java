
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Nodo<T> { // Atributos de la clase Nodo
    private T data;
    private Nodo pNext;

    public Nodo(T data) {///construector de la clase Nodo
        this.data = data;
        this.pNext = null;
    }

    public void setData(T data) { // Modifica la data de un nodo
        this.data = data;
    }
   
    public void setpNext(Nodo pNext) { // Modifica el apuntador pNext de un nodo 
        this.pNext = pNext;
    }
    
    public T getData() { // Obtiene la data de un nodo
        return data;
    }
    
    public Nodo getpNext() {// Obtiene el apuntador al siguiente de un nodo
        return pNext;
    }
    
}
