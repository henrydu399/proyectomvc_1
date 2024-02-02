
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.utils.ViewUtil;
import co.edu.uniminuto.proyectomvc.views.PrincipalView;
import java.awt.Color;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            this.principalModel.cargarClientes();
        } catch (ApplicationException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            this.principalModel.mostrarMensaje("Error cargando los clientes", MensajeController.TipoMensajeEnum.ALERTA);
        }

        
        this.principalModel.switchView(this.principalModel.getGestorClienteController().getGestionClienteView());
        
         if( Objects.nonNull(this.principalModel.getListaClientes()) &&  this.principalModel.getListaClientes().size() > 0 ){
            this.principalModel.mostrarMensaje("SE CARGARON LOS CLIENTES CORRECTAMENTE", MensajeController.TipoMensajeEnum.CORRECTO);
        }else{
            this.principalModel.mostrarMensaje("NO SE ENCONTRARON CLIENTES", MensajeController.TipoMensajeEnum.ALERTA);
        }
        
        
    }
    
    

    public PrincipalView getPrincipalView() {
        return principalView;
    }
    
    
    
    
    
    
}
