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
public class ListaEnlazada <T>{
       private Nodo pFirst;
       private Nodo pLast;
       private int size;
       
       public ListaEnlazada(){
           this.pFirst = this.pLast = null;
       }
       
       public ListaEnlazada(Nodo<T> n){
           this.pFirst=this.pLast= n;
       }

    public Nodo getpFirst() {
        return pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return this.pFirst== null;
    }
    
    public void addFirst(T dato) {
        Nodo<T> n = new Nodo(dato);
        if (isEmpty()) {
            this.pFirst = n;
            this.pLast = n;
            this.pFirst.setpNext(this.pLast);
            this.pLast.setpNext(null);
        } else {
            n.setpNext(this.pFirst);
            this.pFirst= n;
            }
        size++;
      }
    
    public boolean contains(Arista arista){
        Nodo aux = this.pFirst;
        
        boolean yaExiste = false;
        for (int i = 0; i < size; i++){
            
            Arista aux2 = (Arista) aux.getData();
            if (aux2.destino == arista.destino){
                yaExiste = true;
            }
            aux = aux.getpNext();
        }
        return yaExiste;
    }
    
    public Arista removeArista(Arista arista){
        
        if (this.isEmpty()){
            return null;
        } else if (((Arista) pFirst.getData()).destino == arista.destino){
            Arista aristaARetornar = (Arista) pFirst.getData();
            this.pFirst = pFirst.getpNext() != null ? this.pFirst.getpNext() : null;
            size--;
            return aristaARetornar;
        } else {
            Nodo prevaux = pFirst;
            Nodo aux = pFirst.getpNext();

            while (aux != null) {
                if (((Arista) aux.getData()).destino == arista.destino) {
                    prevaux.setpNext(aux.getpNext());
                    if (aux.getpNext() == null){
                        this.pLast = prevaux;
                    }
                    size--;
                    return (Arista) aux.getData();
                }
                prevaux = aux;
                aux = aux.getpNext();
            }
            return null;
        } 
    }

    
}


