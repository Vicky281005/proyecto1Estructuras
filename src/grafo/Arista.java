
package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Arista { //indice del vector al que apunta la arista
         int destino; 
         
         
        /**
        * Constructor que inicializa una arista con el destino especificado.
        * @param d el destino de la arista
        */
       public Arista(int d) { 
          destino = d; 
}

        /**
        * Obtiene el valor del destino de la arista.
        * @return el valor del destino de la arista
        */
        public int getDestino() {
            return destino; 
        }

        /**
        * Compara esta arista con el objeto especificado para verificar la igualdad.
        * 
        * @param n el objeto con el que se va a comparar esta arista
        * @return true si el destino de ambas aristas es el mismo, false en caso contrario
        */
        public boolean equeals(Object n) { 
            Arista a = (Arista) n; 
            return destino == a.destino; 
}
}
