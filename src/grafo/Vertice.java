
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
    private boolean marcado; //agregué booleano marcado (mishel)
    private boolean barrido; //agregué booleano barrido (mishel)
    public ListaEnlazada<Object> lad;
    

        public Vertice(String nom){ // Es el constructor, se encarga de crear un nuevo vertice y nom es el nombre del vertice
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = false;
            this.marcado = false; //agregué la inicializada de marcado (mishel)
            this.barrido = false; //agregué la inicializada de barrido (mishel)
            this.emoji = "";
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
        
        
}
