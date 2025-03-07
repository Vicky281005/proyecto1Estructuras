package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Vertice {
//    Atributos de la clase vertice

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

    public String getEmoji() { // Obtiene el emoji de si es bomba o no y retorna emoji de bomba o vacio
        return emoji;
    }

    /**
     * Agregué los getters y setters que no se habían agregado Si no se agregan
     * las conexiones no voy a poder hacer funcionalidad de contar minas
     * alrededor
     *
     * @return agrega las conexiones
     */
    public ListaEnlazada<Object> getLad() {
        return lad;
    }

    public void setLad(ListaEnlazada<Object> lad) {
        this.lad = lad;
    }

    public void setSoyUnaBomba(boolean soyUnaBomba, Grafo grafo) { // Modifica si un vertice es bomba o no. soyUnaBomba booleano true si es bomba, false si no.
        this.soyUnaBomba = soyUnaBomba;
        this.emoji = soyUnaBomba ? "💣" : String.valueOf(this.cantidadMinasAdy(grafo)); 
    }

    public boolean isSoyUnaBomba() { // Retorna si un vertice es bomba o no, ademas true es bomba y false si no es
        return soyUnaBomba;
    }

    public void asigVert(int n) { // Asigna un número de vértice a un objeto.
        numeroVertice = n;
    }

    public String nombreVertice() { // Obtiene el nombre del vertice
        return nombre;
    }

    public boolean equals(Object d) { // Compara si 2 vertices son iguales
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }

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
}
