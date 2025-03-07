
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class Cola {
// Atributos de la clase Cola
    private NodoCola frente, finalCola;
    
    private class NodoCola{
        NodoArbol valor;
        NodoCola siguiente;
        
        NodoCola(NodoArbol valor){
            this.valor= valor; 
            this.siguiente= null;
        
        }
    }
    /**
    * Constructor por defecto que inicializa los punteros frente y finalCola como null.
    */
    public Cola(){
        frente= finalCola=null;
    }
    
     /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia(){
        return frente==null;
    }
    
    /**
     * Añade nuevos elementos a la cola
     * @param valor 
     */
    public void encolar(NodoArbol valor){
        NodoCola nuevo= new NodoCola(valor);
        if (finalCola != null){
            finalCola.siguiente=nuevo;
        }
        finalCola=nuevo;
        if(frente== null){
            frente= finalCola;
        }
    }
    
   /**
 * Elimina y devuelve el primer nodo de la cola.
 * @return el nodo eliminado de la cola, o null si la cola está vacía
 */
    public NodoArbol desencolar(){
        if (frente== null){
            return null; // la cola esta vacia :)
        }
        NodoArbol valor=frente.valor;
        frente= frente.siguiente;
        if(frente==null){
            finalCola=null;
        }
        return valor;
    }
    
}

