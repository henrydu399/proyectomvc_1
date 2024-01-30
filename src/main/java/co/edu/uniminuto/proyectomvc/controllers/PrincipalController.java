
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.views.PrincipalView;
import java.awt.Color;
import javax.swing.JPanel;




public class PrincipalController {
    
    private PrincipalModel principalModel;
    private PrincipalView principalView;

    public PrincipalController(PrincipalModel _principalModel) {
        this.principalModel = _principalModel;
        this.principalView =  new PrincipalView();
        
        this.principalView.getjMenuCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showViewGestorCliente(evt);
            }
        });
        
    }
    
    
    public void show(){
        this.principalView.setVisible(true);
    }
    
    public void showViewGestorCliente(java.awt.event.ActionEvent evt){

        
        this.principalView.getContentPane().add ( this.principalModel.getGestorClienteController().getGestionClienteView());
        this.principalView.pack();
        //this.principalView.revalidate();
        //this.principalView.repaint();
      
    }
    
    
}
