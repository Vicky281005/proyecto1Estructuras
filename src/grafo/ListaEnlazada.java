package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class ListaEnlazada<T> { // Atributos de la clase ListaEnlazada

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    /**
     * Constructor Crea una lista vacia
     */
    public ListaEnlazada() {
        this.pFirst = this.pLast = null;
    }

    /**
     * Constructor Crea una lista con un solo elemento
     *
     * @param n Nodo que se aniadira
     */
    public ListaEnlazada(Nodo<T> n) {
        this.pFirst = this.pLast = n;
    }

    /**
     * Devuelve el primer nodo de la lista
     *
     * @return el primer nodo
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Devuelve el ultimo nodo de la lista
     *
     * @return el ultimo nodo
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Devuelve el tamaño de la lista
     *
     * @return int tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Modificar la data del primer nodo
     *
     * @param pFirst
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Modificar la data del ultimo nodo
     *
     * @param pLast
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Modifica el tamaño de la lista
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Revisa si la lista esta vacia o no
     *
     * @return True si esta vacia, false si no
     */
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    /**
     * Se encarga de añadir un nodo en el primer lugar de una lista
     *
     * @param dato
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
            this.pFirst = n;
        }
        size++;
    }

   public void addLast(T dato) {
    Nodo<T> n = new Nodo(dato);
    if (isEmpty()) {
        this.pFirst = n;
        this.pLast = n;
    } else {
        this.pLast.setpNext(n); // Conectar el último nodo actual al nuevo nodo
        this.pLast = n;         // Actualizar pLast al nuevo nodo
    }
    size++;
}

    /**
     * Busca si existe la arista en la lista enlazada
     *
     * @param arista
     * @return
     */
    public boolean contains(Arista arista) {

        Nodo aux = this.pFirst;

        boolean yaExiste = false;

        for (int i = 0; i < size; i++) {

            Arista aux2 = (Arista) aux.getData();
            if (aux2.destino == arista.destino) {
                yaExiste = true;
            }
            aux = aux.getpNext();
        }
        return yaExiste;
    }

    /**
     * Remueve la Arista, ya creada
     *
     * @param arista
     * @return
     */
    public Arista removeArista(Arista arista) {

        if (this.isEmpty()) {
            return null;
        } else if (((Arista) pFirst.getData()).destino == arista.destino) {
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
                    if (aux.getpNext() == null) {
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

    /**
     * Obtiene el primer nodo de una lista enlazada
     * @param g
     * @return
     * @throws Exception 
     */
    public int bombasAdy(Grafo g) throws Exception {
        Nodo aux = this.getpFirst();
        int b = 0;
        while (aux != null) {
            if (g.DevuelveVertice2((aux.getData().toString())).isSoyUnaBomba()) {
                b++;
            }
            aux = aux.getpNext();
        }
        return b;
    }
    /**
     * Busca los nodos dentro de la lista enlazada
     * @param ind
     * @return 
     */
    public boolean buscar(String ind){
        Nodo aux = this.getpFirst();
        while (aux != null) {
            if (aux.getData().toString().equals(ind)) {
               return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }
}
