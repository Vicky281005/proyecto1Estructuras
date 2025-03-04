
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

    public Grafo(int maxV){ //maxV es la maxima cantidad de vertices en el grafo
        vectorDeAdyacencia= new Vertice[maxV];
        numVertices= 0;
        maxVertices= maxV;
    }
        

    public Vertice DevuelveVertice(int v) throws Exception { //Devuelve el vertice v, el cual es el indice del vertice a buscar y throws es una exepcion cuando indez esta fuera de rango.
         if (v<0 || v>= numVertices){
             throw new Exception("Vertice fuera de rango" );  
         }
         return vectorDeAdyacencia[v];
     }
    
    public Vertice DevuelveVerticePorNombre(String nombre) throws Exception { //Devuelve un vértice basado en su nombre.
        int indice = this.numVertice(nombre);
        return DevuelveVertice(indice);
    }
    
    public int numVertice(String nombre){ //Busca y devuelve el nuemero de vertice, si no lo encuentra devuelve '1 y se le pasa de parametro nombre
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
     
   
     public void nuevoVertice(String nombre){ //Crea un nuevo vertice y el parametro nombre es como se va a llamar
         int indice = numVertice(nombre); 
         boolean existe = indice >= 0 ||  numVertices>=this.maxVertices;
         if (!existe){
                Vertice v = new Vertice(nombre);
                v.asigVert(numVertices);
                this.vectorDeAdyacencia[this.numVertices] = v; 
                this.numVertices++; 
            } else {
             System.out.println("Existe o index out of range");
         }
     }
     
     public void nuevoVerticesRecibiendoArrayDeVertices(String[] arrayVertices){ //Agrega múltiples vértices a un grafo el recibe un array de nombres de vértices.
         int tamanioArray = arrayVertices.length;
         
         for (int i = 0; i < tamanioArray; i++) {
             this.nuevoVertice(arrayVertices[i]);
         }
     } 
     
     public void fijarMinasAleatoriamente(int numMinas){ //Método para colocar minas aleatoriamente en un conjunto de vértices.
         
         int minasColocadas = 0;

        while (minasColocadas < numMinas) {
            int indiceAleatorio = (int) (Math.random() * this.maxVertices);
            if (!vectorDeAdyacencia[indiceAleatorio].isSoyUnaBomba()) {
                vectorDeAdyacencia[indiceAleatorio].setSoyUnaBomba(true);
                minasColocadas++;

            }
        }
            
     }
     
     boolean adyacente(String a, String b) throws Exception{ //Comprueba si 2 vertices son adyacentes, si los 2 parametros son true son adyacentes, si no false

         int v1, v2;
         v1= numVertice(a);
         v2= numVertice(b);
         if(v1<0 || v2<0){
             throw new Exception ("El vertice no existe");
         }
        return this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2)); 
     }
     
   
     boolean adyacentePorNumero(int v1, int v2) throws Exception{ 
        // Comprueba si 2 vertices son adyacentes por el numero de vertice.
        // Los parametros v1 y v2, son el primer y segundo vertice respectivamente, lo cual retornaran true si son adyacentes, false si no
        if (this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2))){
                return true; 
            }else{
                return false;
            }
     }
     
     
     public void nuevaArista(String a, String b) throws Exception{ //Crea una nueva arista
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
     
     
     public void borrarArista(String a, String b) throws Exception { //Borra una arista creada
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
