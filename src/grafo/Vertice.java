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
    private boolean soyUnaBomba;
    private String emoji;
     ListaEnlazada<Object> lad;
    
        public Vertice(String nom){
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = false;
            this.emoji = "";
        }
        
        public Vertice(String nom, boolean soyUnaBomba){
            nombre= nom;
            numeroVertice= -1;
            lad = new ListaEnlazada();
            this.soyUnaBomba = soyUnaBomba;
            this.emoji = soyUnaBomba ? "💣" : "";
        }

        public String getEmoji() {
            return emoji;
        }

        public void setSoyUnaBomba(boolean soyUnaBomba) {
            this.soyUnaBomba = soyUnaBomba;
            this.emoji = soyUnaBomba ? "💣" : "";
        }

        public boolean isSoyUnaBomba() {
            return soyUnaBomba;
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
