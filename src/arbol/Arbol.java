/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class Arbol {
      NodoArbol raiz;
      
      
    public Arbol(){
        raiz = null;
    }
    
    public void insertar (int indice, Object dato){
          NodoArbol n = new NodoArbol(indice);
            n.data = dato;
        
        if (raiz== null){
            raiz= n;
        }else{
            NodoArbol nodoAux = raiz;
            while (nodoAux!= null){
                n.padre = nodoAux;
                if(n.llave >= nodoAux.llave){
                    nodoAux= nodoAux.derecha;
                }else{
                    nodoAux= nodoAux.izquierda;
                }
            }
            if (n.llave < n.padre.llave){
                n.padre.izquierda = n;
            }else{
                n.padre.derecha= n;
            }
        }
    }
    
        public void recorrer(NodoArbol n){
            if(n!= null){
                recorrer(n.izquierda);
                recorrer(n.derecha);
            }
    
    }
    
        private class NodoArbol{
            private NodoArbol padre;
            private NodoArbol derecha;
            private NodoArbol izquierda;
            public int llave;
            public Object data;
            
            public NodoArbol(int indice){
                llave = indice;
                derecha= null;
                izquierda = null;
                padre = null;
                data = null;
            }
        
        }
        
}
