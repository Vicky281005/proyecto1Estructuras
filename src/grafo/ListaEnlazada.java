package grafo;

import javax.swing.JToggleButton;

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
    /**
 * Imprime en la consola los nombres de los vértices almacenados en una lista
 * enlazada, separados por el símbolo `>`.
 * Utilizada para probar
 */
    public void imprimirListaInvitados(){
        Nodo aux = this.pFirst;
        
        while (aux != null){
            Vertice vertice = (Vertice) aux.getData();
            System.out.print(vertice.getNombre()+" > ");
            aux = aux.getpNext();
        }
    }
    
    
    /**
 * Actualiza la visibilidad y el texto de los botones proporcionados según
 * el estado de los vértices del grafo. Si un vértice no está marcado y su
 * nombre coincide con el nombre del botón, el texto del botón se actualiza
 * con el número de bombas adyacentes y se habilita el botón.
 * 
 * @param buttons Un arreglo de botones `JToggleButton` que representan las casillas a actualizar.
 * @param grafo Un objeto `Grafo` que contiene la estructura del grafo y los vértices asociados.
 
 */
    public void visibilizarBotones(javax.swing.JToggleButton[] buttons, Grafo grafo){
        Nodo aux = this.pFirst;
        
        while (aux != null){
            Vertice vertice = (Vertice) aux.getData();
            for (JToggleButton boton : buttons) {
                if (boton != null){
                    String nombreOriginal = boton.getName(); // Obtén el nombre del botón
                    
                    if (vertice.getNombre().equalsIgnoreCase(nombreOriginal) && !vertice.isMarcado()) {
                        boton.setText(String.valueOf(grafo.casillasBombaAdyacentePorDFS(nombreOriginal)));
                        boton.setEnabled(true);
                        
                    }
                    
                    
                }
            }
            
            aux = aux.getpNext();
        }
        
    }
    
    
    /**
 * Recorre una lista enlazada de vértices y encola en la estructura proporcionada
 * aquellos vértices que han sido barridos pero no están marcados. 
 *
 * @param cola La cola donde se encolarán los vértices que cumplen las condiciones.
 * 
 */
    public void encolarVerticesAUnaCola(Cola cola){
        Nodo aux = this.pFirst;
        while (aux != null){
            Vertice vertice = (Vertice) aux.getData();
            
            if (vertice.isBarrido() && !vertice.isMarcado()){
                cola.encolar(aux.getData());    
            }
            aux = aux.getpNext();
        }
    }
    

}
