/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1estructuras;

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
            Grafo grafo = new Grafo(9);
            
            grafo.nuevoVertice("v1");
            grafo.nuevoVertice("v2");
            grafo.nuevoVertice("v3");
            
            grafo.nuevaArista("v1", "v2");
            grafo.nuevaArista("v1", "v3");
            
            grafo.borrarArista("v1", "v2");
            
    }
    
}
