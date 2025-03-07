
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class NodoArbol {
// Atributos de la clase NodoArbol
    private int data;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    
    /**
    * Constructor que inicializa un nodo del árbol con el valor de datos especificado.
    * @param data el valor de datos del nodo
    */
    public NodoArbol(int data){
        this.data=data;
        this.derecho = derecho;
        this.izquierdo= izquierdo;
    }
    /**
     * Obtiene el valor de datos del nodo.
     * @return el valor de datos del nodo
     */
    public int getData(){
        return data;
    }
    
    /**
    * Establece el valor de datos del nodo.
    * @param data el nuevo valor de datos del nodo
    */
    public void setData(int data){
        this.data= data;
    }

    /**
    * Obtiene el nodo izquierdo del árbol.
    * @return el nodo izquierdo del árbol
    */
    public NodoArbol getIzquierdo() {
        return izquierdo;
    }
    /**
     * Obtiene el nodo derecho del árbol.
     * @return el nodo derecho del árbol
     */
    public NodoArbol getDerecho() {
        return derecho;
    }

    /**
    * Establece el nodo izquierdo del árbol.
    * @param izquierdo el nuevo nodo izquierdo del árbol
    */
    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
    * Establece el nodo derecho del árbol.
    * @param derecho el nuevo nodo derecho del árbol
    */
    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
    
    /**
     * Se encarga de verificar si un nodo es hoja o no
     * @return True si es hoja, False si no lo es
     */
    public boolean esHoja(){
        return (this.izquierdo== null && this.derecho==null);
    }
    
    
}
