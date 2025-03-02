/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import grafo.Grafo;
import grafo.Vertice;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        casillaA2 = new javax.swing.JToggleButton();
        casillaA3 = new javax.swing.JToggleButton();
        casillaA4 = new javax.swing.JToggleButton();
        casillaA5 = new javax.swing.JToggleButton();
        casillaA6 = new javax.swing.JToggleButton();
        casillaA7 = new javax.swing.JToggleButton();
        casillaA8 = new javax.swing.JToggleButton();
        casillaA9 = new javax.swing.JToggleButton();
        casillaA10 = new javax.swing.JToggleButton();
        casillaA11 = new javax.swing.JToggleButton();
        casillaA12 = new javax.swing.JToggleButton();
        casillaA13 = new javax.swing.JToggleButton();
        casillaA14 = new javax.swing.JToggleButton();
        casillaA15 = new javax.swing.JToggleButton();
        casillaA16 = new javax.swing.JToggleButton();
        casillaA17 = new javax.swing.JToggleButton();
        casillaA18 = new javax.swing.JToggleButton();
        casillaA19 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnInicio.setText("Volver a Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 140, 30));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel1.setText("FALSE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        casillaA1.setText("🚩");
        casillaA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA1ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 50, 50));

        btnGuardar.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar juego");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 140, -1));

        btnBandera.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        btnBandera.setText("Bandera");
        btnBandera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanderaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBandera, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        casillaA2.setText("🚩");
        casillaA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA2ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 50, 50));

        casillaA3.setText("🚩");
        casillaA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA3ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 50, 50));

        casillaA4.setText("🚩");
        casillaA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA4ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 50, 50));

        casillaA5.setText("🚩");
        casillaA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA5ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 50, 50));

        casillaA6.setText("🚩");
        casillaA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA6ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 50, 50));

        casillaA7.setText("🚩");
        casillaA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA7ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 50, 50));

        casillaA8.setText("🚩");
        casillaA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA8ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 50, 50));

        casillaA9.setText("🚩");
        casillaA9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA9ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 50, 50));

        casillaA10.setText("🚩");
        casillaA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA10ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 50, 50));

        casillaA11.setText("🚩");
        casillaA11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA11ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 50, 50));

        casillaA12.setText("🚩");
        casillaA12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA12ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 50, 50));

        casillaA13.setText("🚩");
        casillaA13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA13ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 50, 50));

        casillaA14.setText("🚩");
        casillaA14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA14ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 50, 50));

        casillaA15.setText("🚩");
        casillaA15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA15ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 50, 50));

        casillaA16.setText("🚩");
        casillaA16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA16ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 50, 50));

        casillaA17.setText("🚩");
        casillaA17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA17ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 50, 50));

        casillaA18.setText("🚩");
        casillaA18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA18ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 50, 50));

        casillaA19.setText("🚩");
        casillaA19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaA19ActionPerformed(evt);
            }
        });
        jPanel1.add(casillaA19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
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
        
        int indice = this.grafo.numVertice("A1");
        try {
            Vertice vertice = this.grafo.DevuelveVertice(indice);
            System.out.println(vertice.getEmoji());
            this.casillaA1.setText(vertice.getEmoji());
        } catch (Exception ex) {
            this.casillaA1.setVisible(false);
        }
    }//GEN-LAST:event_casillaA1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        if (grafo.numVertice("A1") == -1){
            this.casillaA1.setVisible(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void casillaA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA2ActionPerformed
        // A2
    }//GEN-LAST:event_casillaA2ActionPerformed

    private void casillaA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA3ActionPerformed
        //A3
    }//GEN-LAST:event_casillaA3ActionPerformed

    private void casillaA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA4ActionPerformed

    private void casillaA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA5ActionPerformed

    private void casillaA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA6ActionPerformed

    private void casillaA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA7ActionPerformed

    private void casillaA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA8ActionPerformed

    private void casillaA9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA9ActionPerformed

    private void casillaA10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA10ActionPerformed

    private void casillaA11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA11ActionPerformed

    private void casillaA12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA12ActionPerformed

    private void casillaA13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA13ActionPerformed

    private void casillaA14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA14ActionPerformed

    private void casillaA15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA15ActionPerformed

    private void casillaA16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA16ActionPerformed

    private void casillaA17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA17ActionPerformed

    private void casillaA18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA18ActionPerformed

    private void casillaA19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaA19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casillaA19ActionPerformed

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
    private javax.swing.JToggleButton casillaA10;
    private javax.swing.JToggleButton casillaA11;
    private javax.swing.JToggleButton casillaA12;
    private javax.swing.JToggleButton casillaA13;
    private javax.swing.JToggleButton casillaA14;
    private javax.swing.JToggleButton casillaA15;
    private javax.swing.JToggleButton casillaA16;
    private javax.swing.JToggleButton casillaA17;
    private javax.swing.JToggleButton casillaA18;
    private javax.swing.JToggleButton casillaA19;
    private javax.swing.JToggleButton casillaA2;
    private javax.swing.JToggleButton casillaA3;
    private javax.swing.JToggleButton casillaA4;
    private javax.swing.JToggleButton casillaA5;
    private javax.swing.JToggleButton casillaA6;
    private javax.swing.JToggleButton casillaA7;
    private javax.swing.JToggleButton casillaA8;
    private javax.swing.JToggleButton casillaA9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
