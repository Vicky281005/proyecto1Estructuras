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
    private static int maxVertices;
    private Vertice [] vectorDeAdyacencia;
    /**
     * constructor
     */
    public Grafo(){
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
        // DEVUELVE  EL VERTICE V, LUEGO BORRAR COMENTARIO
    /**
     * 
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
    
    /**
     * BUSCA Y DEVULEVE EL NUMERO DE VERTICE, SI NO LO ENCUENTRA DEVUELVE -1
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
     return (i<this.numVertices) ? i : -1;  //ESTO ES UN IF, SINO
     }
     
     // CREAR UN NUEVO VERTICE 
     public void nuevoVertice(String nombre){
         int indice = numVertice(nombre); // es -1 si no se encuentra el indice
         boolean existe = indice >= 0 ||  numVertices>=10;
         if (!existe){
                Vertice v = new Vertice(nombre);
                v.asigVert(numVertices);
                this.vectorDeAdyacencia[this.numVertices] = v; // coloca de primero  vertice nuevo 
                this.numVertices++; // le suma 1 a la cantidad de vertices
            } else {
             System.out.println("No existe o index out of range");
         }
     }
     
     // Comprueba si dos vertices son adyacentes
     
     boolean adyacente(String a, String b) throws Exception{
         int v1, v2;
         v1= numVertice(a);
         v2= numVertice(b);
         if(v1<0 || v2<0){
             throw new Exception ("El vertice no existe");
         }
        return this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2)); //PARA QUE FUNCIONE EL CONTAINS SE CREO "FUNION EN CLASE LISTA"
     }
     
     //  COMPRUEBA SI DOS VERTICES SON ADYACENTES POR EL NUMERO DE VERTICE
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
