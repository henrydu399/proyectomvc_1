/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.controllers;

import co.edu.uniminuto.proyectomvc.models.PrincipalModel;
import co.edu.uniminuto.proyectomvc.views.clients.GestionCLienteView;


public class GestorClienteController {
    
    private PrincipalModel principalModel;
    private GestionCLienteView gestionClienteView;
    
     private   String[] columnNames = {  "ID","CEDULA", "NOMBRE", "TELEFONO" };

    public GestorClienteController(PrincipalModel _principalModel) {
        this.principalModel= _principalModel;
        this.gestionClienteView =  new GestionCLienteView();
        this.gestionClienteView.setSize(1080,518);
        
        iniciarJtableClientes();
        
    }

    public GestionCLienteView getGestionClienteView() {
        return gestionClienteView;
    }
    
    
    private void iniciarJtableClientes(){
          this.gestionClienteView.getjTableClientes().setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            this.columnNames
        ));
    }
    
    
    
    
}
