
package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Arista { //indice del vector al que apunta la arista
         int destino; 
         
        
       public Arista(int d) { //Inicializa el atributo `destino` con el valor pasado como parámetro.
          destino = d; 
}

        
        public int getDestino() { //Método getter para obtener el valor del atributo `destino`.
            return destino; 
        }

        
        public boolean equeals(Object n) { //Método para comparar si dos objetos de tipo Arista son iguales.
            Arista a = (Arista) n; 
            return destino == a.destino; 
}

/**
 * Verifica que las conexiones/aristas que se generaron cuando se creó el grafo
 * @return 
 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Arista{");
        sb.append("destino=").append(destino);
        sb.append('}');
        return sb.toString();
    }
        
}
