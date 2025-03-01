/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

//import proyecto1estructuras.buscaminas.BuscaminasInterfaz;

import javax.swing.JOptionPane;


/**
 *
 * @author jmmor
 */
public class Configuracion extends javax.swing.JFrame {

    int fila, columna, minas;
    public Configuracion() {
        initComponents();
        this.fila = this.columna = this.minas = 3;
    }
    
    public Configuracion(int fila, int columna, int minas) {
        initComponents();
        this.fila = fila;
        this.columna = columna;
        this.minas = minas;
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
        btnInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numFilasTextField = new javax.swing.JTextField();
        numColumnasTextField = new javax.swing.JTextField();
        numMinasTextField = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Configración del juego");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        btnInicio.setText("Volver a inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 170, 50));

        jLabel2.setText("Numero de columnas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel3.setText("Numero de filas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel4.setText("Numero de minas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        numFilasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFilasTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numFilasTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, -1));

        numColumnasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numColumnasTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numColumnasTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 150, -1));

        numMinasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numMinasTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numMinasTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, -1));

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numColumnasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numColumnasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numColumnasTextFieldActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        BuscaminasInterfaz busca = new BuscaminasInterfaz(this.fila,this.columna,this.minas);
        busca.setVisible(true);
        busca.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
        if(Integer.parseInt(this.numColumnasTextField.getText()) <=10 && Integer.parseInt(this.numColumnasTextField.getText()) >= 3){
            this.fila = Integer.parseInt(this.numColumnasTextField.getText());
        }  else {
            throw new IllegalArgumentException("El número de columnas debe estar entre 3 y 10.");
        }
        if(Integer.parseInt(this.numFilasTextField.getText()) <= 10 && Integer.parseInt(this.numFilasTextField.getText()) >= 3){
            this.columna = Integer.parseInt(this.numFilasTextField.getText());
        } else {
            throw new IllegalArgumentException("El número de filas debe estar entre 3 y 10.");
        }
        if(Integer.parseInt(this.numMinasTextField.getText()) <= this.fila * this.columna && Integer.parseInt(this.numMinasTextField.getText())> 0){
            this.minas = Integer.parseInt(this.numMinasTextField.getText());
        } else {
            throw new IllegalArgumentException("El número de minas debe ser mayor a 0 y menor o igual al tamaño del tablero.");
        }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void numFilasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFilasTextFieldActionPerformed
 
        
    }//GEN-LAST:event_numFilasTextFieldActionPerformed

    private void numMinasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numMinasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numMinasTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numColumnasTextField;
    private javax.swing.JTextField numFilasTextField;
    private javax.swing.JTextField numMinasTextField;
    // End of variables declaration//GEN-END:variables
}
