package arbol;

import grafo.Nodo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Cola<T> {
    // Atributos de la clase Cola
    private Nodo<T> frente, finalCola;

    public Cola() {
        frente = finalCola = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Añade nuevos elementos a la cola
     * @param valor 
     */
    public void encolar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (finalCola != null) {
            finalCola.setpNext(nuevo);
        }
        finalCola = nuevo;
        if (frente == null) {
            frente = finalCola;
        }
    }

    /**
     * Elimina los elementos de la cola
     * @return 
     */
    public Nodo<T> desencolar() {
        if (frente == null) {
            return null; // la cola está vacía :)
        }
        Nodo<T> valor = frente;
        frente = frente.getpNext();
        if (frente == null) {
            finalCola = null;
        }
        return valor;
    }
}

//package arbol;
//
//import grafo.Nodo;
//
///**
// *
// * @author NITRO V 15
// */
//public class Cola {
//// Atributos de la clase Cola
//    private Nodo frente, finalCola;
//    
//    private class NodoCola{
//        NodoArbol valor;
//        NodoCola siguiente;
//        
//        NodoCola(NodoArbol valor){
////Constructor de la clase cola
//            this.valor= valor; 
//            this.siguiente= null;
//        
//        }
//    }
//    
//    public Cola(){
//        frente= finalCola=null;
//    }
//    
//    public boolean estaVacia(){
//        return frente==null;
//    }
//    /**
//     * Añade nuevos elementos a la cola
//     * @param valor 
//     */
//    public void encolar(Nodo valor){
//        Nodo nuevo= new Nodo(valor);
//        if (finalCola != null){
//            finalCola.setpNext(nuevo);
//        }
//        finalCola=nuevo;
//        if(frente== null){
//            frente= finalCola;
//        }
//    }
//    /**
//     * Elimina los elementos de la cola
//     * @return 
//     */
//    public Nodo desencolar(){
//        if (frente== null){
//            return null; // la cola esta vacia :)
//        }
//        Nodo valor = frente;
//        frente= frente.getpNext();
//        if(frente==null){
//            finalCola=null;
//        }
//        return valor;
//    }
//    
//}

