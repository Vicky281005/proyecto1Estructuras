package grafo;

/**
 *
 * @author NITRO V 15
 */
public class Grafo {
//    Atributos de la clase Grafo

    private int numVertices;
    private int maxVertices;
    private Vertice[] vectorDeAdyacencia;

    /**
     * constructor
     */
    public Grafo() {
//        Constructor de la clase grafo
        vectorDeAdyacencia = new Vertice[10];
        numVertices = 0;
        maxVertices = 10;
    }

    /**
     * constructor
     *
     * @param maxV maxima cantidad de vertices en el grafo
     */
    public Grafo(int maxV) {
        vectorDeAdyacencia = new Vertice[maxV];
        numVertices = 0;
        maxVertices = maxV;
    }

    public Vertice[] getVectorDeAdyacencia() {
        return vectorDeAdyacencia;
    }
    
    
    
    /**
     * Devuelve el vertice v
     *
     * @param v es el indice del vertice a buscar
     * @return el vertice a buscar
     * @throws Exception cuando es index out of range
     */
//Esta bien hecho, pero la idea es que el programa no pare la ejecucion
    public Vertice DevuelveVertice(int v) throws Exception {
        if (v < 0 || v >= numVertices) {
            throw new Exception("Vertice fuera de rango");
        }
        return vectorDeAdyacencia[v];
    }
    
    public Vertice DevuelveVertice2(String a) throws Exception {
        int v = Integer.parseInt(a);
        return this.DevuelveVertice(v);
//        if (v < 0 || v >= numVertices) {
//            throw new Exception("Vertice fuera de rango");
//        }
//        return vectorDeAdyacencia[v];
    }


    /**
     * Devuelve un vértice basado en su nombre.
     *
     * @param nombre
     * @return
     * @throws Exception
     */
    public Vertice devuelveVerticePorNombre(String nombre) throws Exception {
        int indice = this.numVertice(nombre);
        return DevuelveVertice(indice);
    }

    /**
     * Busca y devuelve el numero de vertice, si no lo encuentra devuelve '1
     *
     * @param nombre
     * @return
     */
    public int numVertice(String nombre) {
        Vertice v = new Vertice(nombre);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVertices) && !encontrado;) {
            encontrado = this.vectorDeAdyacencia[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < this.numVertices) ? i : -1;
    }

    /**
     * Crea un nuevo vertice
     *
     * @param nombre recibe el nombre de como se llamara el vertice
     */
    public void nuevoVertice(String nombre) {
        int indice = numVertice(nombre);
        boolean existe = indice >= 0 || numVertices >= this.maxVertices;
        if (!existe) {
            Vertice v = new Vertice(nombre);
            v.asigVert(numVertices);
            this.vectorDeAdyacencia[this.numVertices] = v;
            this.numVertices++;
        } else {
            System.out.println("Existe o index out of range");
        }
    }

    /**
     * Agrega múltiples vértices a un grafo el recibe un array de nombres de
     * vértices.
     *
     * @param arrayVertices
     */
    public void nuevoVerticesRecibiendoArrayDeVertices(String[] arrayVertices) {
        int tamanioArray = arrayVertices.length;

        for (int i = 0; i < tamanioArray; i++) {
            this.nuevoVertice(arrayVertices[i]);
        }
    }
public void crearAristasAutomaticamente(int filas, int columnas) {
        // Verificar que el número de vértices coincide con el tamaño de la cuadrícula
        if (numVertices != filas * columnas) {
            System.out.println("El número de vértices no coincide con el tamaño de la cuadrícula.");
            return;
        }

        // Recorrer cada vértice en la cuadrícula
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                // Obtener el índice del vértice actual
                int indiceActual = fila * columnas + columna;

                // Conectar con el vecino de la derecha (si existe)
                if (columna < columnas - 1) {
                    int indiceDerecha = indiceActual + 1;
                    try {
                        nuevaArista(vectorDeAdyacencia[indiceActual].nombreVertice(), vectorDeAdyacencia[indiceDerecha].nombreVertice());
                    } catch (Exception e) {
                        System.out.println("Error al crear arista: " + e.getMessage());
                    }
                }
                
                if (0 < columnas - 1) {
                    int indieIzquierda = indiceActual - 1;
                    try {
                        nuevaArista(vectorDeAdyacencia[indiceActual].nombreVertice(), vectorDeAdyacencia[indieIzquierda].nombreVertice());
                    } catch (Exception e) {
                        System.out.println("Error al crear arista: " + e.getMessage());
                    }
                }

                // Conectar con el vecino de abajo (si existe)
                if (fila < filas - 1) {
                    int indiceAbajo = indiceActual + columnas;
                    try {
                        nuevaArista(vectorDeAdyacencia[indiceActual].nombreVertice(), vectorDeAdyacencia[indiceAbajo].nombreVertice());
                    } catch (Exception e) {
                        System.out.println("Error al crear arista: " + e.getMessage());
                    }
                }
                
                if (0 < filas - 1) {
                    int indiceArriba = indiceActual - columnas;
                    try {
                        nuevaArista(vectorDeAdyacencia[indiceActual].nombreVertice(), vectorDeAdyacencia[indiceArriba].nombreVertice());
                    } catch (Exception e) {
                        System.out.println("Error al crear arista: " + e.getMessage());
                    }
                }
            }
        }
    }
    /**
     * Coloca las minas aleatoriamente en el conjunto de vertices
     *
     * @param numMinas
     */
    public void fijarMinasAleatoriamente(int numMinas) {

        int minasColocadas = 0;

        while (minasColocadas < numMinas) {
            int indiceAleatorio = (int) (Math.random() * this.maxVertices);
            if (!vectorDeAdyacencia[indiceAleatorio].isSoyUnaBomba()) {
                vectorDeAdyacencia[indiceAleatorio].setSoyUnaBomba(true);
                minasColocadas++;
            }
        }

    }

    /**
     * Comprueba si dos vertices son adyacentes
     *
     * @param a nombre del primer vertice
     * @param b nombre del segundo vertice
     * @return true si son adyacentes, false si no lo son
     * @throws Exception cuando uno de los dos vertices no existe
     */
    public boolean adyacente(String a, String b) throws Exception {
        int v1, v2;
        v1 = numVertice(a);
        v2 = numVertice(b);
        if (v1 < 0 || v2 < 0) {
            throw new Exception("El vertice no existe");
        }
        return this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2));
    }

    /**
     * Comprueba si dos vertices son adyacentes por el numero de vertice
     *
     * @param v1 numero del primer vertice
     * @param v2 numero del segundo vertice
     * @return retornara true si son adyacentes, false si no lo son
     * @throws Exception
     */
    boolean adyacentePorNumero(int v1, int v2) throws Exception {
        if (this.vectorDeAdyacencia[v1].lad.contains(new Arista(v2))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Crea una nueva arista con los parametros a y b
     *
     * @param a es el primer vertice
     * @param b es el segundo vertice
     * @throws Exception
     */
    public void nuevaArista(String a, String b) throws Exception {
        if (!adyacente(a, b)) {

            int v1 = numVertice(a);
            int v2 = numVertice(b);
            System.out.println("todo bien");
            if (v1 < 0 || v2 < 0) {
                throw new Exception("El veertice no existe");
            }
            Arista ab = new Arista(v2);
            this.vectorDeAdyacencia[v1].lad.addFirst(ab);
        } else {
            System.out.println("ya existe");
        }
    }

    /**
     * Borra una arista creada
     *
     * @param a es el primer vertice
     * @param b es el segundo vertice
     * @throws Exception
     */
    public void borrarArista(String a, String b) throws Exception {
        int v1 = numVertice(a);
        int v2 = numVertice(b);
        if (v1 < 0 || v2 < 0) {
            throw new Exception("El vertice no existe");
        }
        Arista ab = new Arista(v2);
        Arista arista = this.vectorDeAdyacencia[v1].lad.removeArista(ab);
        System.out.print("eliminado:");
        if (arista != null) {
            System.out.print(arista.destino);
        } else {
            System.out.println("null");
        }
    }
/**
 * Imprime el grafo
 */
    
    public void imprimirGrafo() {
        System.out.println("Grafo:");
        for (int i = 0; i < numVertices; i++) {
            Vertice vertice = vectorDeAdyacencia[i];
            System.out.print("Vertice " + vertice.nombreVertice() + " (" + i + ") -> ");

            // Recorrer las aristas del vértice actual
            Nodo aux = vertice.lad.getpFirst();
            while(aux!= null){
                System.out.print(" -- " + aux.getData().toString());
                aux = aux.getpNext();
            }

            System.out.println();
        }
    }
//    public ListaEnlazada DFS(String nombre) throws Exception {
//        Vertice inicio = this.DevuelveVerticePorNombre(nombre);
//
//        ListaEnlazada lista = new ListaEnlazada();
//        lista.addFirst(this.numVertice(nombre));
//        lista = this.recorridoDFS(lista, inicio);
//        return lista;
//    }
//
//    public ListaEnlazada recorridoDFS(ListaEnlazada lista, Vertice v) {
//        if (v != null) {
//            Nodo aux = v.lad.getpFirst();
//            if (!lista.buscar(aux.getData().toString())) {
//                lista.addLast(aux.getData());
//                while (aux != null) {
//                    try {
//                        if(this.DevuelveVertice2((aux.getData().toString())).lad.bombasAdy(this) == 0){
//                            recorridoDFS(lista, this.DevuelveVertice2((aux.getData().toString())));
//                        }
//                    } catch (Exception ex) {
//                        Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    aux = aux.getpNext();
//                }
//            }
//        }
//        return lista;
//    }
//    
//    
    public ListaEnlazada DFS(String nombre) throws Exception {
    Vertice inicio = this.devuelveVerticePorNombre(nombre);
    boolean[] visitados = new boolean[numVertices]; 
    ListaEnlazada lista = new ListaEnlazada();
    recorridoDFS(lista, inicio, visitados);
    return lista;
}
/**
 * Recorre
 * @param lista
 * @param v
 * @param visitados 
 */
public void recorridoDFS(ListaEnlazada lista, Vertice v, boolean[] visitados) {
    if (v == null || visitados[this.numVertice(v.nombreVertice())]) {
        return; 
    }
    visitados[this.numVertice(v.nombreVertice())] = true;
    lista.addLast(this.numVertice(v.nombreVertice())); 
    
    Nodo aux = v.lad.getpFirst();
    while (aux != null) {
        try {
            Vertice vecino = this.DevuelveVertice2(aux.getData().toString());
            if (!visitados[this.numVertice(vecino.nombreVertice())] && vecino.lad.bombasAdy(this) == 0) {
                recorridoDFS(lista, vecino, visitados); 
            }
        } catch (Exception ex) {
            System.err.println("Error al procesar el vértice: " + ex.getMessage());
        }
        aux = aux.getpNext();
    }
}
/*
Obtiene el vertice de incio
*/
public ListaEnlazada<Integer> BFS(String nombre) throws Exception {
    Vertice inicio = this.devuelveVerticePorNombre(nombre);
    if (inicio == null) {
        throw new Exception("El vértice no existe.");
    }

    ListaEnlazada<Integer> listaVisitados = new ListaEnlazada<>();
    boolean[] visitados = new boolean[numVertices];
   
    Cola<Vertice> cola = new Cola<>();
    cola.encolar(inicio);
    visitados[this.numVertice(inicio.nombreVertice())] = true; 

    while (!cola.estaVacia()) {
        System.out.println("Cuentame");
        Vertice actual = cola.desencolar().getData();
        System.out.println("Te conte");
        listaVisitados.addLast(this.numVertice(actual.nombreVertice())); 

        Nodo aux = actual.lad.getpFirst();
        while (aux != null) {
            try {
                Vertice vecino = this.DevuelveVertice2(aux.getData().toString());
                if (!visitados[this.numVertice(vecino.nombreVertice())]) {
                    cola.encolar(vecino); 
                    visitados[this.numVertice(vecino.nombreVertice())] = true; 
                }
            } catch (Exception ex) {
                System.err.println("Error al procesar el vértice: " + ex.getMessage());
            }
            aux = aux.getpNext();
        }
    }

    return listaVisitados;
}

//public ListaEnlazada<Integer> BFS(String nombre) throws Exception {
//        Vertice inicio = this.DevuelveVerticePorNombre(nombre);
//        if (inicio == null) {
//            throw new Exception("El vértice no existe.");
//        }
//
//        ListaEnlazada<Integer> listaVisitados = new ListaEnlazada<>();
//
//        boolean[] visitados = new boolean[numVertices];
//
//       Cola cola = new Cola();
//        cola.encolar(new Nodo(inicio));
//        visitados[this.numVertice(inicio.nombreVertice())] = true; 
//
//        while (!cola.estaVacia()) {
//            System.out.println("Cuentame");
//            Vertice actual = (Vertice) cola.desencolar().getData(); 
//            System.out.println("Te conte");
//            listaVisitados.addLast(this.numVertice(actual.nombreVertice())); 
//
//            Nodo aux = actual.lad.getpFirst();
//            while (aux != null) {
//                try {
//                    Vertice vecino = this.DevuelveVertice2(aux.getData().toString());
//                    if (!visitados[this.numVertice(vecino.nombreVertice())]) {
//                        cola.encolar(new Nodo(vecino)); 
//                        visitados[this.numVertice(vecino.nombreVertice())] = true; 
//                    }
//                } catch (Exception ex) {
//                    System.err.println("Error al procesar el vértice: " + ex.getMessage());
//                }
//                aux = aux.getpNext();
//            }
//        }
//
//        return listaVisitados;
//    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getMaxVertices() {
        return maxVertices;
    }

    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }
}
