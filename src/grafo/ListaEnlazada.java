
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class ListaEnlazada <T>{ // Atributos de la clase ListaEnlazada
       private Nodo pFirst;
       private Nodo pLast;
       private int size;
       
     /**
     * Constructor por defecto que inicializa una lista enlazada con los punteros pFirst y pLast como null.
     */
    public ListaEnlazada(){ 
        this.pFirst = this.pLast = null;
    }
       
     /**
    * Constructor que inicializa una lista enlazada con un nodo especificado.
    * @param n el nodo inicial de la lista enlazada
    */
    public ListaEnlazada(Nodo<T> n){ 
        this.pFirst=this.pLast= n;
    }
     
    /**
    * Obtiene el primer nodo de la lista enlazada.
    * @return el primer nodo de la lista enlazada
    */
    public Nodo getpFirst() { 
        return pFirst;
    }
    
     /**
     * Obtiene el ultimo nodo de la lista enlazada.
     * @return el ultimo nodo de la lista enlazada.
     */
    public Nodo getpLast() { 
        return pLast;
    }

      /**
     * Obtiene el tamaño de la lista enlazada. 
     * @return int tamaño de la lista l¡enlazada.
     */
    public int getSize() { 
        return size;
    }
    
    /**
     * Establece el primer nodo de la lista enlazada.
     * @param pFirst el nuevo primer nodo de la lista enlazada.
     */
    public void setpFirst(Nodo pFirst) {  
        this.pFirst = pFirst;
    }
     /**
     * Establece el ultimo nodo de la lista enlazada.
     * @param pLast el nuevo ultimo nodo de la lista enlazada.
     */
    public void setpLast(Nodo pLast) { 
        this.pLast = pLast;
    }
    
    /**
   * Establece el tamaño de la lista.
   * @param size el nuevo tamaño de la lista.
   */
    public void setSize(int size) { 
        this.size = size;
    }
    
    /**
     * Revisa si la lista esta vacia.
     * @return True si esta vacia, false si no.
     */
    public boolean isEmpty(){ 
        return this.pFirst== null;
    }
    
    /**
 * Añade un nodo al inicio de la lista.
 * @param dato el dato que se va a almacenar en el nuevo nodo
 */   
    public void addFirst(T dato) { 
        Nodo<T> n = new Nodo(dato);
        if (isEmpty()) {
            this.pFirst = n;
            this.pLast = n;
            this.pFirst.setpNext(this.pLast);
            this.pLast.setpNext(null);
        } else {
            n.setpNext(this.pFirst);
            this.pFirst= n;
            }
        size++;
      }
    
   /**
 * Verifica si la lista enlazada contiene una arista específica.
 * @param arista la arista que se va a buscar en la lista
 * @return true si la arista ya existe en la lista, false en caso contrario
 */
    public boolean contains(Arista arista){
        Nodo aux = this.pFirst;
        boolean yaExiste = false;
        for (int i = 0; i < size; i++){ 
            Arista aux2 = (Arista) aux.getData();
            if (aux2.destino == arista.destino){
                yaExiste = true;
            }
            aux = aux.getpNext();
        }
        return yaExiste; 
    }
    
   /**
    * Elimina una arista específica de la lista.
    * @param arista la arista que se va a eliminar de la lista
    * @return la arista eliminada si se encuentra, null en caso contrario
    */
    public Arista removeArista(Arista arista){
        if (this.isEmpty()){ 
            return null;
        } else if (((Arista) pFirst.getData()).destino == arista.destino){
            Arista aristaARetornar = (Arista) pFirst.getData();
            this.pFirst = pFirst.getpNext() != null ? this.pFirst.getpNext() : null;
            size--;
            return aristaARetornar;
        } else {
            Nodo prevaux = pFirst;
            Nodo aux = pFirst.getpNext();

            while (aux != null) {
                if (((Arista) aux.getData()).destino == arista.destino) {
                    prevaux.setpNext(aux.getpNext());
                    if (aux.getpNext() == null){
                        this.pLast = prevaux;
                    }
                    size--;
                    return (Arista) aux.getData();
                }
                prevaux = aux;
                aux = aux.getpNext();
            }
            return null;
        } 
    }

    
}


