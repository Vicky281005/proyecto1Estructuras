
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
     ListaEnlazada<Object> lad;
    

        public Vertice(String nom){ // Es el constructor, se encarga de crear un nuevo vertice y nom es el nombre del vertice
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = false;
            this.emoji = "";
        }
        
        public Vertice(String nom, boolean soyUnaBomba){ //  Constructor, Se encarga de crear un nuevo vertice y recibe si es bomba o no, nom nombre del vertice y soyUnaBomba booleano true si es bomba, false si no es bomba
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = soyUnaBomba;
            this.emoji = soyUnaBomba ? "💣" : "";
        }
        
        /**
         * Obtiene el emoji de si es bomba o no
         * @return emoji de bomba o vacio
         */
        public String getEmoji() { // Obtiene el emoji de si es bomba o no y retorna emoji de bomba o vacio
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
}
