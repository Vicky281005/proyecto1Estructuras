/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1estructuras;

/**
 *
 * @author NITRO V 15
 */
public class Grafo {
    private int numVertices;
    private static int maxVertices= 10;
    private Vertice [] vectorDeAdyacencia;
    
    public Grafo(int maxV){
        vectorDeAdyacencia= new Vertice[maxV];
        numVertices= 0;
        maxVertices= maxV;
    }
    
    // DEVULVE LA LISTA DE ADYACENCIA DEL VERTICE V, LUEGO BORRAR COMENTARIO
     public ListaEnlazada ListadeAdyacencia(int v) throws Exception {
         if (v<0 || v>= numVertices){
             throw new Exception("Vertice fuera de rango" );  
         }
         return vectorDeAdyacencia[v].lad;
     }
    
}
