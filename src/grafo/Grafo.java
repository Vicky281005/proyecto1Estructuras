
package grafo;

import java.util.Arrays; 
//Importa la libreria java.util.Arrays

/**
 *
 * @author NITRO V 15
 */
public class Grafo {
//    Atributos de la clase Grafo
    private int numVertices;
    private int maxVertices;
    private Vertice [] vectorDeAdyacencia;
    /**
     * constructor
     */
    public Grafo(){
//        Constructor de la clase grafo
        vectorDeAdyacencia= new Vertice[10];
        numVertices= 0;
        maxVertices= 10;
    }
    /**
     * constructor
     * @param maxV maxima cantidad de vertices en el grafo 
     */
    public Grafo(int maxV){
        vectorDeAdyacencia= new Vertice[maxV];
        numVertices= 0;
        maxVertices= maxV;
    }
        
    /**
     * Devuelve el vertice v
     * @param v es el indice del vertice a buscar
     * @return el vertice a buscar
     * @throws Exception cuando es index out of range
     */ 
    public Vertice DevuelveVertice(int v) throws Exception {
         if (v<0 || v>= numVertices){
             throw new Exception("Vertice fuera de rango" );  
         }
         return vectorDeAdyacencia[v];
     }
    
    public Vertice DevuelveVerticePorNombre(String nombre) throws Exception {
        int indice = this.numVertice(nombre);
        return DevuelveVertice(indice);
    }
    
    /**
     * Busca y devuelve el  numero de vertice, si no lo encuentra devuelve '1
     * @param nombre
     * @return 
     */ 
    public int numVertice(String nombre){
     Vertice v = new Vertice(nombre);
     boolean encontrado= false;
     int i = 0;
     for (; (i< numVertices)&& !encontrado;){
         encontrado = this.vectorDeAdyacencia[i].equals(v);
         if(!encontrado){
             i++;
         }
     }
     return (i<this.numVertices) ? i : -1;  
     }
     
   
    /**
     * Crea un nuevo vertice
     * @param nombre recibe el nombre de como se llamara el vertice
     */
     public void nuevoVertice(String nombre){
         int indice = numVertice(nombre); // es -1 si no se encuentra el indice
         boolean existe = indice >= 0 ||  numVertices>=this.maxVertices;
         if (!existe){
                Vertice v = new Vertice(nombre);
                v.asigVert(numVertices);
                this.vectorDeAdyacencia[this.numVertices] = v; // coloca de primero  vertice nuevo 
                this.numVertices++; // le suma 1 a la cantidad de vertices
            } else {
             System.out.println("Existe o index out of range");
         }
     }
     
     public void nuevoVerticesRecibiendoArrayDeVertices(String[] arrayVertices){
         int tamanioArray = arrayVertices.length;
         
         for (int i = 0; i < tamanioArray; i++) {
             this.nuevoVertice(arrayVertices[i]);
         }
     } 
     
     public void fijarMinasAleatoriamente(int numMinas){
         
         int minasColocadas = 0;

        // Mientras queden minas por colocar
        while (minasColocadas < numMinas) {
            // Generar índice aleatorio para una casilla
            int indiceAleatorio = (int) (Math.random() * this.maxVertices);

            // Si la casilla no es una bomba, colocar una bomba
            if (!vectorDeAdyacencia[indiceAleatorio].isSoyUnaBomba()) {
                vectorDeAdyacencia[indiceAleatorio].setSoyUnaBomba(true);
                minasColocadas++;

            }
        }
            
     }
     
     
     /**
      *  Comprueba si dos vertices son adyacentes
      * @param a nombre del primer vertice
      * @param b nombre del segundo vertice
      * @return true si son adyacentes, false si no lo son
      * @throws Exception cuando uno de los dos vertices no existe
      */
     boolean adyacente(String a, String b) throws Exception{
         int v1, v2;
         v1= numVertice(a);
         v2= numVertice(b);
         if(v1<0 || v2<0){
             throw new Exception ("El vertice no existe");
         }
        return this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2)); 
     }
     
   
     /**
      * Comprueba si dos vertices son adyacentes por el numero de vertice
      * @param v1 numero del primer vertice
      * @param v2 numero del segundo vertice
      * @return retornara true si son adyacentes, false si no lo son
      * @throws Exception 
      */
     boolean adyacentePorNumero(int v1, int v2) throws Exception{
            if (this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2))){
                return true; 
            }else{
                return false;
            }
     }
     
     //CREA UNA NUEVA ARISTA
     public void nuevaArista(String a, String b) throws Exception{
         if (!adyacente(a, b)){
            
             int v1= numVertice(a);
             int v2= numVertice(b);
             System.out.println("todo bien");
             if (v1 < 0 || v2 < 0){
                 throw new Exception ("El veertice no existe");
             }
             Arista ab = new Arista(v2);
             this.vectorDeAdyacencia[v1].lad.addFirst(ab);
         }else{
             System.out.println("ya existe");
         }
     }
     
     //BORRAR UNA ARISRA YA CREADA
     public void borrarArista(String a, String b) throws Exception {
         int v1= numVertice(a);
         int v2= numVertice(b);
         if (v1 < 0 || v2< 0){
             throw new Exception ("El vertice no existe");
         }
         Arista ab = new Arista(v2);
         Arista arista = this.vectorDeAdyacencia[v1].lad.removeArista(ab);
         System.out.print("eliminado:");
         if (arista != null) {
             System.out.print(arista.destino);
         }else{
             System.out.println("null");
         }
     }
     
     
}
