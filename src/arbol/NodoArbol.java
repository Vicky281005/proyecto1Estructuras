/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author NITRO V 15
 */
public class NodoArbol {
    private int data;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(int data){
        this.data=data;
        this.derecho = derecho;
        this.izquierdo= izquierdo;
    }
    
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
