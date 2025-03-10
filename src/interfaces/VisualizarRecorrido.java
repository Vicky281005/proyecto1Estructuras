/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import grafo.ListaEnlazada;
import grafo.Nodo;
import grafo.Vertice;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author mishel
 */
public class VisualizarRecorrido extends JFrame {
    
    /**
     * Atributos de la clase VisualizarRecorrido
     */
    private ListaEnlazada recorrido;
    private Viewer visor;
    private ViewPanel panelVista;

    /**
     * Constructor de la clase VisualizarRecorrrido
     * @param recorrido 
     */
    public VisualizarRecorrido(ListaEnlazada recorrido) {
        this.recorrido = recorrido;
        config();
        inicializarVisor();
        bntCerrar();
    }

    /**
    * Configuración de toda la interfaz incluyendo el tamaño
    */
    private void config() {
        
        setTitle("Arbol de Recorrido"); //Titulo
        setSize(900, 800); //Tamaño interfaz
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout()); 
        setLocationRelativeTo(null); //Hace que abra en el centro
    }

    /**
     * Funcionalidad que inicializa el visor de la libraria GraphStream creando un grafo de la forma singlegraph
     */
    private void inicializarVisor() {
        
        Graph grafoVisual = new SingleGraph("Recorrido");
        construirArbol(grafoVisual);

        visor = grafoVisual.display(false);
        visor.enableAutoLayout();

        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    /** 
     * Funcionaldad que recorre la lista de recorridos y se le van metiendo todos esos vertices dentro de los nodos que conforman el grafo que viene con la libreria
     * Con esto empiezo a insertar los vertices con las conexiones en el grafoVisual 
     * @param grafoVisual 
     */
    private void construirArbol(Graph grafoVisual) {
        Nodo aux = recorrido.getpFirst();
        String nodoAnterior = null;

        while (aux != null) {
            Vertice vertice = (Vertice) aux.getData();
            String nombreVertice = vertice.getNombre();

            if (grafoVisual.getNode(nombreVertice) == null) {
                Node nodo = grafoVisual.addNode(nombreVertice);
                nodo.setAttribute("ui.label", nombreVertice);
                
                nodo.setAttribute("ui.style", "fill-color: gray; size: 20px; text-size: 12px;");
            }

            if (nodoAnterior != null) {
                
                if (grafoVisual.getEdge(nodoAnterior + "-" + nombreVertice) == null) {
                    grafoVisual.addEdge(nodoAnterior + "-" + nombreVertice, nodoAnterior, nombreVertice, true)
                            .setAttribute("ui.style", "fill-color: black; size: 0.5px;"); 
                }
            }

            nodoAnterior = nombreVertice;
            aux = aux.getpNext();
        }
        
        
       
        grafoVisual.setAttribute("ui.stylesheet",
                "node { text-size: 12px; size: 25px; text-alignment: under; }" +
                        "edge { size: 1px; fill-color: black; }");
    }

    
    /**
     * Crea el botón 'cerrar' y lo pone en la parte de abajo centrado cuando sale el gráfico del recorrido
     */
    private void bntCerrar() {
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> {
            cerrar(); // cerrar visor
            dispose(); // cerrar panel
        });
        add(botonCerrar, BorderLayout.SOUTH); //pone el botón cerrar abajo y centrado
    }

    /**
     * Funcionalidad que hace que cuando se pise el botón cerrar se cierre el visor donde esta el gráfico 
     * Al cerrar el visor 'vuelvas', entre comiillas porque en verdad nunca se cerró el panel del tablero, al tablero del juego y puedas continuar con el juego
     */
    private void cerrar() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
    }
    
}
