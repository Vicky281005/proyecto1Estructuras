package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Vertice { // Atributos de la clase vertice

    private String nombre;
    private int numeroVertice;
    private boolean soyUnaBomba;
    private String emoji;
    private ListaEnlazada<Object> lad;

    public Vertice(String nom) { // Es el constructor, se encarga de crear un nuevo vertice y nom es el nombre del vertice
        nombre = nom;
        numeroVertice = -1;
        lad = new ListaEnlazada();
        this.soyUnaBomba = false;
        this.emoji = "";
    }

    public Vertice(String nom, boolean soyUnaBomba) { //  Constructor, Se encarga de crear un nuevo vertice y recibe si es bomba o no, nom nombre del vertice y soyUnaBomba booleano true si es bomba, false si no es bomba
        nombre = nom;
        numeroVertice = -1;
        lad = new ListaEnlazada();
        this.soyUnaBomba = soyUnaBomba;
        this.emoji = soyUnaBomba ? "💣" : "";
    }

/**
 * Getters y Setters que no estaba añadido
 * @return
 */
    public ListaEnlazada<Object> getLad() {
        return lad;
    }

    public void setLad(ListaEnlazada<Object> lad) {
        this.lad = lad;
    }

    /**
     * Obtiene el emoji de si es bomba o no
     *
     * @return emoji de bomba o vacio
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Modifica si un vertice es bomba o no
     *
     * @param soyUnaBomba booleano true si es bomba, false si no
     * @param grafo
     */
    public void setSoyUnaBomba(boolean soyUnaBomba,  Grafo grafo) {
        this.soyUnaBomba = soyUnaBomba;
        this.emoji = soyUnaBomba ? "💣" : String.valueOf(this.cantidadMinasAdy(grafo));
    }

    /**
     * Retorna si un vertice es bomba o no
     *
     * @return true si es bomba, false si no
     */
    public boolean isSoyUnaBomba() {
        return soyUnaBomba;
    }

    /**
     * Asigna un número de vértice a un objeto.
     *
     * @param n
     */
    public void asigVert(int n) {
        numeroVertice = n;
    }

    /**
     * Retorna el nombre del vertice
     *
     * @return
     */
    public String nombreVertice() {
        return nombre;
    }

    /**
     * Compara si 2 vertice son iguales
     *
     * @param d
     * @return
     */
    public boolean equals(Object d) {
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }
    
    
    /** 
     * Funcionalidad para contar las minas alrededor de la casilla que se oprimió
     * @param grafo
     * @return cantidad de minas alrededor de casilla
     */
    public int cantidadMinasAdy(Grafo grafo) {
        int count = 0;
        Nodo<Arista> aux = this.lad.getpFirst();
        while (aux != null) {
            if (grafo.getVectorDeAdyacencia()[aux.getData().getDestino()].soyUnaBomba) {
                count++;
            }
            aux = aux.getpNext();
        }
        return count;       
    }

    public Iterable<String> getVecinos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   /**
 * Busca un vértice en la lista enlazada por su número de destino.
 *
 * @param destino El número del vértice a buscar.
 * @param grafo El grafo al que pertenece el vértice.
 * @return El vértice encontrado o null si no existe.
 */
public Vertice getVertice(int destino, Grafo grafo) {
    Nodo<Object> aux = this.lad.getpFirst(); // Recorremos la lista enlazada de adyacencia
    while (aux != null) {
        Arista arista = (Arista) aux.getData(); // Convertimos el nodo a Arista
        int numeroDestino = arista.getDestino(); // Obtenemos el número de destino
        if (numeroDestino == destino) {
            return grafo.getVectorDeAdyacencia()[numeroDestino]; // Devuelve el vértice desde el vector de adyacencia
        }
        aux = aux.getpNext(); // Pasamos al siguiente nodo
    }
    return null; // Si no se encuentra el vértice, devolvemos null
}

    
}
