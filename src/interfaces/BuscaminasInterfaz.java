/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import grafo.Grafo;
import java.util.Arrays;


/**
 *
 * @author jmmor
 */
public class BuscaminasInterfaz extends javax.swing.JFrame {
    private int nroFilas, nroColumnas, nroMinas;
    /**
     * Inicializacion de los atributos de la clase que son nrofilas, nrocolumnas y nrominas.
     */
    public BuscaminasInterfaz() {
//        Constructor de la clase Buscaminas Interfaz
        initComponents();
        this.nroFilas = 10;
        this.nroColumnas = 10;
        this.nroMinas = 35;
        
    }
    
    public BuscaminasInterfaz(int nroFilas, int nroColumnas, int nroMinas) {
//        Constructor de la clase Buscaminas Interfaz
        initComponents();
        this.nroFilas = nroFilas;
        this.nroColumnas = nroColumnas;
        this.nroMinas = nroMinas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnConfiguración = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        jLabel1.setText("Buscaminas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 230, -1));

        btnJugar.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        btnJugar.setText("Iniciar Juego");
        btnJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        jPanel1.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 260, 40));

        btnSalir.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 260, 40));

        btnConfiguración.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        btnConfiguración.setText("Configuracion del juego");
        btnConfiguración.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguraciónActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfiguración, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 260, 40));

        btnCargar.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        btnCargar.setText("Cargar Juego");
        btnCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 770, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        Grafo grafo = new Grafo(this.nroFilas*this.nroColumnas); //crea un nuevo objeto de la clase grafo basado en la variables globales de la clase BuscaminasInterfaz
        String[] filasCoordenadas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //Define la coordenadas de las filas en coordenadas de A a la J
        String[] arregloVectores = new String[this.nroFilas*this.nroColumnas]; //Crea un arreglo de vectores para almacenar las coordenadas de los vertices
        int[] columnasCoordenadas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //Define las coordenas de las columnas del 1 al 10 

        int contador= 0; //        Contador que llena el arreglo de vertices 

//Bucle For que genera las coordenadas de las casillas combinando filas y columnas
        for (int i = 0; i < this.nroFilas; i++){ 
            String coordFila = filasCoordenadas[i]; //Obtiene la letra de la fila actual
            for (int j = 0; j < this.nroColumnas; j++){
                String coordColumna = String.valueOf(columnasCoordenadas[j]); // Obtiene el número de la columna actual
                String concatenacion = coordFila + coordColumna; // Combina la final y las columnas
                arregloVectores[contador] = concatenacion;//Almacena la posición la posicion en el arreglo
                contador++;//Incrementa el contador para la siguiente posición del arreglo
                
                // TODO: continuar mas tarde por vicky
            }
        }
        
        // Imprimir el arreglo de coordenadas generado (para depuración)
        System.out.println(Arrays.toString(arregloVectores));

// Crear los vértices en el grafo utilizando el arreglo de coordenadas
        grafo.nuevoVerticesRecibiendoArrayDeVertices(arregloVectores);

// Colocar minas aleatoriamente en el grafo, según el número de minas especificado
        grafo.fijarMinasAleatoriamente(this.nroMinas);

        
        
        Juego jugar = new Juego(nroFilas, nroColumnas, nroMinas, grafo); //Llega a una instancia del juego con los parametros configurados
            jugar.setVisible(true);
            jugar.setLocationRelativeTo(null);
            this.dispose(); //Sale de la ventana emergente
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
//      Hace que el usuario salga del juego, es decir termina el programa.
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguraciónActionPerformed
//      Dirige al usuario a la configuración del tablero.
        Configuracion confi = new Configuracion();
        confi.setVisible(true);
        confi.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnConfiguraciónActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
//       Boton que carga el juego a la ultima partida jugada.
        CargarPartida carga = new CargarPartida();
        carga.setVisible(true);
        carga.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnCargarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaminasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaminasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaminasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaminasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaminasInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnConfiguración;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
