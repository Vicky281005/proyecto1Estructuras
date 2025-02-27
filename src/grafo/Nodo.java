/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafo;

/**
 *
 * @author NITRO V 15
 * @param <T>
 */
public class Nodo<T> {
    private T data;
    private Nodo pNext;

    public Nodo(T data) {
        this.data = data;
        this.pNext = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public T getData() {
        return data;
    }

    public Nodo getpNext() {
        return pNext;
    }
    
}
