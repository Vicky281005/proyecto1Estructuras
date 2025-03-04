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
    private NodoCola frente, finalCola;
    
    private class NodoCola{
        NodoArbol valor;
        NodoCola siguiente;
        
        NodoCola(NodoArbol valor){
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

