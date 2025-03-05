
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
    
    public NodoArbol(int data){
// Constructor de la clase Arbol
        this.data=data;
        this.derecho = derecho;
        this.izquierdo= izquierdo;
    }
//    Getters y setters de los atributos de la clase NodoArbol
    public int getData(){
        return data;
    }
    
    public void setData(int data){
        this.data= data;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

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
