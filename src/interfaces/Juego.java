/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import grafo.Grafo;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author jmmor
 */
public class Juego extends javax.swing.JFrame {
    private int nroFilas, nroColumnas, nroMinas;
    boolean bandera;
    Grafo grafo;

    public Juego(int nroFilas, int nroColumnas, int nroMinas, Grafo grafo) {
        initComponents();
        this.nroFilas = nroFilas;
        this.nroColumnas = nroColumnas;
        this.nroMinas = nroMinas;
        this.grafo = grafo;
    }

    public void casillaBM(JToggleButton casilla, boolean es_bomba, int bombas_ady) {
        /*Asumiendo que los nodos contienen una variable de si es o no una bomba
        
        Nodo :
            boolean es_bomba
            int bombas_ady  --> O la variable/funcion que determine la cantidad de bombas adyacentes a un nodo
        
         */

//        Nodo casilla = grafo.buscar(this.jToggleButton1.getText());
//        if(casilla.isSelected()){


        if (casilla.getText().equals("BANDERA") && this.bandera == false) {
            casilla.setSelected(true);
            return;
        }
        if (bandera) {
            if (casilla.getText().equals("BANDERA")) {
                casilla.setIcon(null);
                casilla.setText("A1");
            } else {
//                this.jToggleButton1.setIcon(bandera);
                casilla.setText("BANDERA");
//                casilla.set(false);

            }
        } else {
            if (es_bomba) {
                JOptionPane.showMessageDialog(null, "Perdistes");
            } else {
                if (bombas_ady == 0) {
//                        this.barrido
                } else {
//                        this.jToggleButton1.setText(casilla.bombas_ady);
                    casilla.setText("");
                }
            }
            System.out.println("DESABILITADA");
            casilla.setEnabled(false);
        }
//        }
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
        btnInicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        casillaA1 = new javax.swing.JToggleButton();
        btnGuardar = new javax.swing.JButton();
        btnBandera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setText("Volver a Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, 30));

        jLabel1.setText("FALSE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        casillaA1.setText("🚩");
        casillaA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA1ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 50, 50));

        btnGuardar.setText("Guardar juego");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 130, -1));

        btnBandera.setText("Bandera");
        btnBandera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanderaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBandera, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        CargarPartida carga = new CargarPartida();
        carga.setVisible(true);
        carga.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBanderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanderaActionPerformed
        if (bandera) {
            bandera = false;
            this.jLabel1.setText("FALSE");
        } else {
            bandera = true;
            this.jLabel1.setText("TRUE");

        }
    }//GEN-LAST:event_btnBanderaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        BuscaminasInterfaz busca = new BuscaminasInterfaz();
        busca.setVisible(true);
        busca.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void casillaA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA1ActionPerformed
        // vertice A1:
        this.casillaA1.setFont(new Font("Arial",Font.BOLD,10));
    }//GEN-LAST:event_casillaA1ActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBandera;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JToggleButton casillaA1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
