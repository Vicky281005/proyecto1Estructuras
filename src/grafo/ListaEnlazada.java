
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
       
       
    public ListaEnlazada(){ // Constructor, Crea una lista vacia
        this.pFirst = this.pLast = null;
    }
       
    public ListaEnlazada(Nodo<T> n){ // Constructor, Crea una lista con un solo elemento, * @param n Nodo que se agrega
        this.pFirst=this.pLast= n;
    }
     
    public Nodo getpFirst() { // Devuelve el primer nodo de la lista @return el primer nodo
        return pFirst;
    }
    
    public Nodo getpLast() { // Devuelve el ultimo nodo de la lista @return el ultimo nodo
        return pLast;
    }

    public int getSize() { // Devuelve el tamaño de la lista ,@return int tamaño de la lista
        return size;
    }

    public void setpFirst(Nodo pFirst) { // Modificar la data del primer nodo, @param pFirst 
        this.pFirst = pFirst;
    }

    public void setpLast(Nodo pLast) { // Modificar la data del ultimo nodo, @param pLast 
        this.pLast = pLast;
    }

    public void setSize(int size) { // Modifica el tamaño de la lista, @param size 
        this.size = size;
    }

    public boolean isEmpty(){ // Revisa si la lista esta vacia o no, @return True si esta vacia, false si no
        return this.pFirst== null;
    }
         
    public void addFirst(T dato) { // Agrega un nodo en el primer lugar de una lista @param dato 
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
    
    public boolean contains(Arista arista){ // Método para verificar si una arista específica ya existe en una lista de aristas.
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
    
    public Arista removeArista(Arista arista){ // Método para eliminar una arista específica de una lista de aristas.      
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


