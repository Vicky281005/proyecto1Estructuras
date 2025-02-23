/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1estructuras;

/**
 *
 * @author NITRO V 15
 */
public class Arista {
         int destino;
         
        
        public Arista(int d){
            destino= d;
        }
        
        public int getDestino(){
            return destino;
        }
        
        public boolean equeals(Object n){
            Arista a = (Arista)n;
            return destino== a.destino;
        }
}
