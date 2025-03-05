/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class Cola {
//    Atributos de la clase Cola
    private NodoCola frente, finalCola;
    
    private class NodoCola{
        NodoArbol valor;
        NodoCola siguiente;
        
        NodoCola(NodoArbol valor){
//Constructor de la clase cola
            this.valor= valor; 
            this.siguiente= null;
        
        }
    }
    
    public Cola(){
        frente= finalCola=null;
    }
    
    public boolean estaVacia(){
        return frente==null;
    }
    /**
     * Añade nuevos elementos a la cola
     * @param valor 
     */
    public void encolar(NodoArbol valor){
        NodoCola nuevo= new NodoCola(valor);
        if (finalCola != null){
            finalCola.siguiente=nuevo;
        }
        finalCola=nuevo;
        if(frente== null){
            frente= finalCola;
        }
    }
    /**
     * Elimina los elementos de la cola
     * @return 
     */
    public NodoArbol desencolar(){
        if (frente== null){
            return null; // la cola esta vacia :)
        }
        NodoArbol valor=frente.valor;
        frente= frente.siguiente;
        if(frente==null){
            finalCola=null;
        }
        return valor;
    }
    
}

