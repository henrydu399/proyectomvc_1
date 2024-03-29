
package co.edu.uniminuto.proyectomvc.views;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author henry
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form principalView
     */
    public PrincipalView() {
        initComponents();
        
        this.jInternalFrameNotificaciones.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.jInternalFrameNotificaciones.getUI();
        bui.setNorthPane(null);
        
        this.jInternalFrameCuerpo.setBorder(null);
        BasicInternalFrameUI bui2 = (BasicInternalFrameUI) this.jInternalFrameCuerpo.getUI();
        bui2.setNorthPane(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameNotificaciones = new javax.swing.JInternalFrame();
        jInternalFrameCuerpo = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuCliente = new javax.swing.JMenuItem();
        jMenuInformacion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrameNotificaciones.setVisible(true);

        javax.swing.GroupLayout jInternalFrameNotificacionesLayout = new javax.swing.GroupLayout(jInternalFrameNotificaciones.getContentPane());
        jInternalFrameNotificaciones.getContentPane().setLayout(jInternalFrameNotificacionesLayout);
        jInternalFrameNotificacionesLayout.setHorizontalGroup(
            jInternalFrameNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
        );
        jInternalFrameNotificacionesLayout.setVerticalGroup(
            jInternalFrameNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jInternalFrameCuerpo.setVisible(true);

        javax.swing.GroupLayout jInternalFrameCuerpoLayout = new javax.swing.GroupLayout(jInternalFrameCuerpo.getContentPane());
        jInternalFrameCuerpo.getContentPane().setLayout(jInternalFrameCuerpoLayout);
        jInternalFrameCuerpoLayout.setHorizontalGroup(
            jInternalFrameCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrameCuerpoLayout.setVerticalGroup(
            jInternalFrameCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Mandali", 0, 13)); // NOI18N

        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setFont(new java.awt.Font("Mandali", 0, 13)); // NOI18N

        jMenuCliente.setText("Clientes");
        jMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClienteActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuCliente);

        jMenuBar1.add(jMenuArchivo);

        jMenuInformacion.setText("Informacion");
        jMenuInformacion.setFont(new java.awt.Font("Mandali", 0, 13)); // NOI18N
        jMenuBar1.add(jMenuInformacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrameNotificaciones, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jInternalFrameCuerpo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrameNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrameCuerpo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuClienteActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    public JMenuItem getjMenuCliente() {
        return jMenuCliente;
    }

    public JInternalFrame getjInternalFrameCuerpo() {
        return jInternalFrameCuerpo;
    }

    public JInternalFrame getjInternalFrameNotificaciones() {
        return jInternalFrameNotificaciones;
    }

  
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrameCuerpo;
    private javax.swing.JInternalFrame jInternalFrameNotificaciones;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCliente;
    private javax.swing.JMenu jMenuInformacion;
    // End of variables declaration//GEN-END:variables
}
