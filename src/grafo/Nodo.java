
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Nodo<T> { // Atributos de la clase Nodo
    private T data;
    private Nodo pNext;

    public Nodo(T data) {///constructor de la clase Nodo
        this.data = data;
        this.pNext = null;
    }
     /**
     * Se encarga de modificar la data de un nodo
     * @param data 
     */
    public void setData(String data, String nombreVertice) { 
        this.data = (T) data;
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

    public void setAttribute(String uilabel, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
