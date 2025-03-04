
package grafo;


public class Arista {
//Atributos de la clase Arista
         int destino; // indice del vector al que apunta la arista
         
        
        public Arista(int d){
//Constructor de la clase arista
            destino= d;
        }
        /**
         * 
         * @return 
         */
        public int getDestino(){
            return destino;
        }
        
        public boolean equeals(Object n){
             // Convierte el objeto proporcionado a tipo Arista
            Arista a = (Arista)n;
             // Comparar el atributo "destino" de la instancia actual con el de la arista proporcionada
            return destino== a.destino;
        }
}
