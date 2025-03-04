
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
     ListaEnlazada<Object> lad;
    
     
        /**
         * Constructor 
         * Se encarga de crear un nuevo vertice
         * @param nom nombre del vertice
         */
        public Vertice(String nom){
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = false;
            this.emoji = "";
        }
        
        /**
         * Constructor
         * Se encarga de crear un nuevo vertice y recibe si es bomba o no
         * @param nom nombre del vertice
         * @param soyUnaBomba booleano true si es bomba, false si no es bomba
         */
        public Vertice(String nom, boolean soyUnaBomba){
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
        
        public void asigVert(int n){
            numeroVertice= n;
        }
        
        
        public String nombreVertice(){
            return nombre;
        }
        
        public boolean equals(Object d){
            Vertice dos= (Vertice) d;
            return nombre.equals(dos.nombre);
        }
}
