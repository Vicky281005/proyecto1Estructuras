
package proyecto1estructuras;

import grafo.Grafo;
import grafo.ListaEnlazada;
import grafo.Nodo;
import interfaces.BuscaminasInterfaz;

/**
 *
 * @author NITRO V 15
 */
public class Proyecto1Estructuras {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
//            Grafo grafo = new Grafo(9);
//            
//            grafo.nuevoVertice("v1");
//            grafo.nuevoVertice("v2");
//            grafo.nuevoVertice("v3");
            
            
            
            
            
            
        Grafo grafo = new Grafo(5*5); //crea un nuevo objeto de la clase grafo basado en la variables globales de la clase BuscaminasInterfaz
        String[] filasCoordenadas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //Define la coordenadas de las filas en coordenadas de A a la J
        String[] arregloVectores = new String[5*5]; //Crea un arreglo de vectores para almacenar las coordenadas de los vertices
        int[] columnasCoordenadas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //Define las coordenas de las columnas del 1 al 10 

        int contador= 0; 

//Bucle For que genera las coordenadas de las casillas combinando filas y columnas
        for (int i = 0; i < 5; i++){ 
            String coordFila = filasCoordenadas[i]; //Obtiene la letra de la fila actual
            for (int j = 0; j < 5; j++){
                String coordColumna = String.valueOf(columnasCoordenadas[j]); // Obtiene el número de la columna actual
                String concatenacion = coordFila + coordColumna; // Combina la final y las columnas
                arregloVectores[contador] = concatenacion;//Almacena la posición la posicion en el arreglo
                contador++;//Incrementa el contador para la siguiente posición del arreglo
                
                
            }
        }
        

// Crear los vértices en el grafo utilizando el arreglo de coordenadas
        grafo.nuevoVerticesRecibiendoArrayDeVertices(arregloVectores);
//        grafo.crearAristasAutomaticamente(5, 5);
// Colocar minas aleatoriamente en el grafo, según el número de minas especificado
        grafo.fijarMinasAleatoriamente(2);

            
            
//            grafo.borrarArista("v1", "v2");
//        grafo.imprimirGrafo();
    ListaEnlazada lista = grafo.DFS(arregloVectores[1]);
    Nodo aux = lista.getpFirst();
    while(aux != null){
        System.out.println(aux.getData().toString());
        aux = aux.getpNext();
    }
            

            
        BuscaminasInterfaz busca = new BuscaminasInterfaz();
        busca.setVisible(true);
        busca.setLocationRelativeTo(null);
            
    }
   
}
