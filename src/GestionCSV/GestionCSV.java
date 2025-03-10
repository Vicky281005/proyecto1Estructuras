/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionCSV;

import grafo.Grafo;
import grafo.Vertice;

/**
 *
 * @author mishel
 */
public class GestionCSV {
    
    
/**
 * Función para guardar el juego
 * Guarda el estado de cada casilla: el nombre y el número de vertice, si tiene o no una mina, si está o no marcada y barrida, y si tiene o no un emoji
 * @param grafo
 * @return 
 */    
    public String guardarCSV(Grafo grafo) {
        String expresion = "Nombre,Numero Vertice,Mina,Barrido,Marcado,Emoji\n";
        for (int i = 0; i < grafo.getVectorDeAdyacencia().length; i++) { //recorre el grafo a traves del vector de adyacencia
            if (grafo.getVectorDeAdyacencia()[i] != null) {
                Vertice verticeActual = grafo.getVectorDeAdyacencia()[i]; // por cada recorrido se guarda el vertice
                String nombre = verticeActual.nombreVertice(); //guarda el nombre
                String numeroVertice = String.valueOf(verticeActual.getNumeroVertice()); // guarda el número de vértice
                String isMina = verticeActual.isSoyUnaBomba() ? "1" : "0"; // guarda con un operador ternal si la casilla era mina (1) o si no era mina (0)
                String estaBarrido = verticeActual.isBarrido() ? "1" : "0"; // guarda con un operador ternal si la casilla está barrida (1) o si no está barrida (0)
                String estaMarcado = verticeActual.isMarcado() ? "1" : "0"; // guarda con un operador ternal si la casilla está marcada (1) o si no está marcada (0)
                String emoji = verticeActual.getEmoji(); // guarda si la casilla tiene o no un emoji

                expresion += nombre + "," + numeroVertice + "," + isMina + "," + estaBarrido + "," + estaMarcado + "," + emoji + "\n"; // expresion que se va a guardar
            }    
        }
        
        return expresion;
        
    }
    
    /**
     * Función para cargar el juego
     * @param contenidoCSV
     * @return 
     */
    
    public Grafo cargarCSV(String contenidoCSV) {
        return null;  
    }
}
