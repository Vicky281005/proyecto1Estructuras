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
<<<<<<< HEAD

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
=======
    private boolean marcado; //agregué booleano marcado (mishel)
    private boolean barrido; //agregué booleano barrido (mishel)
    private ListaEnlazada<Object> lad;
    

        public Vertice(String nom){ // Es el constructor, se encarga de crear un nuevo vertice y nom es el nombre del vertice
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = false;
            this.marcado = false; //agregué la inicializada de marcado (mishel)
            this.barrido = false; //agregué la inicializada de barrido (mishel)
            this.emoji = "";
>>>>>>> b5b7c3eb89bdb415e1b9761081641d0dcda0fc62
        }
      return count;
    }
        
        public Vertice(String nom, boolean soyUnaBomba){ //  Constructor, Se encarga de crear un nuevo vertice y recibe si es bomba o no, nom nombre del vertice y soyUnaBomba booleano true si es bomba, false si no es bomba
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = soyUnaBomba;
            this.marcado = false; 
            this.barrido = false;
            this.emoji = soyUnaBomba ? "💣" : "";
        }
<<<<<<< HEAD
       
=======
        
        /**
         * Obtiene el emoji de si es bomba o no
         * @return emoji de bomba o vacio
         */
        public String getEmoji() { 
            return emoji;
        }
        
        /**
         * Modifica si un vertice es bomba o no
         * @param soyUnaBomba booleano true si es bomba, false si no
         */
        public void setSoyUnaBomba(boolean soyUnaBomba) { 
            this.soyUnaBomba = soyUnaBomba;
            this.emoji = soyUnaBomba ? "💣" : "";
        }
        
         /**
         * Retorna si un vertice es bomba o no
         * @return true si es bomba, false si no
         */
        public boolean isSoyUnaBomba() { 
            return soyUnaBomba;
        }
        /**
         * Asigna un número de vértice a un objeto.
         * @param n 
         */
        public void asigVert(int n){ 
            numeroVertice= n;
        }
        
        /**
         * Retorna el nombre del vertice
         * @return 
         */
        public String nombreVertice(){ 
            return nombre;
        }
        /**
         * Compara si 2 vertice son iguales
         * @param d
         * @return 
         */
        public boolean equals(Object d){ 
            Vertice dos= (Vertice) d;
            return nombre.equals(dos.nombre);
        }

/**
 * Getters y Setters de booloeanos que agregue: barrido y marcado
 * Estos booleanos son necesarios para que cuando se guarde el CSV se sepa si la casilla esta marcada o no
 * y para poder saber si ponerlo de un color distinto o no 
 * igual con barrido, se necesita saber si esta barrido o no para saber si se muestra o no la información de la casilla
 * @return 
 */
    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public boolean isBarrido() {
        return barrido;
    }

    public void setBarrido(boolean barrido) {
        this.barrido = barrido;
    }

    public ListaEnlazada<Object> getLad() {
        return lad;
    }

    public void setLad(ListaEnlazada<Object> lad) {
        this.lad = lad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroVertice() {
        return numeroVertice;
    }

    public void setNumeroVertice(int numeroVertice) {
        this.numeroVertice = numeroVertice;
    }
      
    
        
>>>>>>> b5b7c3eb89bdb415e1b9761081641d0dcda0fc62
}
