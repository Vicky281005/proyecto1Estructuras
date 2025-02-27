/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Vertice {
    private String nombre;
    private int numeroVertice;
     ListaEnlazada<Object> lad;
    
        public Vertice(String nom){
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
        }
        
        public void asigVert(int n){
            numeroVertice= n;
        }
        
        public String nombreVertice(){
            return nombre;
        }
        
        public boolean equals(Object d){
            Vertice dos= (Vertice) d;
            return nombre.equals(dos.nombre);
        }
}
