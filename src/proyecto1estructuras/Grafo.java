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
    
    // DEVULVE  EL VERTICE V, LUEGO BORRAR COMENTARIO
     public Vertice DevuelveVertice(int v) throws Exception {
         if (v<0 || v>= numVertices){
             throw new Exception("Vertice fuera de rango" );  
         }
         return vectorDeAdyacencia[v];
     }
    
     // BUSCA Y DEVULEVE EL NUMERO DE VERTICE, SI NO LO ENCUENTRA DEVUELVE -1
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
         boolean existe = numVertice(nombre) >= 0;
            if (!existe){
                Vertice v = new Vertice(nombre);
                v.asigVert(numVertices);
                this.vectorDeAdyacencia[this.numVertices] = v; // coloca de primero  vertice nuevo 
                this.numVertices++; // le suma 1 a la cantidad de vertices
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
         if(this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2))){   //PARA QUE FUNCIONE EL CONTAINS SE CREO "FUNION EN CLASE LISTA"
             return true;
         } else {
             return false;
         }
     }
     
     //  COMPRUEBA SI DOS VERTICES SON ADYACENTES POR EL NUMERO DE VERTICE
     boolean adyacente(int v1, int v2) throws Exception{
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
             if (v1< 0 || v2<0){
                 throw new Exception ("El veertice no existe");
             }
             Arista ab = new Arista(v2);
             this.vectorDeAdyacencia[v1].lad.remove(ab);
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
         this.vectorDeAdyacencia[v1].lad.remove(ab);
     }
     
     
}
