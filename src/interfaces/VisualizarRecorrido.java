
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
    private ListaEnlazada recorrido;
    private Viewer visor;
    private ViewPanel panelVista;

    public VisualizarRecorrido(ListaEnlazada recorrido) {
        this.recorrido = recorrido;
        config();
        inicializarVisor();
        bntCerrar();
    }

    private void config() {
        
        setTitle("Arbol de Recorrido");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 
    }

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

    private void bntCerrar() {
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> {
            cerrar();
            dispose();
        });
        add(botonCerrar, BorderLayout.SOUTH);
    }

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
