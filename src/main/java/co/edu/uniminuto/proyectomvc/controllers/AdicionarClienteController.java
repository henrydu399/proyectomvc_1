/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Cliente;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.views.clients.AdicionarClienteView;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class AdicionarClienteController {

    private PrincipalModel principalModel;

    private AdicionarClienteView adicionarClienteView;

   

    public AdicionarClienteController(PrincipalModel principalModel) {
        this.principalModel = principalModel;
        this.adicionarClienteView = new AdicionarClienteView();
        this.adicionarClienteView.setSize(500, 400);

     
        

        this.adicionarClienteView.getjButtonGuardarCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save(evt);
            }
        });

        this.adicionarClienteView.getjButtonRegresar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar(evt);
            }
        });

    }

    public void save(java.awt.event.ActionEvent evt) {
        String nombre = this.adicionarClienteView.getjTextNombre().getText();
        String Telefono = this.adicionarClienteView.getjTextTelefono().getText();
        String cedula = this.adicionarClienteView.getjTextCedula().getText();
        String edad = (String) this.adicionarClienteView.getjComboEdad().getSelectedItem();
        if (Objects.isNull(nombre) || nombre.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo nombre no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }
        if (Objects.isNull(cedula) || cedula.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo cedula no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }
        if (Objects.isNull(Telefono) || Telefono.isEmpty()) {
            this.principalModel.mostrarMensaje("El campo Telefono no puede estar vacio", MensajeController.TipoMensajeEnum.ALERTA);
            return;
        }
        

        Cliente c =  new Cliente(Telefono, nombre, cedula, Integer.parseInt(edad) );
        
        try {
            boolean clienteExiste = this.principalModel.existeCliente(c);
            if(clienteExiste){
                this.principalModel.mostrarMensaje("Ya existe un cliente con esos datos", MensajeController.TipoMensajeEnum.ALERTA);
                return;
            }
        } catch (ApplicationException ex) {
            this.principalModel.mostrarMensaje("Error consultado si existe el cliente", MensajeController.TipoMensajeEnum.ERROR);
            Logger.getLogger(AdicionarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            this.principalModel.guardarCliente(c);
            
            this.principalModel.cargarClientes();
            this.principalModel.mostrarMensaje("Se guardo el cliente correctamente", MensajeController.TipoMensajeEnum.CORRECTO);
            
            this.clear ();
            this.principalModel.switchView(this.principalModel.getGestorClienteController().getGestionClienteView());
            
            
        } catch (ApplicationException ex) {
            this.principalModel.mostrarMensaje("Error al guardar el cliente", MensajeController.TipoMensajeEnum.ERROR);
            Logger.getLogger(AdicionarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void clear (){
        this.adicionarClienteView.getjTextNombre().setText("");
        this.adicionarClienteView.getjTextTelefono().setText("");
        this.adicionarClienteView.getjTextCedula().setText("");
        
        this.adicionarClienteView.getjComboEdad().setSelectedItem("0");
    }

    public void regresar(java.awt.event.ActionEvent evt) {
        this.principalModel.switchView(this.principalModel.getGestorClienteController().getGestionClienteView());
    }

    public AdicionarClienteView getAdicionarClienteView() {
        return adicionarClienteView;
    }

  

}
