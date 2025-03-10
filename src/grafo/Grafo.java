package grafo;

import interfaces.BuscaminasInterfaz;
import interfaces.Juego;
import java.awt.Color;
import javax.swing.JOptionPane;

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
        return this.vectorDeAdyacencia[v1].getLad().contains(new Arista(v2));
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
        if (this.vectorDeAdyacencia[v1].getLad().contains(new Arista(v2))) {
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
            if (v1 < 0 || v2 < 0) {
                throw new Exception("El veertice no existe");
            }
            Arista ab = new Arista(v2);
            this.vectorDeAdyacencia[v1].getLad().addLast(ab);
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
        Arista arista = this.vectorDeAdyacencia[v1].getLad().removeArista(ab);
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
            Nodo aux = vertice.getLad().getpFirst();
            while(aux!= null){
                System.out.print(" -- " + aux.getData().toString());
                aux = aux.getpNext();
            }

            System.out.println();
        }
    }
    
    public int[] siSeQuierePonerQuitarBandera(javax.swing.JToggleButton button, String nombre, int indice, int numeroBombasMarcadasConBandera, int numeroBanderasPuestas, int nroMinas, Juego juego){
        // numeroBombasMarcadasConBandera
        // numeroBanderasPuestas
        if (this.getVectorDeAdyacencia()[indice].isMarcado()) {
                this.getVectorDeAdyacencia()[indice].setMarcado(false);// NO MARCADAS: Necesario para cuando se vaya a guardar el CSV saber cuales estan marcadas y cuales no para mostrarlas
                button.setText("");
                if (this.getVectorDeAdyacencia()[indice].isSoyUnaBomba()) { 
                    numeroBombasMarcadasConBandera--; //Numero de bombas disminuye 1 porque usuario desmarcó 1 bomba
                }
                numeroBanderasPuestas--; //Numero de banderas disminuye 1 porque usuario desmarcó 1 bandera
            
            /** 
             * Funcionalidad para marcar una casilla con bandera
             * @return Cambia el color de la casilla de blanco a verde y se aumenta tanto el número de bombas como de banderas
             */    
            } else { //si casilla NO estaba marcada esto lo que hace es marcarla
                
                if (numeroBanderasPuestas == nroMinas){
                /**
                 * Avisa cuando estas poniendo más bandera que cantidad de minas que hay en el juego
                 * @return le sale un mensaje al usuario diciendo que ya marcó el máximo de minas que hay en el juego
                 */
                    JOptionPane.showMessageDialog(null, "Ya marcaste el máximo de minas que hay en el juego, por ahora solo puedes desmarcar casillas");
                }
                else if (numeroBanderasPuestas < nroMinas) { // SOLO se puede marcar con bandera si el numero de banderas es menor al  numero de minas, si no es menor entonces mo se puede marcar
                    System.out.println("entre");
                    button.setText("🚩");
                    this.getVectorDeAdyacencia()[indice].setMarcado(true); //MARCADAS: Necesario para cuando se vaya a guardar el CSV saber cuales estan marcadas y cuales no para mostrarlas
                    if (this.getVectorDeAdyacencia()[indice].isSoyUnaBomba()) {
                        numeroBombasMarcadasConBandera++; //Numero de bombas aumenta 1 porque usuario marcó con bandera 1 bomba
                        
                    }
                    numeroBanderasPuestas++; //Numero de banderas aumenta 1 porque usuario marcó 1 bandera
                } 
            }
            
            /** 
             * Funcionalidad de que ganaste
             * Una vez que marques con bandera todas las casillas que tienen minas ganas
             * @return mensaje que dice que ganaste
             */
            if (numeroBombasMarcadasConBandera==nroMinas) {
                JOptionPane.showMessageDialog(null, "FELICIDADES, HAS GANADO!!");
                BuscaminasInterfaz v1 = new BuscaminasInterfaz();
                v1.setVisible(true); // Hace visible la ventana BuscaminasInterfaz
                v1.setLocationRelativeTo(null); // Centra la ventana
                v1.setResizable(false); // Hace que no se pueda modificar la ventana, es decir queda centrado y en un tamaño fijo
                juego.dispose();
            }
            
            int[] arrayToReturn = {numeroBombasMarcadasConBandera, numeroBanderasPuestas};

            return arrayToReturn;
    }
    
    /**
 * Modifica el estado de una casilla en el tablero de juego, ya sea para quitar una bandera previamente colocada o para manejar la lógica de banderas 
 * y casillas dependiendo del estado de la bandera.
 * 
 * @param button El botón asociado a la casilla que será modificado.
 * @param nombre El nombre de la casilla, utilizado para identificaciones internas.
 * @param indice El índice de la casilla en el vector de adyacencia.
 * @param buscarPorDFS Indica si se está utilizando DFS o BFS.
 * @param numeroBombasMarcadasConBandera Número total de bombas marcadas con una bandera actualmente.
 * @param numeroBanderasPuestas Número total de banderas colocadas en el tablero.
 * @param nroMinas Número total de minas en el juego.
 * @param juego El objeto del juego que contiene el estado actual del tablero y otras configuraciones.
 * @param bandera Indica si se está en el modo de colocación de banderas.
 * 
 * @return Un arreglo de enteros donde:
 *         - En la posición 0: el número actualizado de bombas marcadas con bandera.
 *         - En la posición 1: el número actualizado de banderas colocadas.
 */
    public int[] escribirCasillaGlobal(javax.swing.JToggleButton button, String nombre, int indice, boolean buscarPorDFS,  int numeroBombasMarcadasConBandera, int numeroBanderasPuestas, int nroMinas, Juego juego, boolean bandera){
        if (!bandera){
            if(this.getVectorDeAdyacencia()[indice].isMarcado()){
                this.getVectorDeAdyacencia()[indice].setMarcado(false);
                if (this.getVectorDeAdyacencia()[indice].isSoyUnaBomba()){
                    numeroBombasMarcadasConBandera--;
                }
                numeroBanderasPuestas--;
            }
            /**
             * Funcionalidad para quitarle bandera a una casilla, es decir desmarcar una casilla que estaba marcada con bandera
             * @return Cambia el color de la casilla de verde a blanco y se resta tanto el número de bombas como de banderas
             */
            this.antesDeEscribirCasilla(button, nombre, indice, buscarPorDFS, juego); 
            
            int[] arrayToReturn =  {numeroBombasMarcadasConBandera, numeroBanderasPuestas};
            return arrayToReturn; // numeroBombasMarcadasConBandera (0) y numeroBanderasPuestas (1)
        } else {
            int[] arrayToReturn = this.siSeQuierePonerQuitarBandera(button, nombre, indice, numeroBombasMarcadasConBandera, numeroBanderasPuestas, nroMinas, juego);
            return arrayToReturn; // numeroBombasMarcadasConBandera (0) y numeroBanderasPuestas (1)
        }
    }
    
    
    /**
 * Realiza las operaciones necesarias antes de modificar una casilla en el tablero.
 * Marca la casilla como barrida y verifica si se ha seleccionado una casilla que contiene
 * una bomba. En caso de seleccionar una bomba, finaliza el juego y muestra la interfaz
 * correspondiente.
 * 
 * @param button El botón asociado a la casilla a modificar.
 * @param nombre El nombre de la casilla, utilizado para identificaciones internas.
 * @param indice El índice de la casilla dentro del vector de adyacencia.
 * @param buscarPorDFS Indica si se está utilizando un  búsqueda DFS o BFS.
 * @param juego El objeto del juego, utilizado para realizar operaciones adicionales como cerrar la ventana.
 * 
 * @implNote Este método también asegura que las casillas barridas se registren correctamente 
 *           para su posterior guardado en un archivo CSV.
 * 
 * @throws JOptionPane Muestra un cuadro de diálogo si el jugador selecciona una casilla con bomba,
 *                     indicando que ha perdido el juego.
 */
    public void antesDeEscribirCasilla(javax.swing.JToggleButton button, String nombre, int indice, boolean buscarPorDFS, Juego juego){
            this.escribirCasilla(button, nombre, indice, buscarPorDFS);  
            //Necesario para cuando se vaya a guardar el CSV saber cuales ya se han barrido y cuales no para saber que mostrar y que no   
            this.getVectorDeAdyacencia()[indice].setBarrido(true); //No afecta al funcionamiento
            /**
            * Funcionalidad para que cuando se pise una casilla con bomba pierdas
            * @return "Haz Perdido"
             */    
            if (this.getVectorDeAdyacencia() [indice].isSoyUnaBomba()) {
                JOptionPane.showMessageDialog(null, "Haz Perdido");
                BuscaminasInterfaz v1 = new BuscaminasInterfaz();
                v1.setVisible(true); // Hace visible la ventana BuscaminasInterfaz
                v1.setLocationRelativeTo(null); // Centra la ventana
                v1.setResizable(false); // Hace que no se pueda modificar la ventana, es decir queda centrado y en un tamaño fijo
                juego.dispose();
            }
            
    }
    
    /**
 * Modifica el estado visual de un botón de casilla en el tablero de juego.
 * Muestra un emoji si la casilla contiene una bomba o el número de bombas adyacentes
 * si no es una bomba. El texto del botón se actualiza dependiendo del resultado.
 * 
 * @param button El botón asociado a la casilla que será modificado.
 * @param nombre El nombre de la casilla, utilizado para buscar las bombas adyacentes.
 * @param indice El índice de la casilla en el vector de adyacencia.
 * @param buscarPorDFS Indica si se deben buscar las bombas adyacentes usando DFS o BFS .
 * 
 * @implNote Si ocurre una excepción al recuperar el vértice, el botón se oculta (se desactiva su visibilidad).
 */
    public void escribirCasilla(javax.swing.JToggleButton button, String nombre, int indice, boolean buscarPorDFS){
//        button.setEnabled(false);
        button.setForeground(java.awt.Color.BLACK);
        try {
            Vertice vertice = this.DevuelveVertice(indice);
            if (vertice.isSoyUnaBomba()){
                button.setText(vertice.getEmoji());
            } else{
                System.out.println(buscarPorDFS);
                System.out.println(buscarPorDFS);
                int bombasAdyacentes =  buscarPorDFS ? this.casillasBombaAdyacentePorDFS(nombre) : this.casillasBombaAdyacentePorBFS(nombre);
                button.setText(String.valueOf(bombasAdyacentes));
                
            }
        } catch (Exception ex) {
            button.setVisible(false);
        }
        
    }
    /**
 * Realiza una búsqueda en amplitud (BFS) a partir de un vértice especificado y calcula
 * la cantidad de bombas adyacentes en el grafo. Determina si un vértice contiene una bomba,
 * es vacío o tiene bombas adyacentes.
 * 
 * @param nombre El nombre del vértice desde el cual se inicia la búsqueda.
 * @return Un valor entero que indica:
 *         - `-1`: Si se encuentra una bomba en las casillas adyacentes.
 *         - 0: Si el vértice y las casillas adyacentes están vacías.
 *         - Un número positivo: La cantidad de bombas adyacentes a la casilla.
 * 
 * @implNote Este método utiliza una estructura de lista enlazada y un algoritmo de
 *           búsqueda en amplitud BFS para recorrer los vértices. Realiza validaciones
 *           para determinar si un vértice es una bomba o calcular el número de bombas adyacentes.
 */
    public int casillasBombaAdyacentePorBFS(String nombre){
        try {
        
        ListaEnlazada<Integer> visitados = this.BFS(nombre);

        Nodo aux = visitados.getpFirst();

        while (aux != null) {
            
            int indiceVertice = (int) aux.getData(); 

            Vertice vertice = this.DevuelveVertice(indiceVertice);

            if (vertice.isSoyUnaBomba()) {
                System.out.println("Casilla " + vertice.nombreVertice() + ": 💣");
                return -1;
            } else {
               
                int bombasAdyacentes = vertice.getLad().bombasAdy(this);

                if (bombasAdyacentes == 0) {
                    System.out.println("Casilla " + vertice.nombreVertice() + ": Vacía");
                    return 0;
                } else {
                    System.out.println("Casilla " + vertice.nombreVertice() + ": " + bombasAdyacentes + " bombas adyacentes");
                    return bombasAdyacentes;
                }
            }

        }
        } catch (Exception ex) {

            System.err.println("Error: " + ex.getMessage());

        }
        return -1;
    }
    
  


/**
 * Realiza una búsqueda en amplitud BFS desde un vértice inicial, explorando sus vecinos
 * y marcando aquellos que cumplen con las condiciones de la lógica del juego. Los vértices
 * visitados son añadidos a una lista enlazada.
 * 
 * @param actual El vértice inicial desde donde comienza la búsqueda en amplitud.
 * @param listaVisitados Una lista enlazada que almacena los vértices visitados durante la búsqueda que sera util para graficar.
 * 
 * 
 * @implNote La lógica explora los vecinos de cada vértice utilizando una cola para asegurar
 *           el orden de amplitud. Se valida que los vértices vecinos no hayan sido barridos
 *           previamente y que cumplan con la condición de bombas adyacentes igual a cero.
 */
public ListaEnlazada BFSRecursivoPorMi(Vertice actual, ListaEnlazada listaVisitados ) throws Exception {
    // Inicializa la lista de visitados y la cola de vértices a explorar
    Cola cola = new Cola();
    // Encola el vértice inicial y márcalo como visitado
    cola.encolar(actual);
    actual.setBarrido(true);
    listaVisitados.addLast(actual);
    this.cambiadorVerticesABarridoVerdadero(actual);

    // Realiza la búsqueda en amplitud
    while (!cola.estaVacia()) {
        // Desencola el siguiente vértice
        Vertice vertice = (Vertice) cola.desencolar().getData();

        // Obtén los vecinos del vértice actual
        Nodo aux = vertice.getLad().getpFirst();
        while (aux != null) {
            Vertice vecino = this.DevuelveVertice2(aux.getData().toString());

            // Si el vecino no ha sido visitado y cumple las condiciones, se explora
            if (!vecino.isBarrido() && this.casillasBombaAdyacentePorDFS(vertice.nombreVertice()) == 0) {
                vecino.setBarrido(true);
                listaVisitados.addLast(vecino);
                cola.encolar(vecino);
                this.cambiadorVerticesABarridoVerdadero(vecino);
            }

            aux = aux.getpNext();
        }
    }

    return listaVisitados;
}

/**
 * Marca un vértice como "barrido" dentro del vector de adyacencia del grafo.
 * Este método recorre todos los vértices del grafo, buscando aquel cuyo nombre
 * coincida con el vértice proporcionado.
 * 
 * @param vertice El vértice que se desea marcar como "barrido".
 */
public void cambiadorVerticesABarridoVerdadero(Vertice vertice){
    for (int i = 0; i < this.maxVertices; i++){
        if (this.vectorDeAdyacencia[i].getNombre().equalsIgnoreCase(vertice.getNombre())){
            this.vectorDeAdyacencia[i].setBarrido(true);
        }
    }
}

/**
 * Realiza una búsqueda en profundidad (DFS) a partir de un vértice inicial, visitando
 * todos los vértices accesibles que cumplan ciertas condiciones, y almacena los vértices
 * visitados en una lista enlazada.
 * 
 * @param actual El vértice inicial desde donde comienza la búsqueda.
 * @param listaVisitados Una lista enlazada donde se almacenan los vértices visitados (inicialmente vacia).
 * @return Una lista enlazada que contiene los vértices visitados durante la ejecución de la búsqueda, lo cual sera util para graficar.
 * 
 * @implNote Este método utiliza recursión para explorar los vecinos del vértice actual. Los vecinos
 *           solo se visitan si no han sido previamente barridos y cumplen la condición de tener
 *           un valor de bombas adyacentes igual a 0.
 */
public ListaEnlazada DFSRecursivoPorMi(Vertice actual, ListaEnlazada listaVisitados) throws Exception{ // lista visitados inicialmente vacia
    
        // Marca el vértice como visitado y añádelo a la lista
    actual.setBarrido(true);
    listaVisitados.addLast(actual);
    this.cambiadorVerticesABarridoVerdadero(actual);
    
    // Recorre todos los vecinos del vértice actual
    Nodo aux = actual.getLad().getpFirst();
    while (aux != null) {
        Vertice vecino = this.DevuelveVertice2(aux.getData().toString());
        int indiceVecino = this.numVertice(vecino.nombreVertice());
        
//        if (this.casillasBombaAdyacentePorDFS(vecino.nombreVertice()) > 0 && !vecino.isBarrido()) {
//            Graph(actual,vecinos)
//        }
        
        // Continúa la búsqueda solo si el vecino no ha sido visitado y tiene valor 0
        System.out.println(this.casillasBombaAdyacentePorDFS(vecino.nombreVertice()));
        if (this.casillasBombaAdyacentePorDFS(vecino.nombreVertice()) == 0 && !vecino.isBarrido() && this.casillasBombaAdyacentePorDFS(actual.nombreVertice()) == 0){
            
            DFSRecursivoPorMi(vecino, listaVisitados);
            
        } else if (this.casillasBombaAdyacentePorDFS(vecino.nombreVertice()) > 0 && this.casillasBombaAdyacentePorDFS(actual.nombreVertice()) == 0 && !vecino.isBarrido()){
                vecino.setBarrido(true);
                listaVisitados.addLast(vecino);
        }
        
        
        
        aux = aux.getpNext();
    }
    return listaVisitados;
    
    
}
    /**
 * Calcula la cantidad de bombas adyacentes a un vértice específico utilizando
 * un recorrido en profundidad (DFS). Si el vértice actual contiene una bomba,
 * retorna un valor especial para indicar su presencia.
 * 
 * @param nombre El nombre del vértice desde donde se inicia la búsqueda en profundidad.
 * @return Un valor entero que indica:
 *         - `-1`: Si el vértice actual es una bomba (no se calcula bombas adyacentes).
 *         - `0`: Si el vértice y sus vecinos no tienen bombas adyacentes.
 *         - Un número positivo: La cantidad de bombas adyacentes al vértice.
 *
 * @implNote Este método recorre los vértices conectados al inicial usando DFS,
 *           evalúa si son bombas o calcula las bombas adyacentes utilizando la
 *           lista de adyacencia del vértice.
 */
    public int casillasBombaAdyacentePorDFS(String nombre){
        try {
        
        ListaEnlazada visitados = this.DFS(nombre);

        Nodo aux = visitados.getpFirst();
       
        while (aux != null) {
            
            String nombreCasilla = aux.getData().toString();

            int indiceVertice = Integer.parseInt(nombreCasilla);

            Vertice vertice = this.DevuelveVertice(indiceVertice);
            
            if (vertice.isSoyUnaBomba()) {
                System.out.println("Casilla " + vertice.nombreVertice() + ": 💣");
                return -1; //No diremos las bombas adyacentes puesto que esto es una bomba
            } else {
                int bombasAdyacentes = vertice.getLad().bombasAdy(this);
                if (bombasAdyacentes == 0) {
                    System.out.println("Casilla " + vertice.nombreVertice() + ": Vacía");
                    return 0;
                } else {
                    System.out.println("Casilla " + vertice.nombreVertice() + ": " + bombasAdyacentes + " bombas adyacentes");
                    return bombasAdyacentes;
                    
                }
            }

        }
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());      
    }
        return -1;
    }

    
    /**
 * Realiza una búsqueda en profundidad (DFS) a partir de un vértice inicial
 * identificado por su nombre. El método recorre los vértices conectados y
 * devuelve una lista con los vértices visitados durante el recorrido.
 * 
 * @param nombre El nombre del vértice desde donde se inicia la búsqueda DFS.
 * @return Una lista enlazada (ListaEnlazada) que contiene los vértices visitados  en el orden en que fueron explorados.
 * 
 * 
 * @implNote Este método utiliza un arreglo booleano (`visitados`) para rastrear, el método auxiliar `recorridoDFS` realiza la lógica recursiva.
 */
    public ListaEnlazada DFS(String nombre) throws Exception {
    Vertice inicio = this.devuelveVerticePorNombre(nombre);
    boolean[] visitados = new boolean[numVertices]; 
    ListaEnlazada lista = new ListaEnlazada();
    recorridoDFS(lista, inicio, visitados);
    return lista;
}
    
/**
 * Realiza un recorrido en profundidad (DFS) desde un vértice inicial, marcando
 * los vértices visitados y añadiéndolos a una lista enlazada. Se exploran solo
 * aquellos vértices vecinos que no han sido visitados y cumplen con la condición
 * de no tener bombas adyacentes.
 * 
 * @param lista Una lista enlazada donde se almacenan los índices de los vértices visitados durante el recorrido DFS.
 * @param v El vértice actual desde donde se realiza la exploración.
 * @param visitados Un arreglo booleano que registra cuáles vértices ya han sido visitados.
 * 
 */
public void recorridoDFS(ListaEnlazada lista, Vertice v, boolean[] visitados) {
    if (v == null || visitados[this.numVertice(v.nombreVertice())]) {
        return; 
    }
    visitados[this.numVertice(v.nombreVertice())] = true;
    lista.addLast(this.numVertice(v.nombreVertice())); 
    
    Nodo aux = v.getLad().getpFirst();
    while (aux != null) {
        try {
            Vertice vecino = this.DevuelveVertice2(aux.getData().toString());
            if (!visitados[this.numVertice(vecino.nombreVertice())] && vecino.getLad().bombasAdy(this) == 0) {
                recorridoDFS(lista, vecino, visitados); 
            }
        } catch (Exception ex) {
            System.err.println("Error al procesar el vértice: " + ex.getMessage());
        }
        aux = aux.getpNext();
    }
}


/**
 * Realiza una búsqueda en amplitud (BFS) a partir de un vértice inicial identificado
 * por su nombre. Recorre todos los vértices alcanzables desde el inicial y almacena
 * sus índices en una lista enlazada.
 * 
 * @param nombre El nombre del vértice inicial desde donde comienza la búsqueda BFS.
 * @return Una lista enlazada (`ListaEnlazada<Integer>`) que contiene los índices de los vértices visitados durante la búsqueda.
 *
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
        Vertice actual = cola.desencolar().getData();
        listaVisitados.addLast(this.numVertice(actual.nombreVertice())); 

        Nodo aux = actual.getLad().getpFirst();
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

}
