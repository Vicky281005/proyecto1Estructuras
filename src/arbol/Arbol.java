
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class Arbol {
      NodoArbol raiz;
      
      public Arbol(){
          this.raiz= null;
      }
      
      public Arbol(NodoArbol nodo){// Constuctor de la clase Arbol
          this.raiz= nodo;
      }

// Getters y setters de la variables raiz
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {

        this.raiz = raiz;
    }
      
    /**
     * 
     * @param raiz
     * @param newNodo 
     */
    
      public void insertar(NodoArbol raiz, NodoArbol newNodo){
          if(this.raiz==null){
              this.raiz= newNodo;
          }else{
              if(newNodo.getData() < raiz.getData()){
                  if (raiz.getIzquierdo()== null){
                      raiz.setIzquierdo(newNodo);
                  }else{
                      insertar(raiz.getIzquierdo(), newNodo);
                  }
              }else if (newNodo.getData() > raiz.getData()){
                  if (raiz.getDerecho()== null){
                      raiz.setDerecho(newNodo);
                  }else{
                      insertar(raiz.getDerecho(), newNodo); ////
                  }
              
              }else{
                  System.out.println("EL ELEMENTO YA ESTA EN EL ARBOL");
              }
          }
      }
      /**
       * 
       * @param aux
       * @param data
       * @param nivel
       * @return 
       */
      
      public int getNodoNivel(NodoArbol aux, int data, int nivel){
          if(aux== null) return -1;
          
          if(aux.getData()== data){
              return nivel;
          }else if(data < aux.getData()){
              return getNodoNivel(aux.getIzquierdo(), data, nivel+1);
          } else{
              return getNodoNivel(aux.getDerecho(), data, nivel+1);
          }
      }
      
      /**
       * Se verifica si data se encuentra en el arbol binario
       * @param aux recorre el árbol y verifica si el valor data está presente en alguno de los nodos.
       * @param data verifica si el valor entero esta en el arbol
       * @return 
       */
      public boolean estaEnArbol(NodoArbol aux, int data){
          if(aux==null) return false;
          
          if (aux.getData() == data)
              return true;
          else 
              return(estaEnArbol(aux.getIzquierdo(), data) || estaEnArbol(aux.getDerecho(), data));

      }
      
            /**
       * Realiza una búsqueda en amplitud en el árbol binario,
       * comenzando desde la raíz y recorriendo los nodos nivel por nivel.
       * @param dataBuscado El valor del dato que se desea buscar en el árbol.
       * @return El dato del nodo encontrado si existe un nodo con el valor especificado, o null si el valor no está en el árbol.
       */
      public Object busquedaEnAmplitud(int dataBuscado) {
            if (raiz == null) { 
                return null; 
            }
            Cola cola = new Cola();
            cola.encolar(raiz); 
            while (!cola.estaVacia()) {
                NodoArbol nodoActual = cola.desencolar(); 
                if (nodoActual.getData() == dataBuscado) {
                    return nodoActual.getData(); 
                }
                if (nodoActual.getIzquierdo() != null) {
                    cola.encolar(nodoActual.getIzquierdo());
                }
                if (nodoActual.getDerecho() != null) {
                    cola.encolar(nodoActual.getDerecho());
                }
            }
            return null; 
            }
      
            /**
       * Realiza una búsqueda en profundidad en el árbol binario  para encontrar un nodo con un valor específico.
       * @param nodo El nodo actual desde donde comienza la búsqueda.
       * @param dataBuscado El valor del dato que se desea buscar.
       * @return El dato del nodo si se encuentra, o null si no está.
       */
        public Object buscarProfundidad(NodoArbol nodo, int dataBuscado) {
            if (nodo == null) {
                return null;
            }
            if (nodo.getData() == dataBuscado) {
                return nodo.getData(); 
            }
            Object resultadoIzquierda = buscarProfundidad(nodo.getIzquierdo(), dataBuscado);
            if (resultadoIzquierda != null) {
                return resultadoIzquierda; 
            }
            return buscarProfundidad(nodo.getDerecho(), dataBuscado);
        }
     
        
        
}


